package branches;

import products.accounts.IndividualClientsAccount;

public class Employee {

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

	public Employee(int id, String name, String surname, String dateOfBirth, float salary, String phoneNumber,
			String position, Department department, Branch branch, IndividualClientsAccount account) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.position = position;
		this.department = department;
		this.branch = branch;
		this.account = account;
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

}
