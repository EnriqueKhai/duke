import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoTest {

    Task createTask() {
        Task j = new ToDo("MUT3215 first review!");
        return j;
    }

    @Test
    void getStatus() {
        Task j = createTask();

        String expected = "[T][" + "\u2718" + "] MUT3215 first review!";
        String actual = j.getStatus();
        assertEquals(expected, actual, "Tests the getStatus() method of the Event class.");
    }

    @Test
    void markAsDone() {
        Task j = createTask();
        j.markAsDone();

        String expected = "[T][" + "\u2713" + "] MUT3215 first review!";
        String actual = j.getStatus();
        assertEquals(expected, actual, "Tests the getStatus() method of the Event class.");
    }
}