package main.java.com.solvd.banks.products.accounts;

import java.util.Objects;

import main.java.com.solvd.banks.branches.Branch;
import main.java.com.solvd.banks.clients.CorporateClient;
import main.java.com.solvd.banks.products.Currency;
import main.java.com.solvd.banks.products.IProductOptions;

public class CorporateClientsAccount extends Account implements IProductOptions<CorporateClientsAccount> {
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
        return String.format("%s Information about account holder: name=%s", super.toString(), client.getName());
    }
}
