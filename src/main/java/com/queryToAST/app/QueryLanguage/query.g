grammar query;

query : select? from? where? order_by?;


select : KEY_SELECT  sel_li_prop ;
sel_li_prop : sel_prop(',' sel_prop)* ;
sel_prop : '!' KEY_PROP ('[' method ']')?
    | KEY_PROP ('[' method ']')?
    | '*'
    ;


from : FROM  pack;
pack : fro_pac (',' fro_pac)* ;
fro_pac : STRING
    | '!' STRING
    | '*'
    ;

where : KEY_WHERE cond;
cond : st_co (KEY_OP_BOOL st_co)* ;
st_co : KEY_PROP KEY_OPERAND STRING 
    | STRING KEY_OP_IN KEY_PROP
    | KEY_PROP '['STRING']' KEY_OP_IN '(' query ')'
    | KEY_PROP KEY_OP_IN '(' query ')'
    | '(' query ')' KEY_OP_IN KEY_PROP
    | '(' query ')' '[' STRING ']' KEY_OP_IN KEY_PROP
    | KEY_BOOL
    | '!' KEY_BOOL
    | annot
    | '!' annot
    ;
annot : CC '@' an_value
    | MM '[' method ']' '@' an_value
    | PP '[' method ']' '.' index  '@' an_value
    ;
method : STRING
    | 'name' ':' STRING
    | 'name' ':' STRING ',' 'arg' ':' STRING
    ;
index : '[' INT ']';
an_value : '[' STRING ']' ('.' '[' params ']')?;
params : param (',' param)* ;
param : STRING                              //parametr value
    | STRING ':' STRING                     //parametr object
    | STRING ':' '{' para (',' para)* '}'   //parametr object array
    | STRING ':' '{' param (',' param)* '}' //parametr annotation
    ;
para : STRING
    | '{' para (',' para)* '}'
    ;


order_by : ORDER_BY STRING;



KEY_SELECT: [Ss][Ee][Ll][Ee][Cc][Tt];
KEY_PROP : [Ii][Mm][Pp][Oo][Rr][Tt]
    | [Ee][Xx][Tt][Ee][Nn][Dd]
    | [Ii][Mm][Pp][Ll][Ee][Mm][Ee][Nn][Tt][Ss]
    | [Tt][Yy][Pp][Ee]
    | [Nn][Aa][Mm][Ee]
    | [Mm][Ee][Tt][Hh][Oo][Dd]
    | [Cc][Aa][Ll][Ll]
    | [Ff][Qq][Cc][Nn]         //Fully qualified class name (fqcn)
    ;


FROM : [Ff][Rr][Oo][Mm];


KEY_WHERE: [Ww][Hh][Ee][Rr][Ee] ;
KEY_OP_BOOL : [Aa][Nn][Dd]
    | [Oo][Rr]
    | [Nn][Oo][Tt]
    ;
KEY_OPERAND : '=' 
    | '!='
    ;
KEY_OP_IN : [Ii][Nn]
    | [Nn][Oo][Tt][ ][Ii][Nn]
    ;
KEY_BOOL : [Ii][Nn][Tt][Ee][Rr][Ff][Aa][Cc][Ee]
    | [Ss][Uu][Bb][Ii][Nn][Tt][Ee][Rr][Ff][Aa][Cc][Ee]
    | [Ss][Uu][Pp][Ee][Rr][Ii][Nn][Tt][Ee][Rr][Ff][Aa][Cc][Ee]
    | [Cc][Ll][Aa][Ss][Ss]
    | [Ss][Uu][Bb][Cc][Ll][Aa][Ss][Ss]
    | [Ss][Uu][Pp][Ee][Rr][Cc][Ll][Aa][Ss][Ss] 
    | [Aa][Bb][Ss][Tt][Rr][Aa][Cc][Tt]
    | [Ee][Nn][Uu][Mm]
    | [Aa][Nn][Nn][Oo][Tt][Aa][Tt][Ii][Oo][Nn]
    | [Pp][Rr][Oo][Tt][Ee][Cc][Tt][Ee][Dd]
    | [Pp][Rr][Ii][Vv][Aa][Tt][Ee]
    | [Pp][Uu][Bb][Ll][Ii][Cc]
    | [Ss][Tt][Aa][Tt][Ii][Cc]
    | [Ff][Ii][Nn][Aa][Ll]
    ;
CC : [Cc] ;
MM : [Mm] ;
PP : [Pp] ;


ORDER_BY : [Oo][Rr][Dd][Ee][Rr][ ][Bb][Yy] ;
INT : DIGIT+ ;
fragment DIGIT : '0'..'9' ;
STRING : '"' ( ESC | . )*? '"' ;
fragment ESC : '\\' [btnr"\\] ; // \b, \t, \n etc...
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines