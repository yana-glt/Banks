package products.accounts;

import java.util.Objects;

import branches.Branch;
import clients.CorporateClient;
import products.Currency;

public class CorporateClientsAccount extends Account {
	private CorporateClient client;

	public CorporateClientsAccount() {

	}

	public CorporateClientsAccount(String accountNumber, String regimeOfAccount, boolean status, float accountBalance,
			Currency accountCurrency, Branch branch, CorporateClient client) {
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
		if ((!super.equals(obj)) || (getClass() != obj.getClass()) || (this.hashCode() != obj.hashCode()))
			return false;
		CorporateClientsAccount other = (CorporateClientsAccount) obj;
		boolean isClientEqual = (this.client == null && other.client == null)
				|| (this.client != null && this.client == other.client);
		return isClientEqual;
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
		return String.format("Information about account holder: name=%s", client.getName());
	}
}
