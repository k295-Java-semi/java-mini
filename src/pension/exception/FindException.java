package pension.exception;

public class FindException extends Exception {
    public FindException() {
        super("Error occurred while finding data.");
    }

    public FindException(String message) {
        super(message);
    }
}
