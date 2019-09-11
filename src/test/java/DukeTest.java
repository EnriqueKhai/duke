import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DukeTest {
    @Test
    public void testAddition() {
        assertEquals(2, 2, "This test attempts to add two integers.");
    }

    @Test
    public void testMultiplication() {
        int a = 2;
        int b = 45;
        int c = 90;
        assertEquals((a * b), c, "This test attempts to multiply two integers.");
    }

    @Test
    public void testStringPatternIdentifier() {
        String string = "1234/5678/90";
        boolean regexMatch = string.matches("\\d{4}/\\d{4}/\\d{2}");
        assertTrue(regexMatch, "This test attempts to to find matching string patterns.");
    }
}