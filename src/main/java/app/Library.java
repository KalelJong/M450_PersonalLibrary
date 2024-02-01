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

    
}
