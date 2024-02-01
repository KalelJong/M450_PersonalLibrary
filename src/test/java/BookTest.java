import app.*;
import org.h2.engine.Database;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
public class BookTest {
    static Book book= new Book("Stories of Lutz", "Zakria Samma", 69, 2023, Book.Status.Reading);
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

    /*
    @Test
    public void testAddListWithMockedInput() {
        Library library = Mockito.mock(Library.class);
        LibraryApp libraryApp = new LibraryApp(library);

        // Mocking user input for addList method
        Mockito.when(libraryApp.readString("What's the name of the list?")).thenReturn("TestList");
        Mockito.when(libraryApp.readString("What's your name?")).thenReturn("TestCreator");

        libraryApp.addList();

        // Verify that the add method of the mock Library is called with the expected parameters
        Mockito.verify(library).add(Mockito.any(BookList.class));
    }
     */
}
