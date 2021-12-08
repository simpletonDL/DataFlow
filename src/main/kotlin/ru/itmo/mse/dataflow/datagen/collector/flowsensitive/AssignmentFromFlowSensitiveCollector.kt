package ru.itmo.mse.dataflow.datagen.collector.flowsensitive

import ru.itmo.mse.dataflow.datagen.collector.Collector
import ru.itmo.mse.dataflow.datagen.collector.CollectorFabric
import ru.itmo.mse.dataflow.datagen.collector.FactCollectionException
import ru.itmo.mse.dataflow.datagen.collector.Tuple
import ru.itmo.mse.dataflow.datagen.collector.callsensitive.AssignmentFromCallSensitiveCollector
import ru.itmo.mse.dataflow.lang.ast.*

class AssignmentFromFlowSensitiveCollector(program: Program): AssignmentFromCallSensitiveCollector(program) {
    object Fabric: CollectorFabric {
        override fun createCollector(program: Program): Collector {
            return AssignmentFromFlowSensitiveCollector(program)
        }

    }

    private val graph = ControlFowGraphBuilder(program).build()

    override fun makeAssignmentFromConst(assignment: AssignStatement, v: Variable, const: ConstInt): Tuple {
        val tuple = super.makeAssignmentFromConst(assignment, v, const)
        tuple.addAttr(getCFGVertex(assignment))
        return tuple
    }

    override fun makeAssignmentFromVar(assignment: AssignStatement, v: Variable, expr: Variable): Tuple {
        val tuple = super.makeAssignmentFromVar(assignment, v, expr)
        tuple.addAttr(getCFGVertex(assignment))
        return tuple
    }

    override fun makeAssignmentFromCall(assignment: AssignStatement, v: Variable, call: FunctionCall): Tuple {
        val tuple = super.makeAssignmentFromCall(assignment, v, call)
        tuple.addAttr(getCFGVertex(assignment))
        return tuple
    }

    private fun getCFGVertex(node: AstNode): Int {
        return graph.getVertexNode(node) ?: throw FactCollectionException("Assignment $node is not in cf graph")
    }
}