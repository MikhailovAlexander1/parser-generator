package org.example.generator;

import myvisitors.GrammarMyVisitor;
import org.example.checkers.FirstFollowChecker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Generator {
    private final String pathToGen;
    private final String packageName;
    private final String taskName;
    private final SupportClassesGenerator supportClassesGenerator;
    private final TokenGenerator tokenGenerator;
    private final LexerGenerator lexerGenerator;
    private final ParserGenerator parserGenerator;

    public Generator(String pathToGen, String taskName, GrammarMyVisitor myVisitor, FirstFollowChecker checker) {
        this.pathToGen = pathToGen;
        this.taskName = taskName;
        this.packageName = Arrays.stream(pathToGen.split("/")).skip(1).collect(Collectors.joining("."));
        this.supportClassesGenerator = new SupportClassesGenerator(myVisitor.getSupportClasses(), pathToGen, packageName);
        this.tokenGenerator = new TokenGenerator(myVisitor.getTermSet(), pathToGen, packageName, taskName);
        this.lexerGenerator = new LexerGenerator(myVisitor.getTokens(), myVisitor.getRegexp(), pathToGen, packageName, taskName);
        this.parserGenerator = new ParserGenerator(checker.getFIRST(), checker.getFOLLOW(), myVisitor.getParserRules(),
                pathToGen, packageName, taskName);
    }

    public void gen() throws IOException {
        Files.createDirectories(Paths.get(this.pathToGen));
        supportClassesGenerator.generate();
        tokenGenerator.generate();
        lexerGenerator.generate();
        parserGenerator.generate();
    }
}
