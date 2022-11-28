package products.accounts;

import java.util.Objects;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(this.accountNumber, other.accountNumber)
				&& Objects.equals(this.accountCurrency, other.accountCurrency)
				&& Objects.equals(this.regimeOfAccount, other.regimeOfAccount) && this.status == other.status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountCurrency, accountNumber, regimeOfAccount, status);
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", regimeOfAccount=" + regimeOfAccount + ", status=" + status
				+ ", accountBalance=" + accountBalance + ", accountCurrency=" + accountCurrency + "]";
	}

	abstract void closeAccount(Account account);

}
