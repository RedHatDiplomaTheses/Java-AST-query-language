grammar query;

//program
program : selectStatment ;
selectStatment : (SELECT  paramSelect)? (FROM  packages)? (WHERE conditions)?;

//select
paramSelect : paramName (COMMA paramName)* | STAR ;
paramName : EXCLAMANTION alias? NAME | alias? NAME (LBRACKET method RBRACKET)? | innerSelect;


//Package
packages : packageName (COMMA packageName)* | STAR ;
packageName : STRING as?| EXCLAMANTION STRING as?| innerSelect as? ;


//conditions
conditions : cond (AND cond)* ;

cond : equal | NAME innerSelect | innerSelect OPERATORS alias? NAME | EXCLAMANTION alias? NAME | alias? NAME ;

equal : alias? NAME OPERATORS rightStatment | alias? annotated OPERATORS rightStatment | alias? annotated;

rightStatment : alias? NAME | alias? annotated | STRING;
innerSelect : LPAREN selectStatment RPAREN ;

annotated : annotatedStatment | MM LBRACKET method RBRACKET index? annotatedStatment ;

method : STRING | NAME OPERATORS STRING (COMMA NAME OPERATORS STRING)* | STAR;


annotatedStatment : annotatedName (DOT annotatedParams )*;
annotatedName : AT NAME ;
annotatedParams : annotatedName | NAME index? ;


index : LBRACKET INT RBRACKET | LBRACKET STAR RBRACKET;
as: NAME NAME ;
alias : (NAME)DOT ;

SELECT: [Ss][Ee][Ll][Ee][Cc][Tt];
FROM: [Ff][Rr][Oo][Mm];
WHERE: [Ww][Hh][Ee][Rr][Ee] ;
AND :[Aa][Nn][Dd] ;

MM : [Mm] ;

OPERATORS : ('='|'!='|'~'|[Ii][Nn]) ;

COMMA: ',' ;

LBRACKET : '[' ;
RBRACKET : ']' ;

LPAREN : '(' ;
RPAREN : ')' ;

EXCLAMANTION : '!' ;
STAR : '*' ;
AT : '@' ;
DOT : '.' ;

INT : DIGIT+ ;
fragment DIGIT : '0'..'9' ;

NAME : LETTER+ ;
fragment LETTER: ('a'..'z'|'A'..'Z');

STRING : '\'' ( ESC | . )*? '\'' ;
fragment ESC : '\\' [btnr"\\] ; // \b, \t, \n etc...

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines