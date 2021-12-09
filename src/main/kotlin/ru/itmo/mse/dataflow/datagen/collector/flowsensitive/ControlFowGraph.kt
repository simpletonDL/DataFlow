package ru.itmo.mse.dataflow.datagen.collector.flowsensitive

import guru.nidi.graphviz.attribute.Label
import guru.nidi.graphviz.attribute.Shape
import guru.nidi.graphviz.engine.Format
import guru.nidi.graphviz.engine.Graphviz
import guru.nidi.graphviz.graph
import guru.nidi.graphviz.toGraphviz
import ru.itmo.mse.dataflow.lang.ast.*
import java.io.File
import java.nio.file.Paths

class ControlFowGraph {
    private val nodeInfo = mutableMapOf<Int, AstNode>()
    private val nodeInfoReverse = mutableMapOf<AstNode, Int>()

    val g = mutableMapOf<Int, MutableList<Int>>()

    fun insertEdge(v: Int, to: Int) {
        g.getOrPut(v) { mutableListOf() }.add(to)
    }

    fun addNodeInfo(v: Int, astNode: AstNode) {
        nodeInfo[v] = astNode
        nodeInfoReverse[astNode] = v
    }

    fun getNodeInfo(v: Int): AstNode? {
        return nodeInfo[v]
    }

    fun getVertexNode(astNode: AstNode): Int? {
        return nodeInfoReverse[astNode]
    }

    fun toGraphviz(): Graphviz {
        return graph(directed = true) {
            for ((v, toList) in g) {
                for (to in toList) {
                    v.toString()[Label.lines(*makeNodeLabel(v)), Shape.BOX] -
                    to.toString()[Label.lines(*makeNodeLabel(to)), Shape.BOX]
                }
            }
        }.toGraphviz()
    }

    private fun makeNodeLabel(v: Int): Array<String> {
        val nodeInfo = makeNodeInfo(v)
        return if (nodeInfo == null) { arrayOf("$v") } else { arrayOf("$v", nodeInfo.toString()) }
    }

    private fun makeNodeInfo(v: Int): String? {
        val astNode = nodeInfo[v] ?: return null

        return when (astNode) {
            is FunctionDefinition -> "fun ${astNode.name}"
            is Statement, is ConditionExpression -> astNode.toString()
            else -> null
        }
    }

    override fun toString() = "$nodeInfo\n$g"
}

class ControlFowGraphBuilder(val program: Program) {
    class NodeGen {
        var i = 0
        fun next() : Int {
            i += 1
            return i
        }
    }

    val nodeIdGen = NodeGen()

    fun build(): ControlFowGraph {
        val g = ControlFowGraph()
        for (funDef in program.funDefs) {
            build(funDef, g)
        }
        return g
    }

    private fun build(funDef: FunctionDefinition, g: ControlFowGraph) {
        val enterFunction = nodeIdGen.next()
        g.addNodeInfo(enterFunction, funDef)
        build(enterFunction, funDef.scope.stmts, g)
    }

    private fun build(prevNode: Int, stmts: List<Statement>, g: ControlFowGraph): Int {
        if (stmts.isEmpty()) {
            return prevNode
        } else {
            val stmt = stmts[0]

            if (stmt is IfStatement) {
                val conditionNode = nodeIdGen.next()
                g.insertEdge(prevNode, conditionNode)
                g.addNodeInfo(conditionNode, stmt.condition)

                val lastTrueBranchNode = build(conditionNode, stmt.trueBranch.stmts, g)
                val lastFalseBranchNode = build(conditionNode, stmt.falseBranch.stmts, g)

                val exitIf = nodeIdGen.next()
                g.insertEdge(lastTrueBranchNode, exitIf)
                g.insertEdge(lastFalseBranchNode, exitIf)

                return build(exitIf, stmts.drop(1), g)
            } else {
                val curNode = nodeIdGen.next()
                g.insertEdge(prevNode, curNode)
                if (stmt is AssignStatement && stmt.expr is FunctionCall) {
                    g.addNodeInfo(curNode, stmt.expr)
                }
                if (stmt is FunctionCallStatement) {
                    g.addNodeInfo(curNode, stmt.call)
                }
                g.addNodeInfo(curNode, stmt)
                return build(curNode, stmts.drop(1), g)
            }
        }
    }
}
