grammar query;

//program
program : selectStatment ;
selectStatment : (SELECT  paramSelect)? (FROM  packages)? (WHERE conditions)? (ORDER_BY)? (UNIQUE)?;

//select
paramSelect : paramName (COMMA paramName)* ;
paramName : EXCLAMANTION alias? NAME | alias? NAME (LBRACKET method RBRACKET)? | innerSelect | alias? STAR;

//Package
packages : packageLink (COMMA packageLink)*;
packageLink : packageName (JOIN packageName)* as? | STAR as?;
packageName : EXCLAMANTION? STRING | innerSelect ;


//aliasy uziti
alias : NAME_DOT ;

//aliasy nastaveni
as: AS NAME ;

//conditions
conditions : cond (AND cond)* ;

cond : equal | (EXIST|NOT_EXIST) innerSelect | innerSelect OPERATORS alias? NAME | EXCLAMANTION? alias? NAME;
equal : alias? NAME OPERATORS rightStatment | alias? annotated OPERATORS rightStatment | alias? annotated | alias? METHOD LBRACKET method RBRACKET;

rightStatment : alias? NAME | alias? annotated | STRING | PATTERN;
innerSelect : LPAREN selectStatment RPAREN ;

annotated : (METHOD LBRACKET method RBRACKET index?)? annotatedStatment ;
annotatedStatment : AT_NAME (annotatedParams )*;
annotatedParams : DOT AT_NAME | DOT_NAME index? ;

method : STRING | NAME OPERATORS STRING (COMMA NAME OPERATORS STRING)* | STAR;
index : LBRACKET INT RBRACKET | LBRACKET STAR RBRACKET;

SELECT: [Ss][Ee][Ll][Ee][Cc][Tt];
FROM: [Ff][Rr][Oo][Mm];
WHERE: [Ww][Hh][Ee][Rr][Ee] ;
AND :[Aa][Nn][Dd] ;
EXIST : [Ee][Xx][Ii][Ss][Tt] ;
NOT_EXIST : [Nn][Oo][Tt][ ][Ee][Xx][Ii][Ss][Tt] ;
METHOD : [Mm][Ee][Tt][Hh][Oo][Dd] ;
JOIN : [Jj][Oo][Ii][Nn] ;
OPERATORS : ('='|'!='|'~'|[Ii][Nn]) ;
ORDER_BY: [Oo][Rr][Dd][Ee][Rr][ ][Bb][Yy] ;
UNIQUE: [Uu][Nn][Ii][Qq][Uu][Ee] ;
COMMA: ',' ;

LBRACKET : '[' ;
RBRACKET : ']' ;

LPAREN : '(' ;
RPAREN : ')' ;

EXCLAMANTION : '!' ;
STAR : '*' ;
AT_NAME : '@'LETTER+ ;
DOT : '.' ;
NAME_DOT : LETTER+ '.' ;
DOT_NAME : '.' LETTER+ ;
AS : [Aa][Ss] ;
INT : DIGIT+ ;
fragment DIGIT : '0'..'9' ;

NAME : LETTER+ ;
fragment LETTER: ('a'..'z'|'A'..'Z');
PATTERN : 'r' '\'' ( ESC | . )*? '\'' ;
STRING : '\'' ( ESC | . )*? '\'' ;
fragment ESC : '\\' [btnr"\\] ; // \b, \t, \n etc...

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines