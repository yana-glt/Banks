package products.cards;

import java.time.LocalDate;

import clients.IndividualClient;
import products.IProductOptions;
import products.accounts.IndividualClientsAccount;

public class IndividualClientsCard extends Card implements IProductOptions<IndividualClientsCard> {
    private IndividualClientsAccount account;
    private IndividualClient client;

    public IndividualClientsCard() {

    }

    public IndividualClientsCard(String number, String nameAndSurname, LocalDate issueDate, int cvvCode, int pin,
                                 boolean status, IndividualClientsAccount account, IndividualClient client) {
        super(number, nameAndSurname, issueDate, cvvCode, pin, status);
        this.account = account;
        this.client = client;
    }

    public IndividualClientsAccount getAccount() {
        return account;
    }

    public void setAccount(IndividualClientsAccount account) {
        this.account = account;
    }

    public IndividualClient getClient() {
        return client;
    }

    @Override
    public String toString() {
        return String.format("%s Information about card holder: name=%s, surname=%s", super.toString(),
                client.getName(), client.getSurname());
    }
}
