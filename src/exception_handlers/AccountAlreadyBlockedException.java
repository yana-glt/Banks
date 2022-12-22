package exception_handlers;

public class AccountAlreadyBlockedException extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountAlreadyBlockedException(String mess) {
		super(mess);
	}
}
