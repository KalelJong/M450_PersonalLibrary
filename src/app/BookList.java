package app;

import java.util.*;

public class BookList {
    private String name;
    private String creator;
    private List<Book> books = new ArrayList<>();

    public BookList(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public boolean addBook(String bookName, String author, int publishedYear, int pages, String readingStatus) {
        Book book = new Book(bookName, author, publishedYear, pages, readingStatus);
        books.add(book);
        return books.contains(book);
    }

    public boolean removeBook(String bookName) {
        Book book = books.stream().filter(b -> b.getName().equals(bookName)).findFirst().orElse(null);
        if (book != null) {
            books.remove(book);
            return !books.contains(book);
        }
        return false;
    }

    public Book getBookByName(String name) {
        return books.stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);
    }

    public void changeReadStatus(String name, String readingStatus) {
        Book book = books.stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);
        if (book != null) {
            book.changeReadStatus(readingStatus);
        }
    }

    public void changeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCreator() {
        return creator;
    }

    public List<Book> getBooks() {
        return books;
    }
}
