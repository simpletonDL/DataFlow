package ru.itmo.mse.dataflow.printer

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.lang3.StringUtils
import java.io.File
import java.io.FileReader

class CsvPrettyPrinter(val signatures: Map<String, List<String>>?) {
    fun prettyPrintCsv(f: File) {
        val parser = CSVParser(FileReader(f), CSVFormat.newFormat('\t').withRecordSeparator("\r\n"))
        val columnSize = 15
        val lines = parser.toList()

        val relName = f.name.split(".")[0]
        println(">>> $relName <<<")
        if (lines.isNotEmpty()) {
            val columnCount = lines[0].toList().size
            val rawSize = columnCount * columnSize + columnCount + 1

            val signature = signatures?.get(relName)
            if (signature != null) {
                println("+" + ("-".repeat(columnSize) + "+").repeat(columnCount))
                val raw = signature.joinToString("|", "|", "|") {
                    StringUtils.center(it, columnSize)
                }
                println(raw)
            }
            println("+" + ("-".repeat(columnSize) + "+").repeat(columnCount))

            for (line in lines) {
                val columns = line.toList()
                val raw = columns.joinToString("|", "|", "|") {
                    StringUtils.center(it, columnSize)
                }
                println(raw)
            }
            println("+" + ("-".repeat(columnSize) + "+").repeat(columnCount))
        }
    }
}