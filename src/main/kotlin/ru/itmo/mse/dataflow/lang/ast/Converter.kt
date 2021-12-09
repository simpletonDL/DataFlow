package ru.itmo.mse.dataflow.lang.ast

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.misc.ParseCancellationException
import org.antlr.v4.runtime.tree.TerminalNode
import ru.itmo.mse.dataflow.lang.SimpleLangLexer
import ru.itmo.mse.dataflow.lang.SimpleLangParser
import ru.itmo.mse.dataflow.lang.SimpleLangParser.*
import java.nio.file.Path

class ParseError : BaseErrorListener() {
    override fun syntaxError(
        recognizer: Recognizer<*, *>?,
        offendingSymbol: Any?,
        line: Int,
        charPositionInLine: Int,
        msg: String?,
        e: RecognitionException?
    ) {
        throw ParseCancellationException("In line $line:$charPositionInLine: $msg")
    }
}

class ConverterException(msg: String): Exception(msg)

class Converter {
    fun convert(path: Path): Program {
        val inputStream = CharStreams.fromFileName(path.toAbsolutePath().toString())
        val lexer = SimpleLangLexer(inputStream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(ParseError())

        val tokens = CommonTokenStream(lexer)

        val parser = SimpleLangParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(ParseError())

        val program = parser.program()
        return program.convert()
    }

    private fun ProgramContext.convert(): Program {
        val funDefs = funDef().map { it.convert() }
        return Program(start.makePos(), funDefs)
    }

    private fun FunDefContext.convert(): FunctionDefinition {
        val name = ID().text
        val args = arg().map { it.convert() }
        val scope = scope().convert()
        return FunctionDefinition(name, args, scope, start.makePos())
    }

    private fun ArgContext.convert(): FormalArg {
        return FormalArg(Variable(start.makePos(), ID().text), TYPE_ID().text)
    }

    private fun ScopeContext.convert(): Scope {
        return Scope(start.makePos(), varDecl().map { it.convert() }, stmt().map { it.convert() })
    }

    // Statements
    private fun StmtContext.convert(): Statement {
        val assign: AssignStmtContext? = assignStmt()
        val functionCall: FunctionCallContext? = functionCall()
        val returnStmt: ReturnStmtContext? = returnStmt()
        val ifStmt: IfStmtContext? = ifStmt()

        val pos = start.makePos()
        return when {
            assign != null ->
                AssignStatement(pos, Variable(assign.start.makePos(), assign.ID().text), assign.expr().convert())
            functionCall != null -> {
                val args = functionCall.expr().map { it.convert() }
                FunctionCallStatement(pos, FunctionCall(functionCall.stop.makePos(), functionCall.ID().text, args))
            }
            returnStmt != null ->
                ReturnStatement(pos, returnStmt.expr().convert())
            ifStmt != null -> {
                IfStatement(pos, ifStmt.condition().convert(), ifStmt.scope(0).convert(), ifStmt.scope(1).convert())
            }
            else -> throw ConverterException("Assignment $text is not converted")
        }
    }

    private fun ConditionContext.convert(): ConditionExpression {
        val equality = equality();
        val random = random();

        val pos = start.makePos()
        return when {
            equality != null ->
                EqualityToConstCondition(pos, Variable(pos, equality.ID().text), ConstInt(pos, equality.CONST().text.toInt()))
            random != null -> RandomCondition(pos)
            else -> throw ConverterException(":(")
        }
    }

    private fun VarDeclContext.convert(): VarDeclaration {
        return VarDeclaration(start.makePos(), Variable(start.makePos(), ID().text), TYPE_ID().text, expr().convert())
    }

    private fun ExprContext.convert(): Expression {
        val const: TerminalNode? = CONST()
        val varID: TerminalNode? = ID()
        val functionCall: FunctionCallContext? = functionCall()
        return when {
            const != null -> ConstInt(start.makePos(), const.text.toInt())
            varID != null -> Variable(start.makePos(), varID.text)
            functionCall != null -> {
                val args = functionCall.expr().map { it.convert() }
                FunctionCall(functionCall.stop.makePos(), functionCall.ID().text, args)
            }
            else -> throw ConverterException("Value at ${start.makePos()} is not converted!")
        }
    }

    private fun Token.makePos(): Position {
        return Position(line, charPositionInLine)
    }
}
