grammar SimpleLang;

@header {
    package ru.itmo.mse.dataflow.lang;
}

program : (funDef | comment)*;

// Scope declarations
varDecl : 'var' ID ':' TYPE_ID '=' expr ';';

// Function definitions
funDef : 'fun' ID '(' (arg (',' arg)*)? ')' '{' scope '}' ;

arg: ID ':' TYPE_ID;

// Scope
scope : varDecl* (stmt ';')*;

// Statements
stmt : assignStmt | functionCall | returnStmt;

assignStmt : ID '=' expr;
returnStmt : 'return' expr;
functionCall: ID '(' (expr (',' expr)*)? ')';

// Exspression
expr : CONST | ID | functionCall;

// Comment
comment
 : (SingleLineComment | MultiLineComment)
 ;

SingleLineComment
 : '//' ~('\r' | '\n')*
 ;

MultiLineComment
 : '/*' .* '*/'
 ;

// Constatns
IF : 'if' ;

WHILE : 'while';

ID : [a-z]+[0-9]*;

TYPE_ID : [A-Z][a-z]*;

CONST : [0-9]+;

ENDLINE : ';' ;

LPAREN : '(' ;

RPAREN : ')' ;

LBRACE : '{' ;

RBRACE : '}' ;

WS : [ \t\r\n]+ -> skip ;