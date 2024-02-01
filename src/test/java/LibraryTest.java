import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import app.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LibraryTest {

    private static Library library = new Library();

    @BeforeEach
    public void beforeEach() {
        library = new Library();
        BookList bookList = new BookList("testList", "admin");
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
    public void testChangeListName() {
        String oldName = "testList";
        library.get(oldName).setName( "test1");
        assertNull(library.get(oldName));
        assertEquals("test1", library.get("test1").getName());
    }

    @Test
    public void testFailChangeListName() {
        assertThrowsExactly(NullPointerException.class ,()-> {library.get("notAList").setName("test1");});
    }

    @Test
    public void testGetList() {
        BookList bookList = library.get("testList");
        assertNotNull(bookList);
    }

    @Test
    public void testFailGetList() {
        BookList bookList = library.get("NotAList");
        assertNull(bookList);
    }

    @Test
    public void testAddBookToList() {
        assertDoesNotThrow(() -> {library.get("testList").add(new Book("book0", "author0", 10, 2000, Book.Status.Pending));});
    }

    @Test
    public void testFailAddBookToList() {
        // Setup: Ensure the "notAList" doesn't exist to cause the expected failure.
        assertNull(library.get("notAList"), "Library should not contain 'notAList' before test.");

        // Act & Assert: Trying to add a book to a non-existent list should throw.
        assertThrowsExactly(NullPointerException.class ,() -> library.get("notAList").add(new Book("book0", "author0", 10, 2000, Book.Status.Pending)), "Expected NullPointerException when adding a book to a non-existent list.");
    }

    @Test
    public void testRemoveList() {
        boolean result = library.remove("testList");
        assertTrue(result);
        assertFalse(library.stream().anyMatch(x -> x.getName().equals("testList")));
    }

    @Test
    public void testFailRemoveList() {
        boolean result = library.remove("notAList");
        assertFalse(result);
    }

    @Test
    public void testChangeReadStatus() {
        library.get("testList").add(new Book( "test1", "admin", 157, 1999, Book.Status.Reading  ));
        library.get("testList").getFirstBookByName("test1").setReadingStatus(Book.Status.Dropped);
        assertEquals(Book.Status.Dropped, library.get("testList").getFirstBookByName("test1").getReadingStatus());
    }

    @Test
    public void testFailChangeReadStatusBookNotFound() {
        BookList bookList = library.get("testList");
        assertThrowsExactly(NullPointerException.class, ()-> { bookList.getFirstBookByName("bo0k1").setReadingStatus(Book.Status.Dropped);});
//        assertNotEquals(Book.Status.Reading, library.get("testList").getFirstBookByName("test1").getReadingStatus());
    }

    @Test
    public void testFailChangeReadStatusListNotFound() {
        assertThrowsExactly(NullPointerException.class, ()-> { library.get("NotAList").getFirstBookByName("book1").setReadingStatus(Book.Status.Dropped);});
    }

}
