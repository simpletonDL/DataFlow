// Generated from SimpleLang.g4 by ANTLR 4.9.3

    package ru.itmo.mse.dataflow.lang;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLangParser}.
 */
public interface SimpleLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimpleLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(SimpleLangParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(SimpleLangParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#funDef}.
	 * @param ctx the parse tree
	 */
	void enterFunDef(SimpleLangParser.FunDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#funDef}.
	 * @param ctx the parse tree
	 */
	void exitFunDef(SimpleLangParser.FunDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(SimpleLangParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(SimpleLangParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(SimpleLangParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(SimpleLangParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SimpleLangParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SimpleLangParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(SimpleLangParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(SimpleLangParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(SimpleLangParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(SimpleLangParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SimpleLangParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SimpleLangParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimpleLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimpleLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLangParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(SimpleLangParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLangParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(SimpleLangParser.CommentContext ctx);
}