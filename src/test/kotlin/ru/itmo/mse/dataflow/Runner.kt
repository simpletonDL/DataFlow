package ru.itmo.mse.dataflow

import org.apache.commons.io.FileUtils
import org.apache.commons.lang3.StringUtils
import ru.itmo.mse.dataflow.datagen.SouffleInputBuilder
import ru.itmo.mse.dataflow.datagen.collector.CollectorFabric
import ru.itmo.mse.dataflow.datagen.collector.insensitive.AssignmentFromCollector
import ru.itmo.mse.dataflow.datagen.collector.insensitive.FunctionInfoCollector
import ru.itmo.mse.dataflow.datagen.collector.sensitive.AssignmentFromCallSensitiveCollector
import ru.itmo.mse.dataflow.datagen.collector.sensitive.FunctionInfoCallSensitiveCollector
import ru.itmo.mse.dataflow.printer.CsvPrettyPrinter
import ru.itmo.mse.dataflow.souffle.SouffleProvider
import java.io.File
import java.nio.file.Paths
import kotlin.io.path.exists


class TestCaseRunner {
    private val testDir = Paths.get("src/test")
    private val inputDir = testDir.resolve("input")
    private val outputDir = testDir.resolve("output")

    fun runTestCase(testCaseDirName: String, collectors: List<CollectorFabric>, runSouffle: Boolean = true) {
        val inputDir = inputDir.resolve(testCaseDirName)
        val input = Utils.makeInput(inputDir)
        val printer = CsvPrettyPrinter()

        val dataGen = SouffleInputBuilder(*collectors.toTypedArray())

        val outputDir = outputDir.resolve(testCaseDirName)
        if (outputDir.exists()) {
            FileUtils.forceDelete(outputDir.toFile())
        }
        val souffleInputFactsDir = outputDir.resolve("input")
        val souffleOutputFactsDir = outputDir.resolve("output")

        dataGen.genData(souffleInputFactsDir, input.yalPath)

        println("INPUT FACTS:")
        for (f in souffleInputFactsDir.toFile().listFiles()!!.sortedBy { it.name }) {
            printer.prettyPrintCsv(f)
            println()
        }

        if (runSouffle) {
            if (input.dlPath == null) {
                throw TestCaseException("No .dl file inside $inputDir")
            }
            if (souffleOutputFactsDir.toFile().exists()) {
                FileUtils.forceDelete(souffleOutputFactsDir.toFile())
            }
            FileUtils.forceMkdir(souffleOutputFactsDir.toFile())

            SouffleProvider().runScript(input.dlPath, souffleInputFactsDir, souffleOutputFactsDir)
            println("OUTPUT FACTS:")
            for (f in souffleOutputFactsDir.toFile().listFiles()!!.sortedBy { it.name }) {
                printer.prettyPrintCsv(f)
                println()
            }
        }
    }
}

val insensitive = listOf(AssignmentFromCollector.Fabric, FunctionInfoCollector.Fabric)
val call_sensitive = listOf(AssignmentFromCallSensitiveCollector.Fabric, FunctionInfoCallSensitiveCollector.Fabric)

fun main() {
    val runner = TestCaseRunner()
//    runner.runTestCase("1-insensitive-simple", insensitive)
//    runner.runTestCase("2-insensitive-function-call", insensitive)
    runner.runTestCase("3-call-sensitive", call_sensitive, true)
}
