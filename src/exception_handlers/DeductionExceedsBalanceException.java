package exception_handlers;

public class DeductionExceedsBalanceException extends Exception {
	private static final long serialVersionUID = 1L;

	public DeductionExceedsBalanceException(String mess) {
		super(mess);
	}
}
