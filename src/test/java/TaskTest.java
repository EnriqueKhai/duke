import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task createTask() {
        Task j = new Task("hello this is just a test... ? ... !");
        return j;
    }
    @Test
    void getStatus() {
        Task j = createTask();
        String actual = j.getStatus();
        String expected = "[" + "\u2718" + "] " + "hello this is just a test... ? ... !";
        assertEquals(expected, actual, "Testing if UI output matches getStatus()");
    }

    @Test
    void markAsDone() {
        Task j = createTask();
        j.markAsDone();
        String actual = j.getStatus();
        String expected = "[" + "\u2713" + "] " + "hello this is just a test... ? ... !";
        assertEquals(expected, actual, "Testing if UI output matches getStatus()");
    }
}