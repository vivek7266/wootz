grammar CaffePrototxt;

//@header {
//package gen.caffe;
//}


prototxt: name layer+;

solver: pair+;

name: ID COLON STRING;

layer: ID object;

pair: ID COLON? value;

value: object                   #valueObject
     | (STRING | NUMBER | ID)   #valueLeaf
     ;

object: LPAREN pair+ RPAREN;

LPAREN: '{';

RPAREN: '}';

COLON: ':';

NUMBER : '-'? ('.' DIGIT+ | DIGIT+ ('.' DIGIT*)? ) Exponent?;
fragment
DIGIT : [0-9] ;
fragment
Exponent : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

ID: LETTER (LETTER|DIGIT)*;

fragment
LETTER      :   [a-zA-Z\u0080-\u00FF_] ;

STRING      :   '"' ('\\"'|.)*? '"'
            |   '\'' ('\\\''|.)*? '\'' ;

WS  :   [ \t]+ -> channel(HIDDEN) ;

NL  :   [\n\r]+ -> channel(HIDDEN) ;

COMMENT :  '#' ~( '\r' | '\n' )* {!getText().startsWith("#CaffeToMXNet")}? -> skip;

CAFFE2MXNET: '#CaffeToMXNet' -> skip;