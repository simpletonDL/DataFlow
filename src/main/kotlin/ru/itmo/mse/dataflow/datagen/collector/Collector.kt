package ru.itmo.mse.dataflow.datagen.collector

import ru.itmo.mse.dataflow.lang.ast.Program

class FactCollectionException(msg: String): Exception(msg)

const val ASSIGNMENT_FROM_CONST = "AssignmentFromConst" // (v: V, const: C)
const val ASSIGNMENT_FROM_VAR = "AssignmentFromVar"     // (v1: V, v2: V)
const val ASSIGNMENT_FROM_CALL = "AssignmentFromCall"   // (v: V, invo: I)

const val FORMAL_ARG = "FormalArg" // (method : M, i : N, arg : V)
const val ACTUAL_CONST_ARG = "ActualConstArg" // (call: I, n : N, const : C)
const val ACTUAL_VAR_ARG = "ActualVarArg" // (call: I, n : N, const : C)

const val FUNCTION_CALL_INFO = "FunctionCallInfo" // (invo: I, method: M)

const val RETURN_CONST = "ReturnConst" // (method: M, const: C)
const val RETURN_VAR = "ReturnVar" // (method: M, var: V)

const val UNCONDITIONAL_JUMP = "UnconditionalJump"
const val EQUALITY_TO_CONST_JUMP = "EqualityToConstJump"
const val NOT_EQUALITY_TO_CONST_JUMP = "NotEqualityToConstJump"

const val START_NODE = "StartNode"

interface Collector {
    fun collect(): Set<Tuple>
}

interface CollectorFabric {
    fun createCollector(program: Program): Collector
}
