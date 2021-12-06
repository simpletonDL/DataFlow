package ru.itmo.mse.dataflow

import java.nio.file.Path

class TestCaseInput(val yalPath: Path, val dlPath: Path?)

class TestCaseException(msg: String): Exception(msg)

class Utils {
    companion object {
        fun makeInput(caseDir: Path): TestCaseInput {
            val files = (caseDir.toFile().listFiles() ?: throw TestCaseException("Can't find dir: $caseDir"))
            val dlFile = files.find { it.name.endsWith(".dl") }
            val yalPath = caseDir.resolve(Config.TEST_CASE_PROGRAM_NAME)
            return TestCaseInput(yalPath, dlFile?.toPath())
        }
    }
}