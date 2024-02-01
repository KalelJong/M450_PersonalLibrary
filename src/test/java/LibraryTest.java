import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import app.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class LibraryTest {

    private Library library;
    private BookList bookList;
    @BeforeAll
    public static void beforeAll(){ }

    @BeforeEach
    public void setup() {
        library = new Library();
        bookList = new BookList("testList", "admin");
        bookList.add(new Book("book1", "author1", 11, 2001, Book.Status.Reading));
        bookList.add(new Book("book2", "author2", 12, 2002, Book.Status.Unknown));
        bookList.add(new Book("book3", "author3", 13, 2003, Book.Status.Finished));
        bookList.add(new Book("book4", "author4", 14, 2004, Book.Status.Dropped));
        library.add(bookList);
    }

    @Test
    public void testAddList() {
        boolean result = library.add(new BookList("test", "admin"));
        assertTrue(result);
    }

    @Test
    public void testFailAddList() {
        boolean result = library.add(new BookList("testList", "admin"));
        assertFalse(result);
    }

    @Test
    public void testGetBooklist() {

    }

    @Test
    public void testFailGetBooklist() {


        assertSame(bookList, library.get("testList"));
    }

    @Test
    public void testFailAddBookListNotFound() {

        assertThrowsExactly(NullPointerException.class ,()-> {library.get("notAList").add(new Book("book1", "author1", 11, 2001, Book.Status.Reading));});

    }



    @Test
    public void testRemoveList() {
        boolean result = library.remove("testList");
        assertTrue(result);
        assertFalse(library.stream().anyMatch(x -> x.getName().equals("testList")));
    }

    @Test
    public void testFailRemoveList() {
        boolean result = library.remove("");
        assertFalse(result);
    }

    @Test
    public void testGetLists() {
        library = new Library();
        List<BookList> expected = new ArrayList<>();
        expected.add(new BookList("test1", "user1"));
        expected.add(new BookList("test2", "user2"));
        expected.add(new BookList("test3", "user3"));
        library.add(new BookList("test1", "user1"));
        library.add(new BookList("test2", "user2"));
        library.add(new BookList("test3", "user3"));
        List<BookList> results = library;
        for (BookList result : results) {
            assertTrue(expected.stream().anyMatch(x -> x.getName().equals(result.getName())));
        }
    }

    @Test
    public void testGetList() {
        library = new Library();
        library.add(new BookList("test1", "user1"));
        BookList result = library.get("test1");
        assertEquals("test1", result.getName());
        assertEquals("user1", result.getCreator());
    }

    @Test
    public void testChangeListName() {
        String oldName = "testList";
        library.get(oldName).setName( "test1");
        assertNull(library.get(oldName));
        assertEquals("test1", library.get("test1").getName());
    }

    @Test
    public void testChangeReadStatus() {
        library.get("testList").add(new Book( "test1", "admin", 157, 1999, Book.Status.Reading  ));
        library.get("testList").getFirstBookByName("test1").setReadingStatus(Book.Status.Dropped);
        assertEquals(Book.Status.Dropped, library.get("testList").getFirstBookByName("test1").getReadingStatus());
    }

    @Test
    public void testFailChangeReadStatusBookNotFound() {
        BookList testList = library.get("testList");
        assertThrowsExactly(NullPointerException.class, ()-> { testList.getFirstBookByName("test1").setReadingStatus(Book.Status.Dropped);});
//        assertNotEquals(Book.Status.Reading, library.get("testList").getFirstBookByName("test1").getReadingStatus());
    }

    @Test
    public void testFailChangeReadStatusListNotFound() {
        assertThrowsExactly(NullPointerException.class, ()-> { library.get("").getFirstBookByName("book1").setReadingStatus(Book.Status.Dropped);});

    }
}
