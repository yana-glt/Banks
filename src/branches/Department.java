package branches;

import java.util.List;

public class Department {
	private int departmentID;
	private String name;
	private Employee headOfDepartment;
	private List<Employee> listOfEmployees;
	private Branch branch;

	public Department() {

	}

	public Department(int departmentID, String name, Employee headOfDepartment, List<Employee> listOfEmployees,
			Branch branch) {
		this.departmentID = departmentID;
		this.name = name;
		this.headOfDepartment = headOfDepartment;
		this.listOfEmployees = listOfEmployees;
		this.branch = branch;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getHeadOfDepartment() {
		return headOfDepartment;
	}

	public void setHeadOfDepartment(Employee headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
