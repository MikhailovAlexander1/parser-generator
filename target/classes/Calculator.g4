grammar Calculator;

expr
    : e EOF
    ;

e returns[double value]
    : t esup[$t.value] {$value = $esup.value;}
    | {$value = 0;}
    ;

esup [double a] returns[double value]
    : PLUS t esup[$a + $t.value] {$value = $esup.value;}
    | MINUS t esup[$a - $t.value] {$value = $esup.value;}
    | {$value = $a;}
    ;

t returns[double value]
    : f tsup[$f.value] {$value = $tsup.value;}
    | {$value = 0;}
    ;

tsup [double a] returns[double value]
    : ASTERISK f tsup[$a * $f.value] {$value = $tsup.value;}
    | SLASH f tsup[$a / $f.value] {$value = $tsup.value;}
    | {$value = $a;}
    ;

f returns[double value]
    : LPAREN e RPAREN {$value = $e.value;}
    | NUMBER {$value = Integer.parseInt($NUMBER.text);}
    ;

NUMBER : [1-9] [0-9]*;
ASTERISK : '*';
MINUS : '-';
PLUS : '+';
SLASH : '/';
LPAREN : '(';
RPAREN : ')';
WHITESPACE : ' ' -> skip;