package app;

import java.util.*;

public class Library extends ArrayList<BookList> {


    @Override
    public boolean add(BookList bookList) {
        for (BookList existingList : this) {
            if (existingList.getName().equals(bookList.getName())) {
                return false;
            }
        }
        return super.add(bookList);
    }

    public boolean remove(String listName) {
        return this.remove(get(listName));
    }

    public BookList get(String listName) {
        return this.stream().filter(b -> b.getName().equals(listName)).findFirst().orElse(null);
    }

    public boolean addBook(String listName, String bookName, String author, int pages, int publishingYear, String readingStatus) {
        BookList list = bookLists.stream().filter(b -> b.getName().equals(listName)).findFirst().orElse(null);
        if (list != null && !list.getBooks().stream().anyMatch(b -> b.getName().equals(bookName))) {
            return list.addBook(bookName, author, pages, publishingYear, readingStatus);
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
