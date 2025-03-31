package pension.exception;

public class ModifyException extends Exception {
    public ModifyException() {
        super("Error occurred while modifying data.");
    }

    public ModifyException(String message) {
        super(message);
    }
}
