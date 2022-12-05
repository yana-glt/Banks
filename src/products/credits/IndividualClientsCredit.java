package products.credits;

import java.util.Objects;

import clients.Client;
import clients.IndividualClient;
import products.Currency;
import products.accounts.IndividualClientsAccount;

public class IndividualClientsCredit extends Credit implements ICreditOptions {
	private IndividualClientsAccount account;
	private IndividualClient client;

	public IndividualClientsCredit() {

	}

	public IndividualClientsCredit(double borrowingRate, int loanTermInMonth, double loanAmount,
			Currency creditCurrency) {
		super(borrowingRate, loanTermInMonth, loanAmount, creditCurrency);
	}

	public IndividualClientsCredit(double borrowingRate, int loanTermInMonth, double loanAmount,
			Currency creditCurrency, IndividualClientsAccount account, IndividualClient client) {
		super(borrowingRate, loanTermInMonth, loanAmount, creditCurrency);
		this.account = account;
		this.client = client;
	}

	public IndividualClientsAccount getAccount() {
		return account;
	}

	public void setAccount(IndividualClientsAccount account) {
		this.account = account;
	}

	public IndividualClient getClient() {
		return client;
	}

	public void setClient(IndividualClient client) {
		this.client = client;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		if (this.hashCode() != obj.hashCode())
			return false;
		IndividualClientsCredit other = (IndividualClientsCredit) obj;
		return this.account != null ? this.account.equals(other.account)
				: other.account == null && this.client != null ? this.client.equals(other.client)
						: other.client == null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(account, client);
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s Information about the recipient: account=%s, client=%s %s", account.getAccountNumber(),
				client.getName(), client.getSurname());
	}

	public static final double determineMonthlyPayment(double borrowingRate, int loanTermInMonth, double loanAmount) {
		double monthlyBorrowingRate = borrowingRate / 12 / 100;
		double monthlyPayment = loanAmount
				* (Math.pow((1 + monthlyBorrowingRate), loanTermInMonth) * monthlyBorrowingRate)
				/ ((Math.pow((1 + monthlyBorrowingRate), loanTermInMonth)) - 1);
		System.out.println(String.format("The monthly fee for the credit will be %f", monthlyPayment));
		return monthlyPayment;
	}

	@Override
	public void giveCredit(Client client) {
		if (((IndividualClient) client).assessSolvency()) {
			this.setClient((IndividualClient) client);
			this.setAccount(new IndividualClientsAccount());
		}
	}

}
