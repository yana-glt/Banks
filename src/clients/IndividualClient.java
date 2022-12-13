package clients;

import java.util.Objects;
import java.util.Scanner;

import exception_handlers.WrongValueTypeException;
import products.accounts.IndividualClientsAccount;
import products.credits.IndividualClientsCredit;

public class IndividualClient extends Client implements IAssessSolvency {

	private String name;
	private String surname;
	private String dateOfBirth;
	private String citizenship;
	private IndividualClientsAccount account;
	private double averageSalary;

	public IndividualClient() {

	}

	public IndividualClient(String identificationNumber, String phoneNumber, String emailAddress, String name,
			String surname, String dateOfBirth, String citizenship) {
		super(identificationNumber, phoneNumber, emailAddress);
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.citizenship = citizenship;
	}

	public IndividualClient(String identificationNumber, String phoneNumber, String emailAddress, String name,
			String surname, String dateOfBirth, String citizenship, double averageSalary) {
		super(identificationNumber, phoneNumber, emailAddress);
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (this.hashCode() != obj.hashCode())
			return false;
		IndividualClient other = (IndividualClient) obj;
		boolean nameEquality = (this.name == null && other.name == null)
				|| (this.name != null && this.name == other.name);
		boolean surnameEquality = (this.surname == null && other.surname == null)
				|| (this.surname != null && this.surname == other.surname);
		boolean dateOfBirthEquality = (this.dateOfBirth == null && other.dateOfBirth == null)
				|| (this.dateOfBirth != null && this.dateOfBirth == other.dateOfBirth);
		return nameEquality && surnameEquality && dateOfBirthEquality;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name, surname, dateOfBirth);
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s, name=%s, surname=%s, dateOfBirth=%s, citizenship=%s, account=%s", super.toString(),
				name, surname, dateOfBirth, citizenship, account.getAccountNumber());
	}

	@Override
	public boolean assessSolvency() throws WrongValueTypeException {
		double rate = 0;
		int term = 0;
		double amount = 0;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter interest rate with two decimal places");
			if (!scanner.hasNextDouble()) {
				throw new WrongValueTypeException("The user entered a value of the wrong type");
			} else {
				rate = scanner.nextDouble();
			}
			System.out.println("Enter credit term (in months)");
			if (!scanner.hasNextInt()) {
				throw new WrongValueTypeException("The user entered a value of the wrong type");
			} else {
				term = scanner.nextInt();
			}
			System.out.println("Enter credit amount");
			if (!scanner.hasNextDouble()) {
				throw new WrongValueTypeException("The user entered a value of the wrong type");
			} else {
				amount = scanner.nextDouble();
			}
		}
		double monthlyPayment = IndividualClientsCredit.determineMonthlyPayment(rate, term, amount);
		if (monthlyPayment <= 0.5 * this.averageSalary) {
			System.out.println(String.format("Client %s %s has sufficient income to receive this credit.",
					this.getName(), this.getSurname()));
			return true;
		} else {
			System.out.println(String.format("Client  %s %s does not have sufficient income to receive this credit.",
					this.getName(), this.getSurname()));
			return false;
		}
	}
}
