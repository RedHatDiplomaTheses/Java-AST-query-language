grammar query;

program : selectStatment;
selectStatment : (SELECT  paramSelect)? (FROM  packages)? (WHERE conditions)?;

paramSelect : paramName (COMMA paramName)* ;

paramName : EXCLAMANTION NAME | NAME (LBRACKET method RBRACKET)? | STAR ;

packages : (packageName (COMMA packageName)* | STAR) ;

packageName : (STRING | EXCLAMANTION STRING) ;

conditions : cond (AND cond)* ;

cond : equal | assignment | innerSelect | innerSelect OPERATORS NAME | '!' NAME | NAME ;
    
equal : NAME OPERATORS STRING | NAME OPERATORS ID_SLASH | annotated OPERATORS STRING | annotated OPERATORS ID_SLASH | annotated;
    
assignment : ID_DOLLAR COLON NAME | ID_DOLLAR COLON annotated |  ID_DOLLAR COLON ID_SLASH ;
    
innerSelect : LPAREN selectStatment RPAREN ;

annotated : annotatedStatment | MM LBRACKET method RBRACKET index? annotatedStatment ;

method : STRING | NAME COLON STRING (COMMA NAME COLON STRING)*;

index : LBRACKET INT RBRACKET;

annotatedStatment : annotatedName (DOT annotatedParams )*;

annotatedName : AT NAME ;

annotatedParams : annotatedName | NAME index? ;


SELECT: '#' ;    //[Ss][Ee][Ll][Ee][Cc][Tt];

FROM : '<' ;    //[Ff][Rr][Oo][Mm];

WHERE: '?' ;    //[Ww][Hh][Ee][Rr][Ee] ;

AND : '&&' ;     //[Aa][Nn][Dd] ;

OPERATORS : ('='|'!='|'~'|[Ii][Nn]) ;

MM : [Mm] ;

COLON : ':' ;

COMMA: ',' ;

LBRACKET : '[' ;

RBRACKET : ']' ;

LPAREN : '(' ;

RPAREN : ')' ;

EXCLAMANTION : '!' ;

STAR : '*' ;

AT : '@' ;

DOT : '.' ;

ID_DOLLAR : DOLLAR DIGIT ;
fragment DOLLAR : '$' ; 

ID_SLASH : SLASH DIGIT ;
fragment SLASH : '\\' ;

INT : DIGIT+ ;
fragment DIGIT : '0'..'9' ;

NAME : LETTER+ ;
fragment LETTER: ('a'..'z'|'A'..'Z');

STRING : '\'' ( ESC | . )*? '\'' ;
fragment ESC : '\\' [btnr"\\] ; // \b, \t, \n etc...

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines