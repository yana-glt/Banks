package products.accounts;

import java.util.Objects;

import branches.Branch;
import clients.IndividualClient;
import products.Currency;
import products.IProductOptions;

public class IndividualClientsAccount extends Account implements IProductOptions<IndividualClientsAccount> {
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
        return this.client != null ? this.client.equals(other.client) : other.client == null;
    }

   @Override
    public boolean equals(Object obj) {
      if ((!super.equals(obj)) || (getClass() != obj.getClass()) || (this.hashCode() != obj.hashCode()))
        return false;
      IndividualClientsAccount other = (IndividualClientsAccount) obj;
      boolean isClientEqual = (this.client == null && other.client == null)
          || (this.client != null && this.client == other.client);
      return isClientEqual;
    }

    @Override
    public String toString() {
        return String.format("%s Information about account holder: name=%s, surname=%s", super.toString(),
                client.getName(), client.getSurname());
    }
}
