package ru.itmo.mse.dataflow.datagen.collector.insensitive

import ru.itmo.mse.dataflow.datagen.collector.*
import ru.itmo.mse.dataflow.lang.ast.*
import ru.itmo.mse.dataflow.lang.semantic.FunctionScopeResolver

open class FunctionInfoCollector(program: Program): CollectorBase(program) {
    protected val resolver = FunctionScopeResolver(program)

    object Fabric: CollectorFabric {
        override fun createCollector(program: Program) = FunctionInfoCollector(program)
    }

    override fun collectFromFuncDef(funDef: FunctionDefinition): List<Tuple> {
        return funDef.args.withIndex().map { (i, arg) ->
            Tuple(FORMAL_ARG, funDef.name, i, resolver.makeVarName(arg.variable))
        }
    }

    override fun collectFromVarDeclaration(varDecl: VarDeclaration): List<Tuple> {
        return when (val expr = varDecl.initExpr) {
            is FunctionCall -> makeCall(expr)
            else -> listOf()
        }
    }

    override fun collectFromStatement(statement: Statement): List<Tuple> {
        return when (statement) {
            is AssignStatement -> {
                when (val expr = statement.expr) {
                    // x = f(x, y, z)
                    is FunctionCall -> makeCall(expr)
                    else -> listOf()
                }
            }
            is FunctionCallStatement -> makeCall(statement.call)
            is ReturnStatement -> makeReturn(statement)
            is IfStatement -> (collectFromScope(statement.trueBranch) + collectFromScope(statement.falseBranch)).toList()
        }
    }

    open protected fun makeReturn(returnStatement: ReturnStatement): List<Tuple> {
        val methodName = resolver.resolve(returnStatement).name
        val tuple = when(val expr = returnStatement.expr) {
            is ConstInt -> Tuple(RETURN_CONST, methodName, expr.value)
            is Variable -> Tuple(RETURN_VAR, methodName, resolver.makeVarName(expr))
            else -> throw FactCollectionException("Expression $expr is not allowed in return stmt")
        }
        return listOf(tuple)
    }

    private fun makeCall(funCall: FunctionCall): List<Tuple> {
        val invo = NameUtils.makeInvocation(funCall)
        val actualArguments = funCall.args.withIndex().map { (i, arg) ->
            when (arg) {
                is ConstInt -> Tuple(ACTUAL_CONST_ARG, invo, i, arg.value)
                is Variable -> Tuple(ACTUAL_VAR_ARG, invo, i, resolver.makeVarName(arg))
                else -> throw FactCollectionException("Function call argument $arg is not supported")
            }
        }
        val callInfo = makeCallInfo(funCall)
        return actualArguments + listOf(callInfo)
    }

    protected open fun makeCallInfo(funCall: FunctionCall): Tuple {
        val invo = NameUtils.makeInvocation(funCall)
        return Tuple(FUNCTION_CALL_INFO, invo, funCall.funcName)
    }
}