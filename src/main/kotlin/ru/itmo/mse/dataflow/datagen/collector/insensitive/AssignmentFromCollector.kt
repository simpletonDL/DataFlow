package ru.itmo.mse.dataflow.datagen.collector.insensitive

import ru.itmo.mse.dataflow.datagen.collector.*
import ru.itmo.mse.dataflow.lang.ast.*
import ru.itmo.mse.dataflow.lang.semantic.FunctionScopeResolver

open class AssignmentFromCollector(program: Program): CollectorBase(program) {
    companion object {
        const val ASSIGNMENT_FROM_CONST = "AssignmentFromConst" // (v: V, const: C)
        const val ASSIGNMENT_FROM_VAR = "AssignmentFromVar"     // (v1: V, v2: V)
        const val ASSIGNMENT_FROM_CALL = "AssignmentFromCall"   // (v: V, invo: I)
    }

    object Fabric: CollectorFabric {
        override fun createCollector(program: Program) = AssignmentFromCollector(program)
    }

    protected val resolver = FunctionScopeResolver(program)

    override fun collectFromStatement(statement: Statement): List<Tuple> {
        return when (statement) {
            is AssignStatement -> {
                collectFromAssignment(statement.variable, statement.expr)
            }
            is FunctionCallStatement -> listOf()
            is ReturnStatement -> listOf()
        }
    }

    override fun collectFromVarDeclaration(varDecl: VarDeclaration): List<Tuple> {
        return collectFromAssignment(varDecl.variable, varDecl.initExpr)
    }

    private fun collectFromAssignment(v: Variable, expr: Expression): List<Tuple> {
        val tuple = when (expr) {
            is ConstInt -> makeAssignmentFromConst(v, expr)
            is Variable -> makeAssignmentFromVar(v, expr)
            is FunctionCall -> makeAssignmentFromCall(v, expr)
        }
        return listOf(tuple)
    }

    override fun collectFromFuncDef(funDef: FunctionDefinition): List<Tuple> {
        return listOf()
    }

    protected open fun makeAssignmentFromVar(v: Variable, expr: Variable): Tuple {
        return Tuple(ASSIGNMENT_FROM_VAR, resolver.makeVarName(v), resolver.makeVarName(expr))
    }

    protected open fun makeAssignmentFromConst(v: Variable, const: ConstInt): Tuple {
        return Tuple(ASSIGNMENT_FROM_CONST, resolver.makeVarName(v), const.value)
    }

    protected open fun makeAssignmentFromCall(v: Variable, call: FunctionCall): Tuple {
        return Tuple(ASSIGNMENT_FROM_CALL, resolver.makeVarName(v), NameUtils.makeInvocation(call))
    }
}
