package products.accounts;

import branches.Branch;
import clients.IndividualClient;

public class IndividualClientsAccount extends Account{
	private IndividualClient client;
	
	public IndividualClientsAccount() {
		
	}
	
	public IndividualClientsAccount(String accountNumber, String regimeOfAccount, boolean status,float accountBalance,
			String accountCurrency, Branch branch, IndividualClient client) {
		super(accountNumber, regimeOfAccount, status, accountBalance, accountCurrency, branch);
		this.client = client;
	}

	public IndividualClient getClient() {
		return client;
	}
	public void setClient(IndividualClient client) {
		this.client = client;
	}
	
	@Override
	public void closeAccount(Account account) {
		account.setStatus(false);	
	}
	

}
