package ru.itmo.mse.dataflow.datagen.collector.callsensitive

import ru.itmo.mse.dataflow.datagen.collector.*
import ru.itmo.mse.dataflow.datagen.collector.insensitive.FunctionInfoCollector
import ru.itmo.mse.dataflow.lang.ast.FunctionCall
import ru.itmo.mse.dataflow.lang.ast.FunctionDefinition
import ru.itmo.mse.dataflow.lang.ast.Program

open class FunctionInfoCallSensitiveCollector(program: Program): FunctionInfoCollector(program) {
    object Fabric: CollectorFabric {
        override fun createCollector(program: Program): Collector {
            return FunctionInfoCallSensitiveCollector(program)
        }
    }

    override fun makeCallInfo(funCall: FunctionCall): Tuple {
        val invo = NameUtils.makeInvocation(funCall)
        val method = resolver.resolve(funCall)
        return Tuple(FUNCTION_CALL_INFO, method.name, invo, funCall.funcName)
    }
}