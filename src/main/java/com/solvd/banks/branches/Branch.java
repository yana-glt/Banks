package main.java.com.solvd.banks.branches;

import java.util.ArrayList;

import main.java.com.solvd.banks.clients.Client;
import main.java.com.solvd.banks.products.cards.Card;
import main.java.com.solvd.banks.products.credits.Credit;

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

	private ArrayList<Client> listOfAccounts = new ArrayList<>();

	private ArrayList<Credit> listOfCredits = new ArrayList<>();

	private ArrayList<Card> listOfCards = new ArrayList<>();

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


	public ArrayList<Client> getListOfAccounts() {
		return listOfAccounts;
	}

	public void setListOfAccounts(ArrayList<Client> listOfAccounts) {
		this.listOfAccounts = listOfAccounts;
	}

	public ArrayList<Credit> getListOfCredits() {
		return listOfCredits;
	}

	public void setListOfCredits(ArrayList<Credit> listOfCredits) {
		this.listOfCredits = listOfCredits;
	}

	public ArrayList<Card> getListOfCards() {
		return listOfCards;
	}

	public void setListOfCards(ArrayList<Card> listOfCards) {
		this.listOfCards = listOfCards;
	}

	@Override
	public String toString() {
		return String.format("Branch [id=%d , name=%s]", id, name);
	}

	public static <T> T getLastElementOfList(ArrayList<T> list) {
		return list.get((list.size() - 1));
	}
}
