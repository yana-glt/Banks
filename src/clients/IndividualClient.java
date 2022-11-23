package clients;

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
			String surname, String dateOfBirth, String placeOfBirth, String citizenship,
			IndividualClientsAccount account) {
		super(id, identificationNumber, phoneNumber, address);
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.citizenship = citizenship;
		this.account = account;
	}

	public IndividualClient(long id, String identificationNumber, String phoneNumber, String address, String name,
			String surname, String dateOfBirth, String placeOfBirth, String citizenship,
			IndividualClientsAccount account, double averageSalary) {
		super(id, identificationNumber, phoneNumber, address);
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.citizenship = citizenship;
		this.account = account;
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

}
