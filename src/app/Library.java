package app;

import java.util.*;

public class Library {
    private List<BookList> bookLists = new ArrayList<>();

    public boolean newBookList(String name, String creator) {
        for (BookList existingList : bookLists) {
            if (existingList.getName().equals(name)) {
                return false;
            }
        }

        BookList bookList = new BookList(name, creator);
        bookLists.add(bookList);
        return bookLists.contains(bookList);
    }

    public boolean removeBookList(String name) {
        BookList bookList = bookLists.stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);
        if (bookList != null) {
            bookLists.remove(bookList);
            return !bookLists.contains(bookList);
        }
        return false;
    }

    public boolean changeListName(String oldName, String newName) {
        if (bookLists.stream().anyMatch(b -> b.getName().equals(newName)) ||
                bookLists.stream().noneMatch(b -> b.getName().equals(oldName))) {
            return false;
        }

        BookList bookList = bookLists.stream().filter(b -> b.getName().equals(oldName)).findFirst().orElse(null);
        if (bookList != null) {
            bookList.changeName(newName);
            return bookLists.contains(bookList);
        }
        return false;
    }

    public boolean addBook(String listName, String bookName, String author, int pages, int publishingYear, String readingStatus) {
        BookList list = bookLists.stream().filter(b -> b.getName().equals(listName)).findFirst().orElse(null);
        if (list != null && !list.getBooks().stream().anyMatch(b -> b.getName().equals(bookName))) {
            return list.addBook(bookName, author, publishingYear, pages, readingStatus);
        }
        return false;
    }

    public boolean removeBook(String listName, String bookName) {
        BookList list = bookLists.stream().filter(b -> b.getName().equals(listName)).findFirst().orElse(null);
        if (list != null) {
            return list.removeBook(bookName);
        }
        return false;
    }

    public void changeReadStatus(String readStatus, String listName, String bookName) {
        BookList list = bookLists.stream().filter(b -> b.getName().equals(listName)).findFirst().orElse(null);
        if (list != null) {
            list.changeReadStatus(bookName, readStatus);
        }
    }

    public List<Book> getBook(String bookName) {
        List<Book> result = new ArrayList<>();
        for (BookList list : bookLists) {
            Book book = list.getBookByName(bookName);
            if (book != null) {
                result.add(book);
            }
        }
        return result;
    }

    public Book getBookFromList(String listName, String bookName) {
        BookList list = bookLists.stream().filter(b -> b.getName().equals(listName)).findFirst().orElse(null);
        if (list != null) {
            return list.getBookByName(bookName);
        }
        return null;
    }

    public BookList getBookList(String listName) {
        return bookLists.stream().filter(b -> b.getName().equals(listName)).findFirst().orElse(null);
    }

    public List<BookList> getBookLists() {
        return bookLists;
    }
}
