import app.*;
import org.h2.engine.Database;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookListTest {


    BookList list;
    Book testBook ;
    @BeforeEach
    public void setUp(){
        list = new BookList("Test", "Admin");
        testBook = new Book("testBook", "testAuthor", 353, 1999, Book.Status.Reading);
//        book = new Book("Discord Life", "Zakria Samma", 69, 2025, Book.Status.Reading);

    }

    @Test
    public void testAddBook() {
        boolean result = list.add(testBook);
        assertTrue(result);
    }

    @Test
    public void testFailAddBookBookExists() {
        list.add(testBook);
        boolean result = list.add(testBook);
        assertFalse(result);
    }


    @Test
    public void testRemoveBook() {
        list.add(testBook);
        boolean result = list.remove( "testBook");
        assertTrue(result);
    }

    @Test
    public void testFailRemoveBookListNotFound() {
        boolean result = list.remove( "testBook");
        assertFalse(result);
    }

    @Test
    public void testFailRemoveBookBookNotFound() {
        boolean result = list.remove( "test");
        assertFalse(result);
    }

    @Test
    public void testGetBookFromList() {
        list.add(testBook);
        Book result = list.getFirstBookByName("testBook");
        assertEquals("testBook", result.getName());
        assertEquals("testAuthor", result.getAuthor());
        assertEquals(353, result.getPages());
        assertEquals(1999, result.getPublishedYear());
        assertEquals(Book.Status.Reading, result.getReadingStatus());
    }

    @Test
    public void testGetBookByName() {
        list.add(testBook);
        list.add(testBook);
        List<Book> books = list;
        assertEquals(1, books.size());
        for (Book book : books) {
            assertEquals("testBook", book.getName());
            assertEquals("testAuthor", book.getAuthor());
            assertEquals(353, book.getPages());
            assertEquals(1999, book.getPublishedYear());
            assertEquals(Book.Status.Reading, book.getReadingStatus());
        }
    }



}
