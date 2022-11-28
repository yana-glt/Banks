package products.accounts;

import java.util.Objects;

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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CorporateClientsAccount other = (CorporateClientsAccount) obj;
		return Objects.equals(this.client, other.client);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(client);
		return result;
	}
	

	@Override
	public String toString() {
		return "CorporateClientsAccount [client=" + client + "]";
	}

	@Override
	public void closeAccount(Account account) {
		account.setStatus(false);
	}

}
