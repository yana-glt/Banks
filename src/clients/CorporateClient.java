package clients;

import products.accounts.CorporateClientsAccount;

public class CorporateClient extends Client {

	private String name;
	private String directorsName;
	private String directorsSurname;
	private String directorsPhoneNumber;
	private String accountantsName;
	private String accountantsSurname;
	private String accountantsPhoneNumber;
	private CorporateClientsAccount account;

	// Variables that are used to determine the solvency of the client when lending
	private double solvencyAssessment;

	public CorporateClient() {

	}

	public CorporateClient(long id, String identificationNumber, String phoneNumber, String address, String name,
			String directorsName, String directorsSurname, String directorsPhoneNumber, String accountantsName,
			String accountantsSurname, String accountantsPhoneNumber, CorporateClientsAccount account) {
		super(id, identificationNumber, phoneNumber, address);
		this.name = name;
		this.directorsName = directorsName;
		this.directorsSurname = directorsSurname;
		this.directorsPhoneNumber = directorsPhoneNumber;
		this.accountantsName = accountantsName;
		this.accountantsSurname = accountantsSurname;
		this.accountantsPhoneNumber = accountantsPhoneNumber;
		this.account = account;
	}

	public CorporateClient(long id, String identificationNumber, String phoneNumber, String address, String name,
			String directorsName, String directorsSurname, String directorsPhoneNumber, String accountantsName,
			String accountantsSurname, String accountantsPhoneNumber, CorporateClientsAccount account,
			double solvencyAssessment) {
		super(id, identificationNumber, phoneNumber, address);
		this.name = name;
		this.directorsName = directorsName;
		this.directorsSurname = directorsSurname;
		this.directorsPhoneNumber = directorsPhoneNumber;
		this.accountantsName = accountantsName;
		this.accountantsSurname = accountantsSurname;
		this.accountantsPhoneNumber = accountantsPhoneNumber;
		this.account = account;
		this.solvencyAssessment = solvencyAssessment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirectorsName() {
		return directorsName;
	}

	public void setDirectorsName(String directorsName) {
		this.directorsName = directorsName;
	}

	public String getDirectorsSurname() {
		return directorsSurname;
	}

	public void setDirectorsSurname(String directorsSurname) {
		this.directorsSurname = directorsSurname;
	}

	public String getDirectorsPhoneNumber() {
		return directorsPhoneNumber;
	}

	public void setDirectorsPhoneNumber(String directorsPhoneNumber) {
		this.directorsPhoneNumber = directorsPhoneNumber;
	}

	public String getAccountantsName() {
		return accountantsName;
	}

	public void setAccountantsName(String accountantsName) {
		this.accountantsName = accountantsName;
	}

	public String getAccountantsSurname() {
		return accountantsSurname;
	}

	public void setAccountantsSurname(String accountantsSurname) {
		this.accountantsSurname = accountantsSurname;
	}

	public String getAccountantsPhoneNumber() {
		return accountantsPhoneNumber;
	}

	public void setAccountantsPhoneNumber(String accountantsPhoneNumber) {
		this.accountantsPhoneNumber = accountantsPhoneNumber;
	}

	public CorporateClientsAccount getAccount() {
		return account;
	}

	public void setAccount(CorporateClientsAccount account) {
		this.account = account;
	}

	public double getSolvencyAssessment() {
		return solvencyAssessment;
	}

	public void setSolvencyAssessment(double solvencyAssessment) {
		this.solvencyAssessment = solvencyAssessment;
	}

}
