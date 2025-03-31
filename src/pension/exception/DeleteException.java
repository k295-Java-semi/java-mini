package pension.exception;

public class DeleteException extends Exception {
    public DeleteException() {
        super("Error occurred while deleting data.");
    }

    public DeleteException(String message) {
        super(message);
    }
}
