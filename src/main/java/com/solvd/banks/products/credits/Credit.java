package main.java.com.solvd.banks.products.credits;

import java.util.Objects;

import main.java.com.solvd.banks.products.Currency;

public abstract class Credit{
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
		if ((obj == null) || (this.getClass() != obj.getClass()) || (this.hashCode() != obj.hashCode()))
			return false;
		Credit other = (Credit) obj;
		boolean isBorrowingRateEqual = (this.borrowingRate == other.borrowingRate);
		boolean isLoanAmountEqual = (this.loanAmount == other.loanAmount);
		boolean isLoanTermInMonthEqual = (this.loanTermInMonth == other.loanTermInMonth);
		boolean isCreditCurrencyEqual = (this.creditCurrency == null && other.creditCurrency == null);
		return isBorrowingRateEqual && isLoanAmountEqual && isLoanTermInMonthEqual && isCreditCurrencyEqual;
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
