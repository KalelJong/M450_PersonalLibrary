import app.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class LibraryTest {

    private Library library;

    @BeforeEach
    public void setup() {
        library = new Library();
        library.newBookList("testList", "admin");
    }

    @Test
    public void testAddBook() {
        boolean result = library.addBook("testList", "testBook", "testAuthor", 353, 1999, "Reading");
        assertTrue(result);
    }

    @Test
    public void testFailAddBookBookExists() {
        library.addBook("testList", "testBook", "testAuthor", 353, 1999, "Reading");
        boolean result = library.addBook("testList", "testBook", "testAuthor", 353, 1999, "Reading");
        assertFalse(result);
    }

    @Test
    public void testFailAddBookListNotFound() {
        boolean result = library.addBook("test1", "testBook", "testAuthor", 353, 1999, "Reading");
        assertFalse(result);
    }

    @Test
    public void testRemoveBook() {
        library.addBook("testList", "testBook", "testAuthor", 353, 1999, "Reading");
        boolean result = library.removeBook("testList", "testBook");
        assertTrue(result);
    }

    @Test
    public void testFailRemoveBookListNotFound() {
        boolean result = library.removeBook("test", "testBook");
        assertFalse(result);
    }

    @Test
    public void testFailRemoveBookBookNotFound() {
        boolean result = library.removeBook("testList", "test");
        assertFalse(result);
    }

    @Test
    public void testGetBookFromList() {
        library.addBook("testList", "testBook", "testAuthor", 353, 1999, "Reading");
        Book result = library.getBookFromList("testList", "testBook");
        assertEquals("testBook", result.getName());
        assertEquals("testAuthor", result.getAuthor());
        assertEquals(353, result.getPages());
        assertEquals(1999, result.getPublishedYear());
        assertEquals("Reading", result.getReadingStatus());
    }

    @Test
    public void testGetBookByName() {
        library.newBookList("testList2", "admin");
        library.addBook("testList", "testBook", "testAuthor", 353, 1999, "Reading");
        library.addBook("testList2", "testBook", "testAuthor", 353, 1999, "Reading");
        List<Book> books = library.getBook("testBook");
        assertEquals(2, books.size());
        for (Book book : books) {
            assertEquals("testBook", book.getName());
            assertEquals("testAuthor", book.getAuthor());
            assertEquals(353, book.getPages());
            assertEquals(1999, book.getPublishedYear());
            assertEquals("Reading", book.getReadingStatus());
        }
    }

    @Test
    public void testGetBooklist() {
        List<Book> expected = new ArrayList<>();
        expected.add(new Book("book1", "author1", 1999, 1, "Reading"));
        expected.add(new Book("book2", "author2", 1999, 1, "Unknown"));
        expected.add(new Book("book3", "author3", 1999, 1, "Finished"));
        expected.add(new Book("book4", "author4", 1999, 1, "Dropped"));

        library.newBookList("test", "author");
        library.addBook("test", "book1", "author1", 1999, 1, "Reading");
        library.addBook("test", "book2", "author2", 1999, 1, "Unknown");
        library.addBook("test", "book3", "author3", 1999, 1, "Finished");
        library.addBook("test", "book4", "author4", 1999, 1, "Dropped");

        List<Book> results = library.getBookList("test").getBooks();

        for (Book result : results) {
            assertTrue(expected.stream().anyMatch(x -> x.getName().equals(result.getName())));
        }
    }

    @Test
    public void testAddList() {
        library.newBookList("test", "admin");
        BookList expected = new BookList("test", "admin");
        BookList result = library.getBookList("test");
        assertEquals(expected.getName(), result.getName());
    }

    @Test
    public void testFailAddList() {
        boolean result = library.newBookList("testList", "admin");
        assertFalse(result);
    }

    @Test
    public void testRemoveList() {
        boolean result = library.removeBookList("testList");
        assertTrue(result);
        assertFalse(library.getBookLists().stream().anyMatch(x -> x.getName().equals("testList")));
    }

    @Test
    public void testFailRemoveList() {
        boolean result = library.removeBookList("");
        assertFalse(result);
    }

    @Test
    public void testGetLists() {
        library = new Library();
        List<BookList> expected = new ArrayList<>();
        expected.add(new BookList("test1", "user1"));
        expected.add(new BookList("test2", "user2"));
        expected.add(new BookList("test3", "user3"));
        library.newBookList("test1", "user1");
        library.newBookList("test2", "user2");
        library.newBookList("test3", "user3");
        List<BookList> results = library.getBookLists();
        for (BookList result : results) {
            assertTrue(expected.stream().anyMatch(x -> x.getName().equals(result.getName())));
        }
    }

    @Test
    public void testGetList() {
        library = new Library();
        library.newBookList("test1", "user1");
        BookList result = library.getBookList("test1");
        assertEquals("test1", result.getName());
        assertEquals("user1", result.getCreator());
    }

    @Test
    public void testChangeListName() {
        boolean result = library.changeListName("testList", "test1");
        assertTrue(result);
        assertEquals("test1", library.getBookList("test1").getName());
    }

    @Test
    public void testFailChangeListName() {
        boolean result = library.changeListName("testList", "testList");
        assertFalse(result);
    }

    @Test
    public void testChangeReadStatus() {
        String testStatus = "Dropped";
        library.addBook("testList", "test1", "admin", 157, 1999, "Finished");
        library.changeReadStatus(testStatus, "testList", "test1");
        assertEquals(testStatus, library.getBookFromList("testList","test1").getReadingStatus());
    }

    @Test
    public void testFailChangeReadStatusBookNotFound() {
        String testStatus = "Dropped";
        library.addBook("testList", "test1", "admin", 157, 1999, "Finished");
        library.changeReadStatus(testStatus, "testList", "test");
        assertNotEquals(testStatus, library.getBookFromList("testList", "test1").getReadingStatus());
    }

    @Test
    public void testFailChangeReadStatusListNotFound() {
        String testStatus = "Dropped";
        library.addBook("testList", "test1", "admin", 157, 1999, "Finished");
        library.changeReadStatus(testStatus, "test", "test1");
        assertNotEquals(testStatus, library.getBookFromList("testList", "test1").getReadingStatus());
    }
}
