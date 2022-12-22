package exception_handlers;

public class DeductionExceedsBalanceException extends Exception {
    private static final long serialVersionUID = 1L;
    double balance;
    double sum;
    double difference;

    public DeductionExceedsBalanceException(String mess, double balance, double sum, double difference) {
        super(mess);
        this.balance = balance;
        this.sum = sum;
        this.difference = balance - sum;
    }

    public double getBalance() {
        return balance;
    }

    public double getSum() {
        return sum;
    }

    public double getDifference() {
        return difference;
    }
}
