package products.accounts;

import java.util.Objects;

import branches.Branch;
import clients.IndividualClient;
import products.Currency;

public class IndividualClientsAccount extends Account {

	private IndividualClient client;

	public IndividualClientsAccount() {

	}

	public IndividualClientsAccount(String accountNumber, String regimeOfAccount, boolean status, float accountBalance,
			Currency accountCurrency, Branch branch, IndividualClient client) {
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (this.hashCode() != obj.hashCode())
			return false;
		IndividualClientsAccount other = (IndividualClientsAccount) obj;
		boolean clientEquality = (this.client == null && other.client == null)
				|| (this.client != null && this.client == other.client);
		return clientEquality;
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
		return String.format("%s Information about account holder: name=%s, surname=%s", super.toString(),
				client.getName(), client.getSurname());
	}
}
