package ru.itmo.mse.dataflow.datagen.collector.flowsensitive

import ru.itmo.mse.dataflow.datagen.collector.Collector
import ru.itmo.mse.dataflow.datagen.collector.CollectorFabric
import ru.itmo.mse.dataflow.datagen.collector.START_NODE
import ru.itmo.mse.dataflow.datagen.collector.Tuple
import ru.itmo.mse.dataflow.datagen.collector.callsensitive.FunctionInfoCallSensitiveCollector
import ru.itmo.mse.dataflow.lang.ast.FunctionCall
import ru.itmo.mse.dataflow.lang.ast.FunctionDefinition
import ru.itmo.mse.dataflow.lang.ast.Program
import ru.itmo.mse.dataflow.lang.ast.ReturnStatement

class FunctionInfoFlowSensitiveCollector(program: Program): FunctionInfoCallSensitiveCollector(program) {
    object Fabric : CollectorFabric {
        override fun createCollector(program: Program): Collector {
            return FunctionInfoFlowSensitiveCollector(program)
        }

    }

    private val cfg = ControlFowGraphBuilder(program).build()

    override fun collectFromFuncDef(funDef: FunctionDefinition): List<Tuple> {
        val tuples = super.collectFromFuncDef(funDef)
        val startStmtTuple = Tuple(START_NODE, funDef.name, cfg.getVertexNode(funDef).toString())
        return tuples + startStmtTuple
    }

    override fun makeCallInfo(funCall: FunctionCall): Tuple {
        val tuple = super.makeCallInfo(funCall)
        tuple.addAttr(cfg.getVertexNode(funCall).toString())
        return tuple
    }

    override fun makeReturn(returnStatement: ReturnStatement): List<Tuple> {
        val tuples = super.makeReturn(returnStatement)
        tuples.forEach { it.addAttr(cfg.getVertexNode(returnStatement).toString()) }
        return tuples
    }
}