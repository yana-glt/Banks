package branches;

import java.math.BigDecimal;
import java.time.LocalDate;

import products.accounts.IndividualClientsAccount;

public class Employee {
    private static int numberOfEmployees = 0;
    private int id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private BigDecimal salary;
    private String phoneNumber;
    private String position;
    private Department department;
    private Branch branch;
    private IndividualClientsAccount account;

    public Employee() {

    }

    public Employee(String name, String surname, LocalDate dateOfBirth, BigDecimal salary, String phoneNumber, String position,
                    Department department, Branch branch) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.department = department;
        this.branch = branch;
        this.id = ++numberOfEmployees;
    }

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        if (this.hashCode() != obj.hashCode())
            return false;
        Employee other = (Employee) obj;
        return this.id == other.id
                && (this.name == other.name || (this.name != null ? this.name.equals(other.name) : other.name == null))
                && (this.surname == other.surname
                || (this.surname != null ? this.surname.equals(other.surname) : other.surname == null))
                && (this.dateOfBirth == other.dateOfBirth
                || (this.dateOfBirth != null ? this.dateOfBirth.equals(other.dateOfBirth)
                : other.dateOfBirth == null));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + id;
        result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return String.format("Employee information:id=%d , name=%s, surname=%s , dateOfBirth=%s, position=%s, %s, %s",
                id, name, surname, dateOfBirth, position, department.toString(), branch.toString());
    }
}
