package duke.commands;

import duke.commands.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParserTest {
    @Test
    public void todo_emptyInput_exceptionThrown() {
        try {
            Parser.parse("todo");
            fail();
        } catch (Exception e) {
            assertEquals("Sorry! Don't forget to add a tasty curry recipe to your todo list!", e.getMessage());
        }
    }

    @Test
    public void deadline_noBy_exceptionThrown() {
        try {
            Parser.parse("deadline");
            fail();
        } catch (Exception e) {
            assertEquals("Sorry! Need '/by!'", e.getMessage());
        }
    }

    @Test
    public void input_unrecognisedCommand_exceptionThrown() {
        try {
            Parser.parse("tada");
            fail();
        } catch (Exception e) {
            assertEquals("Sorry! I don't understand like when Shohib talks to me", e.getMessage());
        }
    }
}
