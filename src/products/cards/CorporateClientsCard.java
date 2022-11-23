package products.cards;

import products.accounts.CorporateClientsAccount;

public class CorporateClientsCard extends Card {
	private CorporateClientsAccount account;

	public CorporateClientsCard() {

	}

	public CorporateClientsCard(String number, String nameAndSurname, String expirationDate, int cvvCode,
			String issueDate, int pin, boolean status, CorporateClientsAccount account) {
		super(number, nameAndSurname, expirationDate, cvvCode, issueDate, pin, status);
		this.account = account;
	}

	public CorporateClientsAccount getAccount() {
		return account;
	}

	public void setAccount(CorporateClientsAccount account) {
		this.account = account;
	}

	@Override
	public void block(Card card) {
		card.setStatus(false);
	}

}
