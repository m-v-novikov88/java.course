package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Objects;

public final class MyImmutableClass {
    private final String name;
    private final List<String> siblings;
    private final MutableClass mutableField = new MutableClass();

    public MyImmutableClass() {
        this("Anonymous", List.of());
    }

    public MyImmutableClass(String name) {
        this(name, List.of());
    }

    public MyImmutableClass(String name, List<String> siblings) {
        this.name = name;
        this.siblings = new ArrayList<>(siblings);
    }

    public List<String> getSiblings() {
        return Collections.unmodifiableList(siblings);
    }

    public String getName() {
        return name;
    }

    public MutableClass getMutableObj() {
        return mutableField;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        MyImmutableClass myImmutableInstance = (MyImmutableClass) obj;
        return this.name.equals(myImmutableInstance.name) &&
                this.siblings.equals(myImmutableInstance.siblings) &&
                Objects.equals(this.mutableField, myImmutableInstance.mutableField);

    }

    @Override
    public int hashCode () {
        return Objects.hash(name, siblings, mutableField);
    }

    public class MutableClass {
        public String name;
    }
}
