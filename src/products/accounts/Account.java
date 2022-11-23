package products.accounts;

import branches.Branch;

abstract class Account {
	private String accountNumber;
	private String regimeOfAccount;
	private boolean status;
	private float accountBalance;
	private String accountCurrency;
	private Branch branch;

	public Account() {

	}

	public Account(String accountNumber, String regimeOfAccount, boolean status, float accountBalance,
			String accountCurrency, Branch branch) {
		this.accountNumber = accountNumber;
		this.regimeOfAccount = regimeOfAccount;
		this.status = true;
		this.accountBalance = accountBalance;
		this.accountCurrency = accountCurrency;
		this.branch = branch;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getRegimeOfAccount() {
		return regimeOfAccount;
	}

	public void setRegimeOfAccount(String regimeOfAccount) {
		this.regimeOfAccount = regimeOfAccount;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	abstract void closeAccount(Account account);

}
