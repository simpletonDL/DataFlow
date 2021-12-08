package ru.itmo.mse.dataflow.lang.ast

import java.util.concurrent.locks.Condition

data class Position(val line: Int, val pos: Int) {
    override fun toString() = "$line:$pos"
}

sealed class AstNode(val position: Position)

class Program(position: Position,
              val funDefs: List<FunctionDefinition>) : AstNode(position) {
    override fun toString() = "$funDefs"
}

class FunctionDefinition(val name: String,
                         val args: List<FormalArg>,
                         val scope: Scope,
                         position: Position): AstNode(position) {
    override fun toString() = "fun $name (${args.joinToString()}) $scope"
}

class FormalArg(val variable: Variable, val type: String) {
    override fun toString() = "$variable: $type"
}

class Scope(position: Position,
            val varDecls: List<VarDeclaration>,
            val stmts: List<Statement>) : AstNode(position) {
    override fun toString() = "{ decls=$varDecls; stmts=$stmts}"
}

// Declarations
class VarDeclaration(position: Position,
                     val variable: Variable,
                     val type: String,
                     val initExpr: Expression) : AstNode(position) {
    override fun toString() = "${variable.name}: $type = $initExpr"
}

// Statements
sealed class Statement(position: Position) : AstNode(position)

class AssignStatement(position: Position,
                      val variable: Variable,
                      val expr: Expression) : Statement(position) {
    override fun toString() = "${variable.name} = $expr"
}

class FunctionCallStatement(position: Position,
                            val call: FunctionCall) : Statement(position) {
    override fun toString() = call.toString()
}

class ReturnStatement(position: Position, val expr: Expression): Statement(position) {
    override fun toString() = "return $expr"
}

class IfStatement(position: Position,
                  val condition: ConditionExpression,
                  val trueBranch: Scope,
                  val falseBranch: Scope): Statement(position) {
    override fun toString() = "if ($condition) $trueBranch $falseBranch"
}

sealed class ConditionExpression(position: Position): AstNode(position)

class EqualityToConstCondition(position: Position,
                               val variable: Variable,
                               val const: ConstInt): ConditionExpression(position) {
    override fun toString() = "$variable == $const"
}

// Expressions
sealed class Expression(position: Position): AstNode(position)

class Variable(position: Position,
               val name: String): Expression(position) {
    override fun toString() = name
}

class ConstInt(position: Position,
               val value: Int): Expression(position) {
    override fun toString() = "$value"
}

class FunctionCall(position: Position,
                   val funcName: String,
                   val args: List<Expression>): Expression(position) {
    override fun toString() = "$funcName(${args.joinToString()})"
}