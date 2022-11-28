package products.credits;

import java.util.Objects;

import clients.IndividualClient;
import products.accounts.IndividualClientsAccount;

public class IndividualClientsCredit extends Credit {
	private IndividualClientsAccount account;
	private IndividualClient client;

	public IndividualClientsCredit() {

	}

	public IndividualClientsCredit(double borrowingRate, int loanTermInMonth, double loanAmount,
			IndividualClientsAccount account, IndividualClient client) {
		super(borrowingRate, loanTermInMonth, loanAmount);
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		IndividualClientsCredit other = (IndividualClientsCredit) obj;
		return Objects.equals(this.account, other.account) && Objects.equals(this.client, other.client);
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
		return "IndividualClientsCredit [account=" + account.getAccountNumber() + ", client=" + client.getName() + " "+ client.getSurname() + "]";
	}

	public void setClient(IndividualClient client) {
		this.client = client;
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
	
	public void giveCredit(IndividualClient client, IndividualClientsCredit credit) {
		double monthlyPayment = determineMonthlyPayment(credit.getBorrowingRate(), credit.getLoanTermInMonth(), credit.getLoanAmount());
		if(monthlyPayment <= (client.getAverageSalary()*0.5)){
			IndividualClientsCredit newCredit = new IndividualClientsCredit(credit.getBorrowingRate(), credit.getLoanTermInMonth(), credit.getLoanAmount(), 
					new IndividualClientsAccount() ,client);
			System.out.println("Client "+ client.getName() + " " + client.getSurname() + " has sufficient income to receive this credit.");
		}else {
			System.out.println("Client "+ client.getName() + " " + client.getSurname() + " does not have sufficient income to receive this credit. ");
		}
	}


}
