package ru.itmo.mse.dataflow

import guru.nidi.graphviz.engine.Format
import org.apache.commons.io.FileUtils
import ru.itmo.mse.dataflow.datagen.SouffleInputBuilder
import ru.itmo.mse.dataflow.datagen.collector.*
import ru.itmo.mse.dataflow.datagen.collector.flowsensitive.ControlFowGraphBuilder
import ru.itmo.mse.dataflow.lang.ast.Converter
import ru.itmo.mse.dataflow.printer.CsvPrettyPrinter
import ru.itmo.mse.dataflow.souffle.SouffleProvider
import java.io.File
import java.nio.file.Paths
import kotlin.io.path.exists

val inputFactsOrder = listOf(
    ASSIGNMENT_FROM_CONST,
    ASSIGNMENT_FROM_VAR,
    ASSIGNMENT_FROM_CALL,

    FUNCTION_CALL_INFO,
    FORMAL_ARG,
    ACTUAL_CONST_ARG,
    ACTUAL_VAR_ARG,

    RETURN_CONST,
    RETURN_VAR,
    UNCONDITIONAL_JUMP
)

class TestCaseRunner {
    private val testDir = Paths.get("src/test")
    private val inputDir = testDir.resolve("input")
    private val outputDir = testDir.resolve("output")

    @OptIn(ExperimentalStdlibApi::class)
    private fun collectSignatures(dlFile: File): Map<String, List<String>> {
        return buildMap {
            for (line in FileUtils.readFileToString(dlFile).split("\n")) {
                if (line.startsWith(".decl")) {
                    val parts = line.split("(")
                    val relName = parts[0].split(" ")[1].trim()
                    val args = parts[1].dropLast(1).split(",").map { it.split(":")[0].trim() }
                    put(relName, args)
                }
            }
        }
    }

    fun buildCFGraph(testCaseDirName: String) {
        val inputDir = inputDir.resolve(testCaseDirName)
        val input = Utils.makeInput(inputDir)

        val program = Converter().convert(input.yalPath)
        val cfg = ControlFowGraphBuilder(program).build()

        val picturesDir = Paths.get("pictures").toFile()
        if (!picturesDir.exists()) {
            FileUtils.forceMkdir(picturesDir)
        }
        cfg.toGraphviz().render(Format.SVG).toFile(picturesDir.resolve(testCaseDirName))
    }

    fun runTestCase(testCaseDirName: String, collectors: List<CollectorFabric>, runSouffle: Boolean = true) {
        val inputDir = inputDir.resolve(testCaseDirName)
        val input = Utils.makeInput(inputDir)

        val signatures = if (input.dlPath != null) { collectSignatures(input.dlPath.toFile()) } else { null }
        val printer = CsvPrettyPrinter(signatures)

        val dataGen = SouffleInputBuilder(*collectors.toTypedArray())

        val outputDir = outputDir.resolve(testCaseDirName)
        if (outputDir.exists()) {
            FileUtils.forceDelete(outputDir.toFile())
        }
        val souffleInputFactsDir = outputDir.resolve("input")
        val souffleOutputFactsDir = outputDir.resolve("output")

        dataGen.genData(souffleInputFactsDir, input.yalPath)

        println("INPUT FACTS:")

        fun inputFactsKey(fileName: String): Int {
            val idx = inputFactsOrder.indexOf(fileName.split(".")[0])
            if (idx == -1) {
                return inputFactsOrder.size
            } else {
                return idx
            }
        }

        for (f in souffleInputFactsDir.toFile().listFiles()!!.sortedBy { inputFactsKey(it.name) }) {
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
