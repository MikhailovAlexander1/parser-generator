package kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
    private final String node;
    private final List<Tree> children;

    public Tree(final String node, final Tree... children) {
        this.node = node;
        this.children = new ArrayList<>(Arrays.asList(children));
    }

    public Tree(final String node) {
        this.node = node;
        this.children = new ArrayList<>();
    }

    public void addChild(final Tree child) {
        this.children.add(child);
    }

    public String getNode() {
        return node;
    }

    public List<Tree> getChildren() {
        return children;
    }
}
