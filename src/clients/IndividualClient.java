package clients;

import java.util.Objects;

import products.accounts.IndividualClientsAccount;

public class IndividualClient extends Client {

	private String name;
	private String surname;
	private String dateOfBirth;
	private String placeOfBirth;
	private String citizenship;
	private IndividualClientsAccount account;

	// Variables that are used to determine the solvency of the client when lending
	private double averageSalary;

	public IndividualClient() {

	}

	public IndividualClient(long id, String identificationNumber, String phoneNumber, String address, String name,
			String surname, String dateOfBirth, String placeOfBirth, String citizenship) {
		super(id, identificationNumber, phoneNumber, address);
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.citizenship = citizenship;
	}

	public IndividualClient(long id, String identificationNumber, String phoneNumber, String address, String name,
			String surname, String dateOfBirth, String placeOfBirth, String citizenship,
			double averageSalary) {
		super(id, identificationNumber, phoneNumber, address);
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.citizenship = citizenship;
		this.averageSalary = averageSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public double getAverageSalary() {
		return averageSalary;
	}

	public void setAverageSalary(double averageSalary) {
		this.averageSalary = averageSalary;
	}

	public IndividualClientsAccount getAccount() {
		return account;
	}

	public void setAccount(IndividualClientsAccount account) {
		this.account = account;
	}	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		IndividualClient other = (IndividualClient) obj;
		return Objects.equals(this.name, other.name)
				&& Objects.equals(this.surname, other.surname) 
				&& Objects.equals(this.dateOfBirth, other.dateOfBirth) 
				&& Objects.equals(this.placeOfBirth, other.placeOfBirth) ;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name, surname, dateOfBirth, placeOfBirth);
		return result;
	}

	@Override
	public String toString() {
		return super.toString() + " Individual client information: name=" + name + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth
				+ ", placeOfBirth=" + placeOfBirth + ", citizenship=" + citizenship + ", account=" + account.getAccountNumber() + ".";
	}


}
