package org.example;

public class Book {
    private final String name;
    private final Integer year;
    private final Integer pages;

    public Book(String name, Integer year, Integer pages) {
        this.name = name;
        this.year = year;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getPages() {
        return pages;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;
        return this.name.equals(book.name) &&
                this.year.equals(book.year) &&
                this.pages.equals(book.pages);
    }
}
