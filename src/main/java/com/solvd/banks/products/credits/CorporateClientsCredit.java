package main.java.com.solvd.banks.products.credits;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.banks.clients.Client;
import main.java.com.solvd.banks.clients.CorporateClient;
import main.java.com.solvd.banks.exception_handlers.IncorrectValueException;
import main.java.com.solvd.banks.products.accounts.CorporateClientsAccount;
import main.java.com.solvd.banks.products.Currency;
import main.java.com.solvd.banks.products.IProductOptions;

public class CorporateClientsCredit extends Credit implements ICreditOptions, IProductOptions<CorporateClientsCredit> {
	private CorporateClientsAccount account;
	private CorporateClient client;
	private final static Logger logger = LogManager.getLogger(CorporateClientsCredit.class);

	public CorporateClientsCredit() {

	}

	public CorporateClientsCredit(double borrowingRate, int loanTermInMonth, double loanAmount,
			Currency creditCurrency) {
		super(borrowingRate, loanTermInMonth, loanAmount, creditCurrency);
	}

	public CorporateClientsCredit(double borrowingRate, int loanTermInMonth, double loanAmount, Currency creditCurrency,
			CorporateClientsAccount account, CorporateClient client) {
		super(borrowingRate, loanTermInMonth, loanAmount, creditCurrency);
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

	public void setClient(CorporateClient client) {
		this.client = client;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		if (this.hashCode() != obj.hashCode())
			return false;
		CorporateClientsCredit other = (CorporateClientsCredit) obj;
		return this.account != null ? this.account.equals(other.account)
				: other.account == null && this.client != null ? this.client.equals(other.client)
						: other.client == null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(account, client);
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s Information about the recipient: account=%s, client=%s", super.toString(),
				account.getAccountNumber(), client.getName());
	}

	@Override
	public void giveCredit(Client client) {
		try {
			if (((CorporateClient) client).assessSolvency()) {
				this.setClient((CorporateClient) client);
				this.setAccount(new CorporateClientsAccount());
				((CorporateClient)client).getAccount().getBranch().getListOfCredits().add(this);
			}
		} catch (IncorrectValueException e) {
			logger.error(String.format(
					"%s. The client %s solvency assessment is %s. It is necessary to clarify the calculations.",  super.toString(),
					e.getClientsName(), e.getSolvencyAssessment()), e);
		}
	}
}