package pension.exception;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Data not found.");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
