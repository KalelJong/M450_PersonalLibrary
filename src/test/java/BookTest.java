import app.*;
import org.h2.engine.Database;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
public class BookTest {
    static Book book;
    @BeforeAll
    public static void setUp(){
        book = new Book("Discord Life", "Zakria Samma", 69, 2025, "Reading");
    }

    @Test
    public void createTest(){
        assertNotNull(book);
    }

}
