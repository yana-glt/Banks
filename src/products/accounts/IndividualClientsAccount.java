package products.accounts;

import java.util.Objects;

import branches.Branch;
import clients.IndividualClient;

public class IndividualClientsAccount extends Account {

	private IndividualClient client;

	public IndividualClientsAccount() {

	}

	public IndividualClientsAccount(String accountNumber, String regimeOfAccount, boolean status, float accountBalance,
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndividualClientsAccount other = (IndividualClientsAccount) obj;
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
		return super.toString() + "IndividualClientsAccount [client=" + client + "]";
	}

	@Override
	public void closeAccount(Account account) {
		account.setStatus(false);
	}

}
