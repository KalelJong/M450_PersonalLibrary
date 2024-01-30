import app.*;
import org.h2.engine.Database;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LibraryTest {

    static Library lib;
    @BeforeAll
    public static void setUp(){
        lib = new Library();
        when(lib.getBookLists()).then()

        book = new Book("Discord Life", "Zakria Samma", 69, 2025, "Reading");
    }

    @Test
    public void createTest(){
        assertNotNull(book);
    }

}
