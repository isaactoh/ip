package shaduke.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * JUnit tests for the Deadline class.
 */
public class DeadlineTest {
    @Test
    public void input_validDate_success() {
        Deadline deadline = new Deadline("Run UTown Loops", "2025-04-17");
        assertEquals("[D][ ] Run UTown Loops (by: Apr 17 2025)", deadline.toString());
    }

    @Test
    public void input_wrongDateFormat_exceptionThrown() {
        try {
            Deadline dead = new Deadline("name", "17 April");
            fail();
        } catch (Exception e) {
            assertEquals("Sorry! Please use yyyy-mm-dd format for deadlines!", e.getMessage());
        }
    }
}
