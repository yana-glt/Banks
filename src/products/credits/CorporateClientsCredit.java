package products.credits;

import java.util.Objects;

import clients.CorporateClient;
import products.accounts.CorporateClientsAccount;
import products.accounts.IndividualClientsAccount;

public class CorporateClientsCredit extends Credit {
	private CorporateClientsAccount account;
	private CorporateClient client;

	public CorporateClientsCredit() {

	}

	public CorporateClientsCredit(double borrowingRate, int loanTermInMonth, double loanAmount,
			CorporateClientsAccount account, CorporateClient client) {
		super(borrowingRate, loanTermInMonth, loanAmount);
		this.account = account;
		this.client = client;
	}

	public CorporateClientsAccount getAccount() {
		return account;
	}

	public void setAccount(CorporateClientsAccount account) {
		this.account = account;
	}
	
	public CorporateClient getClient() {
		return client;
	}

	public void setClient(CorporateClient client) {
		this.client = client;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		CorporateClientsCredit other = (CorporateClientsCredit) obj;
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
		return super.toString() + " CorporateClientsCredit [account=" + account.getAccountNumber() + ", client=" + client.getName() + "]";
	}
	

	@Override
	void giveCredit() {
		CorporateClientsCredit credit = new CorporateClientsCredit();
	}
	
	public void giveCredit(CorporateClient client, CorporateClientsCredit credit) {
		if(client.getSolvencyAssessment() >= 75) {
			CorporateClientsCredit newCredit = new CorporateClientsCredit(credit.getBorrowingRate(), credit.getLoanTermInMonth(), credit.getLoanAmount(), 
					new CorporateClientsAccount(), client);
			System.out.println("The financial condition of the client "+ client.getName() + " allows him to receive a credit.");
		}else {
			System.out.println("The financial condition of the client "+ client.getName() + " does not allow him to receive a credit.");
		}
	}

}
