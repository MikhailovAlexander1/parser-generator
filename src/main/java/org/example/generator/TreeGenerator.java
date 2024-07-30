package org.example.generator;

import myparserrulesinformation.NonTerm;
import myparserrulesinformation.ParserRule;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TreeGenerator {
    private final StringBuilder sb;
    private final String packageName;
    private final Path saveTo;
    private final Set<NonTerm> nonTerms;

    private void addString(int tab, int lineSeparatorsCount, String str) {
        sb.append(C.TAB.repeat(Math.max(0, tab)));
        sb.append(str);
        sb.append(C.NEWLINE.repeat(Math.max(0, lineSeparatorsCount)));
    }

    private void printPackage() {
        if (!this.packageName.isEmpty()) {
            sb.append(C.PACKAGE).append(C.SPACE).append(this.packageName)
                    .append(C.SEMICOLON).append(C.NEWLINE).append(C.NEWLINE);
        }
    }

    private void printImports() {
        addString(0, 1, "import java.util.ArrayList;");
        addString(0, 1, "import java.util.Arrays;");
        addString(0, 2, "import java.util.List;");
    }

    private void printFields() {
        addString(1, 1, "private final String node;");
        addString(1, 2, "private final List<Tree> children;");
    }

    private void printConstructor() {
        addString(1, 1, "public Tree(final String node, final Tree... children) {");
        addString(2, 1, "this.node = node;");
        addString(2, 1, "this.children = Arrays.asList(children);");
        addString(1, 2, C.CLOSE_BRACE);

        addString(1, 1, "public Tree(final String node) {");
        addString(2, 1, "this.node = node;");
        addString(2, 1, "this.children = new ArrayList<>();");
        addString(1, 2, C.CLOSE_BRACE);
    }

    private void printMethods() {
        addString(1, 1, "public void addChild(final Tree child) {");
        addString(2, 1, "this.children.add(child);");
        addString(1, 2, C.CLOSE_BRACE);

        addString(1, 1, "public String getNode() {");
        addString(2, 1, "return node;");
        addString(1, 2, C.CLOSE_BRACE);

        addString(1, 1, "public List<Tree> getChildren() {");
        addString(2, 1, "return children;");
        addString(1, 2, C.CLOSE_BRACE);

        addString(1, 1, "public boolean isTerminal() {");
        String allNonTerms = nonTerms.stream().map(NonTerm::getName).collect(Collectors.joining("|"));
        addString(2, 1, String.format("return !node.matches(\"^(%s)$\");", allNonTerms));
        addString(1, 2, C.CLOSE_BRACE);
    }

    private void printClass() {
        sb.append(C.PUBLIC).append(C.SPACE).append(C.CLASS).append(C.SPACE).append("Tree {\n");
        printFields();
        printConstructor();
        printMethods();
        sb.append(C.CLOSE_BRACE);
    }

    public TreeGenerator(String pathToGen, String packageName, ArrayList<ParserRule> rules) {
        this.packageName = packageName;
        this.saveTo = Paths.get(pathToGen, "Tree.java");;
        sb = new StringBuilder();
        nonTerms = new HashSet<>();
        for (ParserRule rule: rules) {
            nonTerms.add(rule.getNonTerm());
        }
    }

    public void generate() throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(saveTo)) {
            printPackage();
            printImports();
            printClass();
            writer.write(sb.toString());
            writer.flush();
        }
    }
}
