package clients;

import java.util.Objects;

public abstract class Client {
	private static long numberOfClients = 0L;
	private long id;
	private String identificationNumber;
	private String phoneNumber;
	private String emailAddress;

	public Client() {

	}

	public Client(String identificationNumber, String phoneNumber, String emailAddress) {
		this.identificationNumber = identificationNumber;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.id = ++numberOfClients;
	}

	public static long getNumberOfClients() {
		return numberOfClients;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (this.hashCode() != obj.hashCode())
			return false;
		Client other = (Client) obj;
		boolean idEquality = (this.id == other.id);
		boolean identificationNumberEquality = (this.identificationNumber == null && other.identificationNumber == null)
				|| (this.identificationNumber != null && this.identificationNumber == other.identificationNumber);
		return idEquality && identificationNumberEquality;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, identificationNumber);
	}

	@Override
	public String toString() {
		return String.format("Information about the client: id=%d, IdentificationNumber=%s, phoneNumber=%s, email=%s",
				id, identificationNumber, phoneNumber, emailAddress);
	}
}
