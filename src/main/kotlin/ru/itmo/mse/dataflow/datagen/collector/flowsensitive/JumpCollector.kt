package ru.itmo.mse.dataflow.datagen.collector.flowsensitive

import ru.itmo.mse.dataflow.datagen.collector.*
import ru.itmo.mse.dataflow.lang.ast.ConditionExpression
import ru.itmo.mse.dataflow.lang.ast.EqualityToConstCondition
import ru.itmo.mse.dataflow.lang.ast.Program
import ru.itmo.mse.dataflow.lang.ast.RandomCondition
import ru.itmo.mse.dataflow.lang.semantic.FunctionScopeResolver

class JumpCollector(program: Program): Collector {
    private val cfg = ControlFowGraphBuilder(program).build()
    private val resolver = FunctionScopeResolver(program)

    object Fabric: CollectorFabric {
        override fun createCollector(program: Program): Collector {
            return JumpCollector(program)
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun collect(): Set<Tuple> {
        return buildSet {
            for ((v, toList) in cfg.g) {
                val nodeInfo = cfg.getNodeInfo(v)
                if (nodeInfo != null && nodeInfo is ConditionExpression) {
                    when (nodeInfo) {
                        is EqualityToConstCondition -> {
                            val varName = resolver.makeVarName(nodeInfo.variable)
                            add(Tuple(EQUALITY_TO_CONST_JUMP, v, toList[0], varName, nodeInfo.const))
                            add(Tuple(NOT_EQUALITY_TO_CONST_JUMP, v, toList[1], varName, nodeInfo.const))
                        }
                        is RandomCondition -> {
                            add(Tuple(UNCONDITIONAL_JUMP, v, toList[0]))
                            add(Tuple(UNCONDITIONAL_JUMP, v, toList[1]))
                        }
                    }
                } else {
                    for (to in toList) {
                        add(Tuple(UNCONDITIONAL_JUMP, v, to))
                    }
                }
            }
        }
    }
}