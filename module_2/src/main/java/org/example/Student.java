package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private final String name;
    private final String secondName;
    private final List<String> books;

    public Student(String name, String secondName, List<String> books) {
        this.name = name;
        this.secondName = secondName;
        this.books = new ArrayList<>(books);
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public List<String> getBooks() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getName()).append(" ").append(getSecondName()).append(", books: ").append(String.join(", ", books)).toString();
    }
}
