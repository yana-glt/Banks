package products.credits;

import clients.Client;

public interface ICreditOptions {

    void giveCredit(Client client);

    void closeCredit(Client client);

}
