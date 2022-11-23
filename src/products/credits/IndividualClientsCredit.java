package products.credits;

import products.accounts.IndividualClientsAccount;

public class IndividualClientsCredit extends Credit {
	private IndividualClientsAccount account;

	public IndividualClientsCredit() {

	}

	public IndividualClientsCredit(double borrowingRate, int loanTermInMonth, double loanAmount,
			IndividualClientsAccount account) {
		super(borrowingRate, loanTermInMonth, loanAmount);
		this.account = account;
	}

	public IndividualClientsAccount getAccount() {
		return account;
	}

	public void setAccount(IndividualClientsAccount account) {
		this.account = account;
	}

	private double determineMonthlyPayment(double borrowingRate, int loanTermInMonth, double loanAmount) {
		double monthlyBorrowingRate = borrowingRate / 12 / 100;
		double monthlyPayment = loanAmount
				* (Math.pow((1 + monthlyBorrowingRate), loanTermInMonth) * monthlyBorrowingRate)
				/ ((Math.pow((1 + monthlyBorrowingRate), loanTermInMonth)) - 1);
		return monthlyPayment;
	}

	@Override
	void giveCredit() {
		IndividualClientsCredit credit = new IndividualClientsCredit();
	}

}
