package main.java.com.solvd.banks.exception_handlers;

public class DeductionExceedsBalanceException extends Exception {
	private static final long serialVersionUID = 1L;
	float balance;
	float sum;
	float difference;

	public DeductionExceedsBalanceException(String mess, float balance, float sum, float difference) {
		super(mess);
		this.balance = balance;
		this.sum = sum;
		this.difference = balance - sum;
	}

	public float getBalance() {
		return balance;
	}

	public float getSum() {
		return sum;
	}

	public float getDifference() {
		return difference;
	}
}
