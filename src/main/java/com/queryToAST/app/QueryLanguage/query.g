grammar query;

query : SELECT select(',' select)* FROM from(',' from)* WHERE st_co (OP_BOOL st_co)* ;         // Prvni pravidlo

SELECT : [Ss][Ee][Ll][Ee][Cc][Tt] ;
FROM : [Ff][Rr][Oo][Mm] ;
WHERE : [Ww][Hh][Ee][Rr][Ee] ;
ORDER_BY : [Oo][Rr][Dd][Ee][Rr][ ][Bb][Yy];
OP_BOOL : [Aa][Nn][Dd]
        |[Oo][Rr] ;        

select : '!'(spec) | spec ;

spec : '*' 
    | 'import' 
    | 'extend' 
    | 'implement' 
    | 'subclass' 
    | 'superclass' 
    | 'subinterface' 
    | 'superinterface' ;    
    
from : (path)
    | '!'(path);

path : '*' 
    | STRING ;

st_co : (prop)(operand)(prop)
    | st_in OP_IN st_in
    | BOOL ;    

prop : 'type' 
    | 'name' 
    | 'extend' 
    | 'annotation' 
    | STRING ;

operand : '=' 
    | '!=' ;

st_in : 'callmethod'
    | 'import'
    | 'implement'
    | 'extend'
    | 'method'
    | '('query')'
    | STRING ;

OP_IN : [Ii][Nn]
    | [Nn][Oo][Tt][ ][Ii][Nn] ;    

BOOL : 'interface' 
    | 'subinterface' 
    | 'superinterface' 
    | 'class' 
    | 'subclass' 
    | 'superclass' 
    | 'abstract' 
    | 'enum' 
    | 'annotation' 
    | 'subinterface' ;

STRING  : '"' .*? '"' ;             // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines