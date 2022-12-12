package products.accounts;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import branches.Branch;
import exception_handlers.AccountAlreadyBlockedException;
import exception_handlers.AccountBlockedException;
import exception_handlers.DeductionExceedsBalanceException;
import products.Currency;

public abstract class Account {
	private String accountNumber;
	private String regimeOfAccount;
	private boolean status;
	private float accountBalance;
	private Currency accountCurrency;
	private Branch branch;
	private final static Logger logger = LogManager.getLogger(Account.class);

	public Account() {

	}

	public Account(String accountNumber, String regimeOfAccount, boolean status, float accountBalance,
			Currency accountCurrency, Branch branch) {
		this.accountNumber = accountNumber;
		this.regimeOfAccount = regimeOfAccount;
		this.status = status;
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

	public Currency getAccountCurrency() {
		return accountCurrency;
	}

	public void setAccountCurrency(Currency accountCurrency) {
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

	public boolean getStatus() {
		return status;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (this.hashCode() != obj.hashCode())
			return false;
		Account other = (Account) obj;
		return this.status == other.status
				&& (this.accountNumber == other.accountNumber
						|| (this.accountNumber != null ? this.accountNumber.equals(other.accountNumber)
								: other.accountNumber == null))
				&& (this.accountCurrency == other.accountCurrency
						|| (this.accountCurrency != null ? this.accountCurrency.equals(other.accountCurrency)
								: other.accountCurrency == null))
				&& (this.regimeOfAccount == other.regimeOfAccount
						|| (this.regimeOfAccount != null ? this.regimeOfAccount.equals(other.regimeOfAccount)
								: other.regimeOfAccount == null));
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountCurrency, accountNumber, regimeOfAccount, status);
	}

	@Override
	public String toString() {
		return String.format(
				"Account [accountNumber=%s, regimeOfAccount=%s, status=%b, accountBalance=%f, accountCurrency=%s]",
				accountNumber, regimeOfAccount, status, accountBalance, accountCurrency);
	}

	public void closeAccount() {
		try {
			if (!this.getStatus()) {
				throw new AccountAlreadyBlockedException("The account has already been blocked before");
			} else {
				this.setStatus(false);
			}
		} catch (AccountAlreadyBlockedException e) {
			logger.warn(e);
		}

	}

	public void refillBalance(float sum) {
		try {
			if (!this.getStatus()) {
				throw new AccountBlockedException("The user cannot access an account that is blocked");
			} else {
				float newBalance = this.getAccountBalance() + sum;
				this.setAccountBalance(newBalance);
				System.out.println("The balance of your account is " + this.getAccountBalance());
			}
		} catch (AccountBlockedException e) {
			logger.warn(e);
		}
	}

	public void deductBalance(float sum) {
		try {
			try {
				if (!this.getStatus()) {
					throw new AccountBlockedException("The user cannot access an account that is blocked");
				}
			} catch (AccountBlockedException e) {
				logger.warn(e);
			}
			float newBalance = this.getAccountBalance() - sum;
			if (newBalance < 0) {
				throw new DeductionExceedsBalanceException(
						"The user is trying to deduct from the account an amount exceeding the account balance");
			}
			this.setAccountBalance(newBalance);
			System.out.println("The balance of your account is " + this.getAccountBalance());
		} catch (DeductionExceedsBalanceException e) {
			logger.warn(e);
		}
	}
}
