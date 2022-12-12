package products.cards;

import java.time.LocalDate;

public abstract class Card {

	private String number;
	private String nameAndSurname;
	private LocalDate issueDate;
	private LocalDate expirationDate;
	private int cvvCode;
	private int pin;
	private boolean status;

	public Card() {

	}

	public Card(String number, String nameAndSurname, LocalDate issueDate, int cvvCode, int pin, boolean status) {
		this.number = number;
		this.nameAndSurname = nameAndSurname;
		this.issueDate = issueDate;
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

	public void determineCardExpirationDate() {
		LocalDate expirationDate = this.issueDate.plusYears(3L);
		this.setExpirationDate(expirationDate);
	}

	public void blockOnRequest() {
		this.setStatus(false);
	}

	public void blockAfterExpiration() {
		LocalDate currentDate = LocalDate.now();
		if (this.expirationDate.isEqual(currentDate)) {
			this.blockOnRequest();
		}
	}
}
