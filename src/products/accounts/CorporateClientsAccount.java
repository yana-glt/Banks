package products.accounts;

import branches.Branch;
import clients.CorporateClient;

public class CorporateClientsAccount extends Account {
	private CorporateClient client;

	public CorporateClientsAccount() {

	}

	public CorporateClientsAccount(String accountNumber, String regimeOfAccount, boolean status, float accountBalance,
			String accountCurrency, Branch branch, CorporateClient client) {
		super(accountNumber, regimeOfAccount, status, accountBalance, accountCurrency, branch);
		this.client = client;
	}

	public CorporateClient getClient() {
		return client;
	}

	public void setClient(CorporateClient client) {
		this.client = client;
	}

	@Override
	public void closeAccount(Account account) {
		account.setStatus(false);
	}

}
