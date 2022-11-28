package clients;

import java.util.Objects;

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
			String directorsName, String directorsSurname) {
		super(id, identificationNumber, phoneNumber, address);
		this.name = name;
		this.directorsName = directorsName;
		this.directorsSurname = directorsSurname;
	}

	public CorporateClient(long id, String identificationNumber, String phoneNumber, String address, String name,
			String directorsName, String directorsSurname,
			double solvencyAssessment) {
		super(id, identificationNumber, phoneNumber, address);
		this.name = name;
		this.directorsName = directorsName;
		this.directorsSurname = directorsSurname;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		CorporateClient other = (CorporateClient) obj;
		return Objects.equals(this.name, other.name) && Objects.equals(this.directorsName, other.directorsName)
				&& Objects.equals(this.directorsSurname, other.directorsSurname);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name, directorsName, directorsSurname);
		return result;
	}

	@Override
	public String toString() {
		return super.toString() + " Corporate client information: name=" + name + ", directorsName=" + directorsName
				+ ", directorsSurname=" + directorsSurname + ", directorsPhoneNumber=" + directorsPhoneNumber
				+ ", accountantsName=" + accountantsName + ", accountantsSurname=" + accountantsSurname
				+ ", accountantsPhoneNumber=" + accountantsPhoneNumber + ", account=" + account.getAccountNumber() + ".";
	}

}
