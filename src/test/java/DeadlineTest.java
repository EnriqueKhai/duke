import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadlineTest {

    @Test
    void getStatus() {
        Task j = new Deadline("MUT3215 first review!", "12/09/2019 1400");
        String expected = "[D][" + "\u2718" + "] MUT3215 first review! (by: 12/09/2019 1400)";
        String actual = j.getStatus();
        assertEquals(expected, actual, "Tests the getStatus() method of the Event class.");
    }
}