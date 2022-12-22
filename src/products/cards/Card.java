package products.cards;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import products.credits.CorporateClientsCredit;

import java.time.LocalDate;

public abstract class Card {

    private String number;
    private String nameAndSurname;
    private LocalDate issueDate;
    private LocalDate expirationDate;
    private int cvvCode;
    private int pin;
    private boolean status;

    private final static Logger logger = LogManager.getLogger(Card.class);

    public Card() {

    }

    public Card(String number, String nameAndSurname, LocalDate issueDate, int cvvCode, int pin, boolean status) {
        this.number = number;
        this.nameAndSurname = nameAndSurname;
        this.issueDate = issueDate;
        this.determineCardExpirationDate();
        this.cvvCode = cvvCode;
        this.pin = pin;
        this.status = status;

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(int cvvCode) {
        this.cvvCode = cvvCode;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Card [number==%s, nameAndSurname=%s, expirationDate=%s, cvvCode=%d, issueDate=%s, status=%b]", number,
                nameAndSurname, expirationDate, cvvCode, issueDate, status);
    }

    private void determineCardExpirationDate() {
        LocalDate expirationDate = this.issueDate.plusYears(3L);
        this.setExpirationDate(expirationDate);
    }

    public void blockOnRequest() {
        this.setStatus(false);
        logger.warn(String.format(
                "The card %s has been blocked at the request of the client %s.",
                this.getNumber(), this.getNameAndSurname()));
    }

    public void blockAfterExpiration() {
        LocalDate currentDate = LocalDate.now();
        if (this.expirationDate.isEqual(currentDate) || this.expirationDate.isBefore(currentDate)) {
            this.blockOnRequest();
            logger.warn(String.format(
                    "The card %s of %s has been blocked due to expiration (card issue date = %s, expiration date = %s).",
                    this.getNumber(), this.getNameAndSurname(), this.getIssueDate(), this.getExpirationDate()));
        }
    }
}
