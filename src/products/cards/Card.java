package products.cards;

public abstract class Card {

	private String number;
	private String nameAndSurname;
	private String expirationDate;
	private int cvvCode;
	private String issueDate;
	private int pin;
	private boolean status;

	public Card() {

	}

	public Card(String number, String nameAndSurname, String expirationDate, int cvvCode, String issueDate, int pin,
			boolean status) {
		this.number = number;
		this.nameAndSurname = nameAndSurname;
		this.expirationDate = expirationDate;
		this.cvvCode = cvvCode;
		this.issueDate = issueDate;
		this.pin = pin;
		this.status = true;
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

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(int cvvCode) {
		this.cvvCode = cvvCode;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
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

	abstract void block(Card card);
}
