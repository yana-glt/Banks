package exception_handlers;

public class IncorrectValueException extends Exception {
	private static final long serialVersionUID = 1L;

	public IncorrectValueException(String mess) {
		super(mess);
	}
}
