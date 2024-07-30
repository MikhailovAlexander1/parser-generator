package myparserrulesinformation;

public class Pair {
    private final NonTerm nonTerm;
    private String code;

    public Pair(NonTerm nonTerm) {
        this.nonTerm = nonTerm;
    }

    public NonTerm getNonTerm() {
        return nonTerm;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code.substring(2, code.length() - 2);
    }

    public String getPrintable() {
        return nonTerm.getName() + " (" + code + ") ";
    }
}
