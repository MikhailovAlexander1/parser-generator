package myparserrulesinformation;

import java.util.Objects;

public class Term implements SequenceMember {
    public final String name;

    public Term(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Term term = (Term) obj;
        return Objects.equals(this.name, term.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
