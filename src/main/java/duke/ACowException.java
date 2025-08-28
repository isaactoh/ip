package duke;

public class ACowException extends RuntimeException {
    public ACowException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "Sorry! " + super.getMessage();
    }
}
