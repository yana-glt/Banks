package products.credits;

import java.util.Objects;

import products.Currency;

public abstract class Credit {
	private double borrowingRate;
	private int loanTermInMonth;
	private double loanAmount;
	private Currency creditCurrency;

	public Credit() {

	}

	public Credit(double borrowingRate, int loanTermInMonth, double loanAmount, Currency creditCurrency) {
		this.borrowingRate = borrowingRate;
		this.loanTermInMonth = loanTermInMonth;
		this.loanAmount = loanAmount;
		this.creditCurrency = creditCurrency;
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

	public Currency getCreditCurrency() {
		return creditCurrency;
	}

	public void setCreditCurrency(Currency creditCurrency) {
		this.creditCurrency = creditCurrency;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		if (this.hashCode() != obj.hashCode())
			return false;
		Credit other = (Credit) obj;
		return this.borrowingRate == other.borrowingRate && this.loanAmount == other.loanAmount
				&& this.loanTermInMonth == other.loanTermInMonth
				&& (this.creditCurrency == other.creditCurrency
						|| (this.creditCurrency != null ? this.creditCurrency.equals(other.creditCurrency)
								: other.creditCurrency == null));
	}

	@Override
	public int hashCode() {
		return Objects.hash(borrowingRate, loanAmount, loanTermInMonth, creditCurrency);
	}

	@Override
	public String toString() {
		return String.format("Credit [borrowingRate=%f, loanTermInMonth=%d, loanAmount=%f, creditCurrency=%s]",
				borrowingRate, loanTermInMonth, loanAmount, creditCurrency);
	}

}
