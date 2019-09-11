import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void getStatus() {
        Task j = new Event("MUT3215 first review!", "12/09/2019 1400");
        String expected = "[E][" + "\u2718" + "] MUT3215 first review! (at: 12/09/2019 1400)";
        String actual = j.getStatus();
        assertEquals(expected, actual, "Tests the getStatus() method of the Event class.");
    }
}