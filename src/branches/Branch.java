package branches;

import java.util.ArrayList;

import clients.Client;

public class Branch implements INotifyClients {
	private static int numberOfBranches = 0;
	private int id;
	private String name;
	private String address;
	private String phoneNumber;
	private Employee headOfOffice;
	private ArrayList<Department> listOfDepartments = new ArrayList<>();
	private ArrayList<Employee> listOfEmployees = new ArrayList<>();
	private ArrayList<Client> listOfClients = new ArrayList<>();

	public Branch() {

	}

	public Branch(String name, String address, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.id = ++numberOfBranches;
	}

	public static int getNumberOfBranches() {
		return numberOfBranches;
	}

	public static void setNumberOfBranches(int numberOfBranches) {
		Branch.numberOfBranches = numberOfBranches;
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

	public ArrayList<Department> getListOfDepartments() {
		return listOfDepartments;
	}

	public void setListOfDepartments(ArrayList<Department> listOfDepartments) {
		this.listOfDepartments = listOfDepartments;
	}

	public ArrayList<Employee> getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(ArrayList<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}

	public ArrayList<Client> getListOfClients() {
		return listOfClients;
	}

	public void setListOfClients(ArrayList<Client> listOfClients) {
		this.listOfClients = listOfClients;
	}

	@Override
	public String toString() {
		return String.format("Branch [id=%d , name=%s]", id, name);
	}
}
