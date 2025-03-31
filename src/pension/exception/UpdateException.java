package pension.exception;

public class UpdateException extends Exception {
    public UpdateException() {
        super("Error occurred while updating data.");
    }

    public UpdateException(String message) {
        super(message);
    }
}
