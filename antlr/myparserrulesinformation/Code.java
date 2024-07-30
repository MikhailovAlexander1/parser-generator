package myparserrulesinformation;

public class Code implements SequenceMember {
    private String code;

    public Code(String code) {
        this.code = code.substring(1, code.length() - 1);
    }

    public String getCode() {
        return code.replaceAll("^\\{|}|\\$", "");
    }

    public void setCode(String code) {
        this.code = code;
    }
}
