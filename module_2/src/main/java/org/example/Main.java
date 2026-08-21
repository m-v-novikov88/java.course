package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    private final static Path STUDENTS_DOCUMENT_PATH = Paths.get("src", "main", "resources", "data", "students.txt");
    private final static Path BOOKS_DOCUMENT_PATH = Paths.get("src", "main", "resources", "data", "books.txt");
    private final static Integer LOWER_BOUND_TO_FILTER_BOOKS = 2000; // to check negative case use 2025
    private final static Integer MAX_BOOKS_AMOUNT = 3;

    public static void main(String[] args) {
        List<Student> allStudents = getAllStudents();
        Map<String, Book> allBooksMap = getAllBooks();

        allStudents.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .map(bookName -> Optional.ofNullable(allBooksMap.get(bookName)).orElseGet(() -> new Book(bookName, null, 0)))
                .distinct()
                .filter(book -> book.getYear() != null && book.getYear() > LOWER_BOUND_TO_FILTER_BOOKS)
                .sorted(Comparator.comparingInt(Book::getYear))
                .limit(MAX_BOOKS_AMOUNT)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> {
                    System.out.println("Such book doesn't exist");
                });

    }

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Stream<String> lines = Files.lines(STUDENTS_DOCUMENT_PATH, StandardCharsets.UTF_8)) {
            lines.forEach(line -> {
                String[] studentData = line.split("=");
                String[] identity = studentData[0].split(" ");

                students.add(new Student(identity[0], identity[1], List.of(studentData[1].split(", "))));
            });
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static Map<String, Book> getAllBooks() {
        Map<String, Book> booksMap = new HashMap<>();

        try (Stream<String> lines = Files.lines(BOOKS_DOCUMENT_PATH, StandardCharsets.UTF_8)) {
            lines.forEach(line -> {
                String[] booksData = line.split("=");
                String[] pagesAndYear = booksData[1].split(",");
                booksMap.putIfAbsent(booksData[0], new Book(booksData[0], Integer.parseInt(pagesAndYear[1]), Integer.parseInt(pagesAndYear[0])));
            });

        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        }

        return booksMap;
    }
}