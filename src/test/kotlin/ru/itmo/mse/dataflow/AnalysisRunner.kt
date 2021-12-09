package ru.itmo.mse.dataflow

import guru.nidi.graphviz.engine.Format
import org.apache.commons.io.FileUtils
import ru.itmo.mse.dataflow.datagen.SouffleInputBuilder
import ru.itmo.mse.dataflow.datagen.collector.*
import ru.itmo.mse.dataflow.datagen.collector.CollectorFabric
import ru.itmo.mse.dataflow.datagen.collector.insensitive.AssignmentFromCollector
import ru.itmo.mse.dataflow.datagen.collector.insensitive.FunctionInfoCollector
import ru.itmo.mse.dataflow.datagen.collector.callsensitive.AssignmentFromCallSensitiveCollector
import ru.itmo.mse.dataflow.datagen.collector.callsensitive.FunctionInfoCallSensitiveCollector
import ru.itmo.mse.dataflow.datagen.collector.flowsensitive.AssignmentFromFlowSensitiveCollector
import ru.itmo.mse.dataflow.datagen.collector.flowsensitive.ControlFowGraphBuilder
import ru.itmo.mse.dataflow.datagen.collector.flowsensitive.FunctionInfoFlowSensitiveCollector
import ru.itmo.mse.dataflow.datagen.collector.flowsensitive.JumpCollector
import ru.itmo.mse.dataflow.lang.ast.Converter
import ru.itmo.mse.dataflow.printer.CsvPrettyPrinter
import ru.itmo.mse.dataflow.souffle.SouffleProvider
import java.io.File
import java.nio.file.Paths
import kotlin.io.path.exists


val insensitive = listOf(AssignmentFromCollector.Fabric, FunctionInfoCollector.Fabric)
val call_sensitive = listOf(AssignmentFromCallSensitiveCollector.Fabric, FunctionInfoCallSensitiveCollector.Fabric)
val flow_sensitive = listOf(AssignmentFromFlowSensitiveCollector.Fabric, JumpCollector.Fabric, FunctionInfoFlowSensitiveCollector.Fabric)

fun main() {
    val runner = TestCaseRunner()
//    runner.runTestCase("1-insensitive-simple", insensitive)
//    runner.runTestCase("2-insensitive-function-call", insensitive)
    runner.runTestCase("3-call-sensitive", call_sensitive, true)
//    runner.runTestCase("4-flow-sensitive", flow_sensitive, true)
}
