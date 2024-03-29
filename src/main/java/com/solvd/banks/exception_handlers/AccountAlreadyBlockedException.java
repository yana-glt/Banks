package main.java.com.solvd.banks.exception_handlers;

import java.time.LocalDate;

import main.java.com.solvd.banks.branches.Employee;

public class AccountAlreadyBlockedException extends Exception {
	private static final long serialVersionUID = 1L;
	private String accountNumber;
	private LocalDate accountBlockDate;
	private Employee responsibleExecutorOfBloking;
	

	public AccountAlreadyBlockedException(String mess, String accountNumber, LocalDate accountBlockDate,
			Employee responsibleExecutorOfBloking) {
		super(mess);
		this.accountNumber = accountNumber;
		this.accountBlockDate = accountBlockDate;
		this.responsibleExecutorOfBloking = responsibleExecutorOfBloking;

	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public LocalDate getAccountBlockDate() {
		return accountBlockDate;
	}

	public Employee getResponsibleExecutorOfBlocking() {
		return responsibleExecutorOfBloking;
	}
}
