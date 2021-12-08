package ru.itmo.mse.dataflow.datagen.collector.callsensitive

import ru.itmo.mse.dataflow.datagen.collector.ASSIGNMENT_FROM_CONST
import ru.itmo.mse.dataflow.datagen.collector.CollectorFabric
import ru.itmo.mse.dataflow.datagen.collector.Tuple
import ru.itmo.mse.dataflow.datagen.collector.insensitive.AssignmentFromCollector
import ru.itmo.mse.dataflow.lang.ast.AssignStatement
import ru.itmo.mse.dataflow.lang.ast.ConstInt
import ru.itmo.mse.dataflow.lang.ast.Program
import ru.itmo.mse.dataflow.lang.ast.Variable

open class AssignmentFromCallSensitiveCollector(program: Program): AssignmentFromCollector(program) {
    object Fabric: CollectorFabric {
        override fun createCollector(program: Program) = AssignmentFromCallSensitiveCollector(program)
    }

    override fun makeAssignmentFromConst(assignment: AssignStatement, v: Variable, const: ConstInt): Tuple {
        val method = resolver.resolve(v)
        return Tuple(ASSIGNMENT_FROM_CONST, resolver.makeVarName(v), const.value, method.name)
    }
}