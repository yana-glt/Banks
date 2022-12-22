package products.cards;

import products.accounts.IndividualClientsAccount;

public class IndividualClientsCard extends Card {
	private IndividualClientsAccount account;

	public IndividualClientsCard() {

	}

	public IndividualClientsCard(String number, String nameAndSurname, String expirationDate, int cvvCode,
			String issueDate, int pin, boolean status, IndividualClientsAccount account) {
		super(number, nameAndSurname, expirationDate, cvvCode, issueDate, pin, status);
		this.account = account;
	}

	public IndividualClientsAccount getAccount() {
		return account;
	}

	public void setAccount(IndividualClientsAccount account) {
		this.account = account;
	}

	@Override
	public void block(Card card) {
		card.setStatus(false);
	}
}
