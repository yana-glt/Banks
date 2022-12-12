package clients;

import java.util.Objects;

import exception_handlers.IncorrectValueException;
import products.accounts.CorporateClientsAccount;

public class CorporateClient extends Client implements IAssessSolvency {

	private String name;
	private String directorsName;
	private String directorsSurname;
	private String directorsPhoneNumber;
	private CorporateClientsAccount account;
	private double solvencyAssessment;

	public CorporateClient() {

	}

	public CorporateClient(String identificationNumber, String phoneNumber, String emailAddress, String name,
			String directorsName, String directorsSurname) {
		super(identificationNumber, phoneNumber, emailAddress);
		this.name = name;
		this.directorsName = directorsName;
		this.directorsSurname = directorsSurname;
	}

	public CorporateClient(String identificationNumber, String phoneNumber, String emailAddress, String name,
			String directorsName, String directorsSurname, double solvencyAssessment) {
		super(identificationNumber, phoneNumber, emailAddress);
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
		if (!super.equals(obj))
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		if (this.hashCode() != obj.hashCode())
			return false;
		CorporateClient other = (CorporateClient) obj;
		return (this.name == other.name || (this.name != null ? this.name.equals(other.name) : other.name == null))
				&& (this.directorsName == other.directorsName
						|| (this.directorsName != null ? this.directorsName.equals(other.directorsName)
								: other.directorsName == null))
				&& (this.directorsSurname == other.directorsSurname
						|| (this.directorsSurname != null ? this.directorsSurname.equals(other.directorsSurname)
								: other.directorsSurname == null));
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
		return String.format("%s, name=%s, account=%s", super.toString(), name, account.getAccountNumber());
	}

	@Override
	public boolean assessSolvency() throws IncorrectValueException {
		if (solvencyAssessment <= 0 || solvencyAssessment > 100) {
			throw new IncorrectValueException(
					"The value of the client solvency assessment must be in the range from 1 to 100",
					"Incorrect value of the assessment of the client's solvency");
		} else if (solvencyAssessment >= 75) {
			System.out.println(String.format("The financial condition of the client %s allows to receive a credit.",
					this.getName()));
			return true;
		} else if (solvencyAssessment >= 50) {
			System.out
					.println(String.format("Client %s can get a credit, but collateral is required.", this.getName()));
			return true;
		} else {
			System.out.println(String.format("Credit cannot be granted to %s", this.getName()));
			return false;
		}
	}
}
