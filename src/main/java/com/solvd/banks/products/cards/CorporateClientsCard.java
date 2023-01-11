package main.java.com.solvd.banks.products.cards;

import java.time.LocalDate;

import main.java.com.solvd.banks.clients.CorporateClient;
import main.java.com.solvd.banks.products.IProductOptions;
import main.java.com.solvd.banks.products.accounts.CorporateClientsAccount;

public class CorporateClientsCard extends Card implements IProductOptions<CorporateClientsCard> {
    private CorporateClientsAccount account;
    private CorporateClient client;

    public CorporateClientsCard() {

    }

    public CorporateClientsCard(String number, String nameAndSurname, LocalDate issueDate, int cvvCode, int pin,
                                boolean status, CorporateClientsAccount account, CorporateClient client) {
        super(number, nameAndSurname, issueDate, cvvCode, pin, status);
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

    @Override
    public String toString() {
        return String.format("%s Information about the recipient: account=%s, client=%s", super.toString(),
                account.getAccountNumber(), client.getName());
    }
}
