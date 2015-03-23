grammar query;

program : selectStatment;
selectStatment : (SELECT  paramSelect)? (FROM  packages)? (WHERE conditions)? (ORDER_BY STRING)?;

paramSelect : paramName (COMMA paramName)* ;

paramName : EXCLAMANTION NAME (LBRACKET method RBRACKET)? | NAME (LBRACKET method RBRACKET)? | STAR ;

packages : (packageName (COMMA packageName)* | STAR) ;

packageName : (STRING | EXCLAMANTION STRING) ;

conditions : cond (AND cond)* ;

cond : NAME (OPERATORS STRING)
    | NAME (LBRACKET STRING LBRACKET)* OPERATORS innerSelect
    | '!' NAME | NAME | annotated ;

innerSelect : LPAREN selectStatment RPAREN ;

annotated : CC AT annotatedStatment
    | MM LBRACKET method RBRACKET AT annotatedStatment
    | PP LBRACKET method RBRACKET DOT index  AT annotatedStatment
    ;

method : STRING | STRING COLON STRING (COMMA STRING COLON STRING)*;

index : LBRACKET INT RBRACKET;

annotatedStatment : LBRACKET STRING RBRACKET (DOT LBRACKET annotatedParams RBRACKET)?;

annotatedParams : paramAnnptated (COMMA paramAnnptated)* ;

paramAnnptated : STRING                              //parametr value
    | STRING COLON STRING                     //parametr object
    | STRING COLON LBRACE annotatedParams RBRACE   //parametr object array
    | STRING COLON annotatedStatment //parametr annotation
    | annotatedStatment
    ;

SELECT: [Ss][Ee][Ll][Ee][Cc][Tt];

FROM : [Ff][Rr][Oo][Mm];

WHERE: [Ww][Hh][Ee][Rr][Ee] ;

AND : [Aa][Nn][Dd] ;

OPERATORS : ('='|'!='|'~'|[Ii][Nn]) ;

ORDER_BY : [Oo][Rr][Dd][Ee][Rr](' '*)[Bb][Yy] ;

CC : [Cc] ;

MM : [Mm] ;

PP : [Pp] ;

COLON : ':' ;

COMMA: ',' ;

LBRACKET : '[' ;

RBRACKET : ']' ;

LPAREN : '(' ;

RPAREN : ')' ;

LBRACE : '{' ;

RBRACE : '}' ;

EXCLAMANTION : '!' ;

STAR : '*' ;

AT : '@' ;

DOT : '.' ;

INT : DIGIT+ ;
fragment DIGIT : '0'..'9' ;

NAME : LETTER+ ;
fragment LETTER: ('a'..'z'|'A'..'Z');

STRING : '"' ( ESC | . )*? '"' ;
fragment ESC : '\\' [btnr"\\] ; // \b, \t, \n etc...

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines