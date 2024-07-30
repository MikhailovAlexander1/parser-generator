package myparserrulesinformation;

import java.util.Objects;

public class NonTerm implements SequenceMember {
    private final String name;

    public NonTerm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NonTerm nonTerm = (NonTerm) obj;
        return Objects.equals(this.name, nonTerm.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
