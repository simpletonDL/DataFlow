package ru.itmo.mse.dataflow.datagen

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter
import org.apache.commons.io.FileUtils
import ru.itmo.mse.dataflow.lang.ast.Converter
import ru.itmo.mse.dataflow.datagen.collector.*
import java.io.FileWriter
import java.nio.file.Path

class SouffleInputBuilder(vararg fabrics: CollectorFabric) {
    private val fabrics = fabrics.toList()

    fun genData(outputDir: Path, programPath: Path) {
        val program = Converter().convert(programPath)

        val data = mutableSetOf<Tuple>()
        for (fabric in fabrics) {
            val collectorData = fabric.createCollector(program).collect()
            data += collectorData
        }

        FileUtils.forceMkdir(outputDir.toFile())
        for ((relation, tuples) in data.groupBy { it.relName }) {
            val relPath = outputDir.resolve("$relation.facts")
            val relFile = relPath.toFile()
            FileUtils.touch(relFile)

            val writer = FileWriter(relFile)
            val printer = CSVPrinter(writer, CSVFormat.newFormat('\t').withRecordSeparator("\r\n"))
            for (tuple in tuples) {
                printer.printRecord(tuple.attrs)
            }
            printer.flush()
            printer.close()
        }
    }
}
