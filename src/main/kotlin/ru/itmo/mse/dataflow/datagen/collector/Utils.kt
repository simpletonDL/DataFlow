package ru.itmo.mse.dataflow.datagen.collector

import ru.itmo.mse.dataflow.lang.ast.FunctionCall
import ru.itmo.mse.dataflow.lang.ast.Position

class NameUtils {
    companion object {
        fun makePosition(pos: Position): String {
            return "${pos.line}:${pos.pos}"
        }

        fun makeInvocation(funcCall: FunctionCall): String {
            return "${makePosition(funcCall.position)}:${funcCall.funcName}"
        }
    }
}