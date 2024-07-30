grammar GrammarRules;

@header {
    import myParserRulesInformation.*;

    import java.util.ArrayList;
    import java.util.Map;
}

rules: helperClass* (lexerRuleDeclaration NEWLINE+)+ NEWLINE* (parserRuleDeclaration NEWLINE+)+;
helperClass: CLASS NEWLINE+;
lexerRuleDeclaration: TERM COLON (STRING|REGEXP) SEMICOLON;
parserRuleDeclaration: signature statements;
signature: NAME input? return? NEWLINE;
input returns[ArrayList<Argument> args]
    : LPAREN arguments {$args = $arguments.args;} RPAREN
    ;
return returns[Argument oneArg]
    : LBRACKET argument {$oneArg = $argument.arg;} RBRACKET
    ;
argument returns[Argument arg]
    : type NAME {$arg = new Argument($type.typeName, $NAME.text);}
    ;
arguments returns[ArrayList<Argument> args]
    : a=argument {$args = new ArrayList<>(); $args.add($a.arg);}
        (COMMA b=argument {$args.add($b.arg);})*
    ;
statements returns[ArrayList<Sequence> rights]
    : TAB COLON a=sequence {$rights = new ArrayList<>(); $rights.add($a.seq);} NEWLINE
        (TAB OR b=sequence {$rights.add($b.seq);} NEWLINE)* TAB SEMICOLON
    ;
sequence returns[Sequence seq]
    : {$seq = new Sequence();}
        (
        nontermDeclaration {$seq.addDef($nontermDeclaration.nonTermWithAttrs);}
        | TERM {$seq.addDef(new Definition(new Term($TERM.text)));}
        | STCODE {$seq.addDef(new Definition(new Code($STCODE.text)));}
        )+
    ;
nontermDeclaration returns[Definition nonTermWithAttrs]
    : NAME {$nonTermWithAttrs = new Definition(new NonTerm($NAME.text));}
        (ARGCODE {$nonTermWithAttrs.setInput(new Code($ARGCODE.text));})?
    ;
type returns[String typeName]
    : (NAME {$typeName = $NAME.text;} | TERM {$typeName = $TERM.text;})
    ;

NAME: [a-z]LETTER*;
TERM: [A-Z]LETTER*;
LETTER: [a-zA-Z];
OR : '|';
COLON : ':';
EQUAL: '=';
SEMICOLON : ';';
COMMA : ',';
LPAREN : '(';
RPAREN : ')';
LBRACKET: '[';
RBRACKET: ']';
LBRACE: '{';
RBRACE: '}';
NEWLINE: '\r'? ('\n' | '\r');
TAB: '\t';
CLASS: '@' NEWLINE .*? '@';
STCODE: LBRACE ~[{}]* RBRACE;
ARGCODE: LPAREN LBRACE ~[{}]* RBRACE RPAREN;
STRING: '\'' (~'\''+) '\'';
REGEXP: '/' (~'/'+) '/';
WHITESPACE : ' ' -> skip;