package main.java.com.solvd.banks.products.accounts;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.banks.branches.Branch;
import main.java.com.solvd.banks.branches.Employee;
import main.java.com.solvd.banks.exception_handlers.AccountAlreadyBlockedException;
import main.java.com.solvd.banks.exception_handlers.AccountBlockedException;
import main.java.com.solvd.banks.exception_handlers.DeductionExceedsBalanceException;
import main.java.com.solvd.banks.products.Currency;

public abstract class Account {
    private String accountNumber;
    private String regimeOfAccount;
    private boolean status;
    private double accountBalance;
    private Currency accountCurrency;
    private Branch branch;
    private LocalDate accountBlockDate;
    private Employee responsibleExecutorOfBloking;

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

    public String getRegimeOfAccount() {
        return regimeOfAccount;
    }

    public void setRegimeOfAccount(String regimeOfAccount) {
        this.regimeOfAccount = regimeOfAccount;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
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

    public LocalDate getAccountBlockDate() {
        return accountBlockDate;
    }

    public void setAccountBlockDate(LocalDate accountBlockDate) {
        this.accountBlockDate = accountBlockDate;
    }

    public Employee getResponsibleExecutorOfBloking() {
        return responsibleExecutorOfBloking;
    }

    public void setResponsibleExecutorOfBloking(Employee responsibleExecutorOfBloking) {
        this.responsibleExecutorOfBloking = responsibleExecutorOfBloking;
    }

    @Override
    public boolean equals(Object obj) {
      if ((obj == null) || (getClass() != obj.getClass()) || (this.hashCode() != obj.hashCode()))
        return false;
      Account other = (Account) obj;
      boolean isStatusEqual = (this.status == other.status);
      boolean isAccountNumberEqual = (this.accountNumber == null && other.accountNumber == null)
          || (this.accountNumber != null && this.accountNumber == other.accountNumber);
      boolean isAccountCurrencyEqual = (this.accountCurrency == null && other.accountCurrency == null)
          || (this.accountCurrency != null && this.accountCurrency == other.accountCurrency);
      boolean isRegimeOfAccountEqual = (this.regimeOfAccount == null && other.regimeOfAccount == null)
          || (this.regimeOfAccount != null && this.regimeOfAccount == other.regimeOfAccount);
      return isStatusEqual && isAccountNumberEqual && isAccountCurrencyEqual && isRegimeOfAccountEqual;
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

    public void blockAccount(Employee emp) {
        try {
            LocalDate accountBlockDate = LocalDate.now();
            if (this.getStatus()) {
                this.setStatus(false);
                this.setResponsibleExecutorOfBloking(emp);
                this.setAccountBlockDate(accountBlockDate);
            } else {
                throw new AccountAlreadyBlockedException("The account has already been blocked before",
                        this.accountNumber, this.accountBlockDate, this.responsibleExecutorOfBloking);
            }
        } catch (AccountAlreadyBlockedException e) {
            logger.warn(String.format("The account %s was already blocked on %s. Responsible executor: %s",
                    this.accountNumber, e.getAccountBlockDate(), e.getResponsibleExecutorOfBlocking()), e);
        }
    }

    public void refillBalance(double sum) throws AccountBlockedException {
        if (!this.getStatus()) {
            throw new AccountBlockedException("The user cannot access an account that is blocked",
                    this.accountNumber, this.accountBlockDate, this.responsibleExecutorOfBloking);
        } else {
            double newBalance = this.getAccountBalance() + sum;
            this.setAccountBalance(newBalance);
            System.out.println("The balance of your account is " + this.getAccountBalance());
        }
    }

    public void deductBalance(double sum) throws AccountBlockedException, DeductionExceedsBalanceException {
        if (!this.getStatus()) {
            throw new AccountBlockedException("The user cannot access an account that is blocked",
                    this.accountNumber, this.accountBlockDate, this.responsibleExecutorOfBloking);
        }
        double difference = this.getAccountBalance() - sum;
        if (difference < 0) {
            throw new DeductionExceedsBalanceException(
                    "The user is trying to deduct from the account an amount exceeding the account balance",
                    this.getAccountBalance(), sum, difference);
        }
        this.setAccountBalance(difference);
        System.out.println("The balance of your account is " + this.getAccountBalance());
    }


    public static boolean transferMoney(Account srcAccount, Account dstAccount, double transferAmount) {
        boolean flag = false;
        try {
            if (transferAmount <= srcAccount.getAccountBalance()) {
                srcAccount.deductBalance(transferAmount);
                dstAccount.refillBalance(transferAmount);
                flag = true;
            }
        } catch (AccountBlockedException e) {
            if (e.getAccountNumber().equals(srcAccount.getAccountNumber())) {
                logger.warn(String.format("The account %s was blocked on %s. Responsible executor: %s", e.getAccountNumber(),
                        e.getAccountBlockDate(), e.getResponsibleExecutorOfBlocking()), e);
            } else if (e.getAccountNumber().equals(dstAccount.getAccountNumber())) {
                double newBalance = srcAccount.getAccountBalance() + transferAmount;
                srcAccount.setAccountBalance(newBalance);
                System.out.println("The balance of your account is " + srcAccount.getAccountBalance());
                logger.warn(String.format("The account %s was blocked on %s. Responsible executor: %s", e.getAccountNumber(),
                        e.getAccountBlockDate(), e.getResponsibleExecutorOfBlocking()), e);
            }
        } catch (DeductionExceedsBalanceException e) {
            logger.warn(String.format(
                    "The user is trying to withdraw from the account an amount of money (%f) that exceeds his current balance (%f) by (%f)",
                    e.getSum(), e.getBalance(), e.getDifference()), e);
        }
        return flag;
    }


    public static long getSumOfBalances(List<? extends Account> accounts) {
        long sum = 0;
        try {
            for (Account account : accounts) {
                if (account.getStatus()) {
                    sum += account.getAccountBalance();
                } else {
                    throw new AccountBlockedException("The user cannot access an account that is blocked",
                            account.accountNumber, account.accountBlockDate, account.responsibleExecutorOfBloking);
                }
            }
        } catch (AccountBlockedException e) {
            logger.warn(String.format("The account %s was blocked on %s. Responsible executor: %s",
                    e.getAccountNumber(), e.getAccountBlockDate(), e.getResponsibleExecutorOfBlocking()), e);
        }
        System.out.println(String.format("The sum of the balances of the accounts listed below is %s", sum));
        for (Account account : accounts) {
            System.out.println(String.format("The balance of account number %s is %s", account.getAccountNumber(), account.getAccountBalance()));
        }
        return sum;
    }
}
