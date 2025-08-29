package duke.commands;

import duke.commands.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * JUnit tests for the Parser class.
 */
public class ParserTest {
    @Test
    public void parse_emptyTodoInput_exceptionThrown() {
        try {
            Parser.parse("todo");
            fail();
        } catch (Exception e) {
            assertEquals("Sorry! Don't forget to add a tasty curry recipe to your todo list!", e.getMessage());
        }
    }

    @Test
    public void parse_noDeadlineBy_exceptionThrown() {
        try {
            Parser.parse("deadline");
            fail();
        } catch (Exception e) {
            assertEquals("Sorry! Need '/by!'", e.getMessage());
        }
    }

    @Test
    public void parse_unrecognisedCommand_exceptionThrown() {
        try {
            Parser.parse("tada");
            fail();
        } catch (Exception e) {
            assertEquals("Sorry! I don't understand like when Shohib talks to me", e.getMessage());
        }
    }
}
