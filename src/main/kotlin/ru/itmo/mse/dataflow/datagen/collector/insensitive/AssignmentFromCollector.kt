package ru.itmo.mse.dataflow.datagen.collector.insensitive

import ru.itmo.mse.dataflow.datagen.collector.*
import ru.itmo.mse.dataflow.lang.ast.*
import ru.itmo.mse.dataflow.lang.semantic.FunctionScopeResolver

open class AssignmentFromCollector(program: Program): CollectorBase(program) {
    object Fabric: CollectorFabric {
        override fun createCollector(program: Program) = AssignmentFromCollector(program)
    }

    protected val resolver = FunctionScopeResolver(program)

    override fun collectFromStatement(statement: Statement): List<Tuple> {
        return when (statement) {
            is AssignStatement -> {
                collectFromAssignment(statement, statement.variable, statement.expr)
            }
            is FunctionCallStatement -> listOf()
            is ReturnStatement -> listOf()
            is IfStatement -> (collectFromScope(statement.trueBranch) + collectFromScope(statement.falseBranch)).toList()
        }
    }

    override fun collectFromVarDeclaration(varDecl: VarDeclaration): List<Tuple> {
        TODO()
    }

    private fun collectFromAssignment(assignment: AssignStatement, v: Variable, expr: Expression): List<Tuple> {
        val tuple = when (expr) {
            is ConstInt -> makeAssignmentFromConst(assignment, v, expr)
            is Variable -> makeAssignmentFromVar(assignment, v, expr)
            is FunctionCall -> makeAssignmentFromCall(assignment, v, expr)
        }
        return listOf(tuple)
    }

    override fun collectFromFuncDef(funDef: FunctionDefinition): List<Tuple> {
        return listOf()
    }

    protected open fun makeAssignmentFromVar(assignment: AssignStatement, v: Variable, expr: Variable): Tuple {
        return Tuple(ASSIGNMENT_FROM_VAR, resolver.makeVarName(v), resolver.makeVarName(expr))
    }

    protected open fun makeAssignmentFromConst(assignment: AssignStatement, v: Variable, const: ConstInt): Tuple {
        return Tuple(ASSIGNMENT_FROM_CONST, resolver.makeVarName(v), const.value)
    }

    protected open fun makeAssignmentFromCall(assignment: AssignStatement, v: Variable, call: FunctionCall): Tuple {
        return Tuple(ASSIGNMENT_FROM_CALL, resolver.makeVarName(v), NameUtils.makeInvocation(call))
    }
}
