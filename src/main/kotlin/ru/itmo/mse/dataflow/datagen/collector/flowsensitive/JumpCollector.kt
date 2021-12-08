package ru.itmo.mse.dataflow.datagen.collector.flowsensitive

import ru.itmo.mse.dataflow.datagen.collector.Collector
import ru.itmo.mse.dataflow.datagen.collector.CollectorFabric
import ru.itmo.mse.dataflow.datagen.collector.UNCONDITIONAL_JUMP
import ru.itmo.mse.dataflow.datagen.collector.Tuple
import ru.itmo.mse.dataflow.lang.ast.Program

class JumpCollector(program: Program): Collector {
    private val cfg = ControlFowGraphBuilder(program).build()

    object Fabric: CollectorFabric {
        override fun createCollector(program: Program): Collector {
            return JumpCollector(program)
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun collect(): Set<Tuple> {
        return buildSet {
            for ((v, toList) in cfg.g) {
                for (to in toList) {
                    add(Tuple(UNCONDITIONAL_JUMP, v, to))
                }
            }
        }
    }
}