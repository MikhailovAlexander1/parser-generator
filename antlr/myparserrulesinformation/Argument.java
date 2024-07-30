package myparserrulesinformation;

public class Argument {
    private final String type;
    private final String varName;

    public Argument(String type, String varName) {
        this.type = type;
        this.varName = varName;
    }

    public String getType() {
        return type;
    }

    public String getVarName() {
        return varName;
    }

    public String getPrintable() {
        return type + " " + varName;
    }

    public String toString() {
        return type + " " + varName;
    }
}
