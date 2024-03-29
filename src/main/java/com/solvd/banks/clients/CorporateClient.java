package main.java.com.solvd.banks.clients;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import main.java.com.solvd.banks.exception_handlers.IncorrectValueException;
import main.java.com.solvd.banks.products.accounts.CorporateClientsAccount;
import main.java.com.solvd.banks.products.credits.CorporateClientsCredit;

public class CorporateClient extends Client implements IAssessSolvency {
    private String name;
    private String directorsName;
    private String directorsSurname;
    private String directorsPhoneNumber;
    private CorporateClientsAccount account;
    private List<CorporateClientsCredit> listOfCredits = new ArrayList<>();
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

    public List<CorporateClientsCredit> getListOfCredits() {
        return listOfCredits;
    }

    public void setListOfCredits(List<CorporateClientsCredit> listOfCredits) {
        this.listOfCredits = listOfCredits;
    }

    @Override
    public boolean equals(Object obj) {
        if ((!super.equals(obj)) || (this.getClass() != obj.getClass()) || (this.hashCode() != obj.hashCode()))
            return false;
        CorporateClient other = (CorporateClient) obj;
        boolean isNameEqual = (this.name == null && other.name == null)
                || (this.name != null && this.name == other.name);
        return isNameEqual;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(name);
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
                    "The value of the client solvency assessment must be in the range from 1 to 100. ", this.name,
                    this.solvencyAssessment);
        } else if (solvencyAssessment >= 75) {
            System.out.println(String.format("The financial condition of the client %s allows to receive a credit.",
                    this.getName()));
            return true;
        } else if (solvencyAssessment >= 50) {
            System.out.println(String.format("Client %s can get a credit, but collateral is required.", this.getName()));
            return true;
        } else {
            System.out.println(String.format("Credit cannot be granted to %s", this.getName()));
            return false;
        }
    }
}