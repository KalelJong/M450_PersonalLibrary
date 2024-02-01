package app;
import app.Book;
import java.util.*;

public class BookList extends ArrayList<Book> {
    private String name;
    private String creator;

    @Override
    public boolean add(Book book) {
        for (Book existingBooks: this) {
            if (existingBooks.getName().equals(book.getName())) {
                return false;
            }
        }
        return super.add(book);
    }

    public BookList(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public boolean remove(String name) {
        Book book = getFirstBookByName(name);
        if (book != null) {
            return remove(book);
        }
        return false;
    }

    public Book getFirstBookByName(String name) {
        return this.stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
