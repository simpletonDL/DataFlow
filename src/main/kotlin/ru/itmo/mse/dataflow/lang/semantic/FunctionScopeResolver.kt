package ru.itmo.mse.dataflow.lang.semantic

import ru.itmo.mse.dataflow.datagen.collector.FactCollectionException
import ru.itmo.mse.dataflow.lang.ast.*

class FunctionScopeResolver(val program: Program) {
    private val exprMap: MutableMap<Expression, FunctionDefinition> = mutableMapOf()
    private val returnMap: MutableMap<ReturnStatement, FunctionDefinition> = mutableMapOf()
    init {
        for (funcDef in program.funDefs) {
            for (arg in funcDef.args) {
                populateVariable(arg.variable, funcDef)
            }
            populateScope(funcDef, funcDef.scope)
        }
    }

    fun resolve(expr: Expression): FunctionDefinition {
        return exprMap[expr]!!
    }

    fun resolve(returnStmt: ReturnStatement): FunctionDefinition {
        return returnMap[returnStmt]!!
    }

    fun makeVarName(v: Variable): String {
        val funcName = resolve(v).name
        return "$funcName::${v.name}"
    }

    private fun populateScope(funcDef: FunctionDefinition, scope: Scope) {
        for (varDecl in scope.varDecls) {
            populateVariable(varDecl.variable, funcDef)
            populateExpr(varDecl.initExpr, funcDef)
        }
        for (stmt in scope.stmts) {
            val check1 = when (stmt) {
                is AssignStatement -> {
                    populateVariable(stmt.variable, funcDef)
                    populateExpr(stmt.expr, funcDef)
                }
                is FunctionCallStatement -> populateFunctionCall(stmt.call, funcDef)
                is ReturnStatement -> populateReturn(stmt, funcDef)
                is IfStatement -> {
                    populateScope(funcDef, stmt.trueBranch)
                    populateScope(funcDef, stmt.falseBranch)
                    val check2 = when (stmt.condition) {
                        is EqualityToConstCondition -> populateVariable(stmt.condition.variable, funcDef)
                        is RandomCondition -> {}
                    }
                }
            }
        }
    }

    private fun populateReturn(returnStmt: ReturnStatement, funcDef: FunctionDefinition) {
        when (returnStmt.expr) {
            is ConstInt, is Variable -> populateExpr(returnStmt.expr, funcDef)
            else -> throw FactCollectionException("Expr ${returnStmt.expr} is not allowed in return stmt")
        }
        returnMap[returnStmt] = funcDef
    }

    private fun populateExpr(expr: Expression, funcDef: FunctionDefinition) {
        return when (expr) {
            is Variable -> exprMap[expr] = funcDef
            is FunctionCall -> populateFunctionCall(expr, funcDef)
            is ConstInt -> {}
        }
    }

    private fun populateFunctionCall(funCall: FunctionCall, funcDef: FunctionDefinition) {
        exprMap[funCall] = funcDef
        funCall.args.forEach { populateExpr(it, funcDef) }
    }

    private fun populateVariable(v: Variable, funcDef: FunctionDefinition) {
        exprMap[v] = funcDef
    }
}