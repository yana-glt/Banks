package exception_handlers;

public class AccountBlockedException extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountBlockedException(String mess) {
		super(mess);
	}
}
