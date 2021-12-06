package ru.itmo.mse.dataflow.souffle

import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import java.nio.file.Path

class SouffleProvider {
    fun runScript(scriptPath: Path, inputFactsDir: Path, outputFactsDir: Path) {
        FileUtils.forceMkdir(outputFactsDir.toFile())

        val process = ProcessBuilder(
            "souffle",
            "-F${inputFactsDir.toAbsolutePath()}",
            "-D${outputFactsDir.toAbsolutePath()}",
            scriptPath.toAbsolutePath().toString()
        ).start()
        process.waitFor()

        val errors = IOUtils.toString(process.errorStream)
            .split("\n")
            .filter { it.isNotEmpty() && !it.contains("Cannot open fact") }
        if (errors.isNotEmpty()) {
            System.err.println("Souffle:")
            errors.forEach { System.err.println("\t $it") }
        }
    }
}