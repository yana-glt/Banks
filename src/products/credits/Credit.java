package products.credits;

abstract class Credit {
	private double borrowingRate;
	private int loanTermInMonth;
	private double loanAmount;

	public Credit() {

	}

	public Credit(double borrowingRate, int loanTermInMonth, double loanAmount) {
		this.borrowingRate = borrowingRate;
		this.loanTermInMonth = loanTermInMonth;
		this.loanAmount = loanAmount;
	}

	public double getBorrowingRate() {
		return borrowingRate;
	}

	public void setBorrowingRate(double borrowingRate) {
		this.borrowingRate = borrowingRate;
	}

	public int getLoanTermInMonth() {
		return loanTermInMonth;
	}

	public void setLoanTermInMonth(int loanTermInMonth) {
		this.loanTermInMonth = loanTermInMonth;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	abstract void giveCredit();

}
