package main.java.com.solvd.banks.clients;

import main.java.com.solvd.banks.branches.Branch;

import java.util.Objects;

public abstract class Client {
	private static int numberOfClients = 0;
	private int id;
	private String identificationNumber;
	private String phoneNumber;
	private String emailAddress;

	private Branch branch;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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


	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
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
		return this.id == other.id && (this.identificationNumber == other.identificationNumber
				|| (this.identificationNumber != null ? this.identificationNumber.equals(other.identificationNumber)
						: other.identificationNumber == null));
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, identificationNumber);
	}

	@Override
	public String toString() {
		return String.format("Client: id=%d, IdentificationNumber=%s, phoneNumber=%s, email=%s",
				id, identificationNumber, phoneNumber, emailAddress);
	}
}
