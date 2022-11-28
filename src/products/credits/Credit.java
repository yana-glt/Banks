package products.credits;

import java.util.Objects;

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
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Credit other = (Credit) obj;
		return Double.doubleToLongBits(this.borrowingRate) == Double.doubleToLongBits(other.borrowingRate)
				&& Double.doubleToLongBits(this.loanAmount) == Double.doubleToLongBits(other.loanAmount)
				&& this.loanTermInMonth == other.loanTermInMonth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(borrowingRate, loanAmount, loanTermInMonth);
	}

	@Override
	public String toString() {
		return "Credit [borrowingRate=" + borrowingRate + ", loanTermInMonth=" + loanTermInMonth + ", loanAmount="
				+ loanAmount + "]";
	}

	abstract void giveCredit();

}
