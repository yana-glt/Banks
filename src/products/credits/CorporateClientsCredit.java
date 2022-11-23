package products.credits;

import products.accounts.CorporateClientsAccount;

public class CorporateClientsCredit extends Credit {
	private CorporateClientsAccount account;

	public CorporateClientsCredit() {

	}

	public CorporateClientsCredit(double borrowingRate, int loanTermInMonth, double loanAmount,
			CorporateClientsAccount account) {
		super(borrowingRate, loanTermInMonth, loanAmount);
		this.account = account;
	}

	public CorporateClientsAccount getAccount() {
		return account;
	}

	public void setAccount(CorporateClientsAccount account) {
		this.account = account;
	}

	@Override
	void giveCredit() {
		CorporateClientsCredit credit = new CorporateClientsCredit();
	}

}
