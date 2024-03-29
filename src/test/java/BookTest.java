import app.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class BookTest {
    static Book book= new Book("Stories of Lutz", "Zakria Samma", 69, 2023, Book.Status.Reading);;
    //    @BeforeAll
//    public static void setUp(){
//    }

    @Test
    public void testCreateBook(){
        assertNotNull(book);
    }

    @Test
    public void testGetName(){
        assertEquals("Stories of Lutz", book.getName());
    }

    @Test
    public void testFailGetName(){
        assertNotEquals("Storys of Lutz", book.getName());
    }

    @Test
    public void testGetAuthor(){
        assertEquals("Zakria Samma", book.getAuthor());
    }

    @Test
    public void testFailGetAuthor(){
        assertNotEquals("Zackarya Samaa", book.getAuthor());
    }

    @Test
    public void testGetPages(){
        assertEquals(69, book.getPages());
    }

    @Test
    public void testFailGetPages(){
        assertNotEquals(96, book.getPages());
    }

    @Test
    public void testGetPublishedYear(){
        assertEquals(2023, book.getPublishedYear());
    }

    @Test
    public void testFailGetPublishedYear(){
        assertNotEquals(2022, book.getPublishedYear());
    }

    @Test
    public void testGetReadingStatus(){
        assertEquals(Book.Status.Reading, book.getReadingStatus());
    }

    @Test
    public void testFailGetReadingStatus(){
        assertNotEquals(Book.Status.Finished, book.getReadingStatus());
    }
}
