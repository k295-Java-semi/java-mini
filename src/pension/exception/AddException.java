package pension.exception;

public class AddException extends Exception {
	public AddException() {
		super("Error occurred while adding data.");
	}

	public AddException(String message) {
		super(message);
	}
}
