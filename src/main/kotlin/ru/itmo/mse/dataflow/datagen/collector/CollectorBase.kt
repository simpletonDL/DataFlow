package ru.itmo.mse.dataflow.datagen.collector

import ru.itmo.mse.dataflow.lang.ast.*

abstract class CollectorBase(protected val program: Program): Collector {
    override fun collect(): Set<Tuple> {
        return program.funDefs.flatMap { funcDef ->
            collectFromScope(funcDef.scope) + collectFromFuncDef(funcDef)
        }.toSet()
    }

    protected fun collectFromScope(scope: Scope): Set<Tuple> {
        val factsFromStmts = scope.stmts.flatMap { stmt -> collectFromStatement(stmt) }.toSet()
        val factsFromDecls = scope.varDecls.flatMap { stmt -> collectFromVarDeclaration(stmt) }.toSet()
        return factsFromStmts + factsFromDecls
    }

    protected abstract fun collectFromFuncDef(funDef: FunctionDefinition): List<Tuple>
    protected abstract fun collectFromVarDeclaration(varDecl: VarDeclaration): List<Tuple>
    protected abstract fun collectFromStatement(statement: Statement): List<Tuple>
}