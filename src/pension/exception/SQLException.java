package pension.exception;

public class SQLException extends Exception {
    public SQLException() {
        super("An SQL execution error occurred.");
    }

    public SQLException(String message) {
        super(message);
    }
}
