package branches;

import java.util.List;

public class Branch {
	private int id;
	private String name;
	private String address;
	private String phoneNumber;
	private Employee headOfOffice;
	private List<Department> listOfDepartments;
	private List<Employee> listOfEmployees;

	public Branch() {

	}

	public Branch(int id, String name, String address, String phoneNumber, Employee headOfOffice,
			List<Department> listOfDepartments, List<Employee> listOfEmployees) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.headOfOffice = headOfOffice;
		this.listOfDepartments = listOfDepartments;
		this.listOfEmployees = listOfEmployees;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Employee getHeadOfOffice() {
		return headOfOffice;
	}

	public void setHeadOfOffice(Employee headOfOffice) {
		this.headOfOffice = headOfOffice;
	}

	public List<Department> getListOfDepartments() {
		return listOfDepartments;
	}

	public void setListOfDepartments(List<Department> listOfDepartments) {
		this.listOfDepartments = listOfDepartments;
	}

	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}

}
