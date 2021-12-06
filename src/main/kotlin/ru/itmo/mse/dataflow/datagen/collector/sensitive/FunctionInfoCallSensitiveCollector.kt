package ru.itmo.mse.dataflow.datagen.collector.sensitive

import ru.itmo.mse.dataflow.datagen.collector.Collector
import ru.itmo.mse.dataflow.datagen.collector.CollectorFabric
import ru.itmo.mse.dataflow.datagen.collector.NameUtils
import ru.itmo.mse.dataflow.datagen.collector.Tuple
import ru.itmo.mse.dataflow.datagen.collector.insensitive.FunctionInfoCollector
import ru.itmo.mse.dataflow.lang.ast.FunctionCall
import ru.itmo.mse.dataflow.lang.ast.Program

class FunctionInfoCallSensitiveCollector(program: Program): FunctionInfoCollector(program) {
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