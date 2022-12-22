package branches;

import products.accounts.IndividualClientsAccount;

public class Employee {
	private static int numberOfEmployees = 0;
	private int id;
	private String name;
	private String surname;
	private String dateOfBirth;
	private float salary;
	private String phoneNumber;
	private String position;
	private Department department;
	private Branch branch;
	private IndividualClientsAccount account;

	public Employee() {

	}

	public Employee(String name, String surname, String dateOfBirth, float salary, String phoneNumber, String position,
			Department department, Branch branch) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.position = position;
		this.department = department;
		this.branch = branch;
		this.id = ++numberOfEmployees;
	}

	public static int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public IndividualClientsAccount getAccount() {
		return account;
	}

	public void setAccount(IndividualClientsAccount account) {
		this.account = account;
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass()) || (this.hashCode() != obj.hashCode()))
			return false;
		Employee other = (Employee) obj;
		boolean isIdEqual = (this.id == other.id);
		boolean isNameEqual = (this.name == null && other.name == null)
				|| (this.name != null && this.name == other.name);
		boolean isSurnameEqual = (this.surname == null && other.surname == null)
				|| (this.surname != null && this.surname == other.surname);
		boolean isDateOfBirthEqual = (this.dateOfBirth == null && other.dateOfBirth == null)
				|| (this.dateOfBirth != null && this.dateOfBirth == other.dateOfBirth);
		return isIdEqual && isNameEqual && isSurnameEqual && isDateOfBirthEqual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + id;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return String.format("Employee information:id=%d , name=%s, surname=%s , dateOfBirth=%s, position=%s, %s, %s",
				id, name, surname, dateOfBirth, position, department.toString(), branch.toString());
	}
}
