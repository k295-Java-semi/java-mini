package pension.exception;

public class DuplicatedException extends Exception {
    public DuplicatedException() {
        super("The data already exists.");
    }

    public DuplicatedException(String message) {
        super(message);
    }
}
