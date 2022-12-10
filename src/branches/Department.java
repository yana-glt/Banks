package branches;

import java.util.ArrayList;

public class Department {
	private static int numberOfDepartments = 0;
	private int departmentId;
	private String name;
	private Employee headOfDepartment;
	private ArrayList<Employee> listOfEmployees = new ArrayList<>();
	private Branch branch;

	public Department() {

	}

	public Department(String name) {
		this.name = name;
		this.departmentId = ++numberOfDepartments;
	}

	public static int getNumberOfDepartments() {
		return numberOfDepartments;
	}

	public static void setNumberOfDepartments(int numberOfDepartments) {
		Department.numberOfDepartments = numberOfDepartments;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
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

	public ArrayList<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(ArrayList<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return String.format("Department [id=%d, name=%s]", departmentId, name);
	}
}
