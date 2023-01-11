import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.com.solvd.banks.branches.Branch;
import main.java.com.solvd.banks.branches.Department;
import main.java.com.solvd.banks.branches.Employee;
import main.java.com.solvd.banks.clients.Client;
import main.java.com.solvd.banks.clients.CorporateClient;
import main.java.com.solvd.banks.clients.IndividualClient;
import main.java.com.solvd.banks.exception_handlers.IncorrectValueException;
import main.java.com.solvd.banks.exception_handlers.WrongValueTypeException;
import main.java.com.solvd.banks.products.accounts.Account;
import main.java.com.solvd.banks.products.accounts.CorporateClientsAccount;
import main.java.com.solvd.banks.products.Currency;
import main.java.com.solvd.banks.products.accounts.IndividualClientsAccount;
import main.java.com.solvd.banks.products.cards.Card;
import main.java.com.solvd.banks.products.cards.CorporateClientsCard;
import main.java.com.solvd.banks.products.credits.CorporateClientsCredit;
import main.java.com.solvd.banks.products.credits.IndividualClientsCredit;

public class Main {
    public static void main(String[] args) {

        Branch krakowBranch = new Branch("Bank branch in Krakow", "Krakow", "+48963365100");
        Branch warsawBranch = new Branch("Bank branch in Warsaw", "Warsaw", "+48702502630");
        Department finance = new Department("Finance");
        Department treasury = new Department("Treasury");
        Department hr = new Department("Human resources");
        Employee emp1 = new Employee("Susan", "Smith", LocalDate.of(1989, 9, 4), BigDecimal.valueOf(1400),
                "+48962456981", "Manager", finance, warsawBranch);
        Employee emp2 = new Employee("Carol", "Brown", LocalDate.of(1987, 7, 10), BigDecimal.valueOf(2400),
                "+48962456981", "Manager", treasury, warsawBranch);
        Employee emp3 = new Employee("Edward", "Evans", LocalDate.of(1991, 3, 1), BigDecimal.valueOf(1900),
                "+48962456981", "Manager", hr, krakowBranch);
        Employee emp4 = new Employee("Kevin", "Rose", LocalDate.of(1980, 5, 18), BigDecimal.valueOf(1800),
                "+48062445971", "Manager", hr, krakowBranch);
        warsawBranch.getListOfEmployees().add(emp1);
        warsawBranch.getListOfEmployees().add(emp2);
        krakowBranch.getListOfEmployees().add(emp3);
        finance.getListOfEmployees().add(emp1);
        treasury.getListOfEmployees().add(emp2);
        hr.getListOfEmployees().add(emp3);
        hr.getListOfEmployees().add(emp4);
        IndividualClient firstClient = new IndividualClient("KL54687848OIO", "+45951862459", "tomasandersen@gmail.com",
                "Tomas", "Andersen", LocalDate.of(1996, 12, 22), "Polish", 2000.00);
        IndividualClientsAccount account1 = new IndividualClientsAccount("PL00000000000000000000000001", "current",
                true, 900.54f, Currency.USD, warsawBranch, firstClient);
        firstClient.setAccount(account1);
        IndividualClient secondClient = new IndividualClient("1549874651354", "+45789258654", "annaandersen@gmail.com",
                "Anna", "Andersen", LocalDate.of(1999, 7, 14), "Polish", 2600.00);
        IndividualClientsAccount account2 = new IndividualClientsAccount("PL00000000000000000000000002", "current",
                true, 8400.54f, Currency.EUR, warsawBranch, secondClient);
        secondClient.setAccount(account2);
        IndividualClient thirdClient = new IndividualClient("0265921056489", "+48236102003", "gwenmartin@gmail.com",
                "Gwen", "Martin", LocalDate.of(1989, 8, 10), "Polish");
        IndividualClientsAccount account3 = new IndividualClientsAccount("PL00000000000000000000000003", "current",
                true, 920.4f, Currency.EUR, warsawBranch, thirdClient);
        thirdClient.setAccount(account3);
        warsawBranch.getListOfClients().add(firstClient);
        warsawBranch.getListOfClients().add(secondClient);
        warsawBranch.getListOfClients().add(thirdClient);
        CorporateClient fourthClient = new CorporateClient("987654321", "+45654987321", "klm@gmail.com", "KLM", "Anna",
                "Andersen", 46.12);
        CorporateClientsAccount account4 = new CorporateClientsAccount("PL00000000000000000000000004", "current", true,
                8400.54f, Currency.EUR, krakowBranch, fourthClient);
        fourthClient.setAccount(account4);
        CorporateClient fifthClient = new CorporateClient("123456789", "+45456951753", "asb@gmail.com", "ASB", "Tomas",
                "Andersen", 78.89);
        CorporateClientsAccount account5 = new CorporateClientsAccount("PL00000000000000000000000005", "current", true,
                900.54f, Currency.USD, krakowBranch, fifthClient);
        fifthClient.setAccount(account5);
        krakowBranch.getListOfClients().add(fourthClient);
        krakowBranch.getListOfClients().add(fifthClient);

        krakowBranch.notifyAllClients(krakowBranch.getListOfClients(), "message");

        IndividualClientsCredit credit1 = new IndividualClientsCredit(10.00, 36, 80000, Currency.EUR);
        IndividualClientsCredit credit2 = new IndividualClientsCredit(11.50, 24, 60000, Currency.EUR);
        CorporateClientsCredit credit4 = new CorporateClientsCredit(10.00, 36, 80000.00, Currency.EUR);
        credit4.giveCredit(fourthClient);
        CorporateClientsCredit credit5 = new CorporateClientsCredit(11.50, 24, 60000.00, Currency.EUR);
        credit5.giveCredit(fifthClient);

//		 Array Examples
        Employee[] arrayOfEmployees = {emp1, emp2, emp3};
        for (Employee emp : arrayOfEmployees) {
            System.out.println(emp);
        }

        Client[] arrayOfClients = {firstClient, secondClient, thirdClient, fourthClient, fifthClient};
        for (Client c : arrayOfClients) {
            System.out.println(c);
        }

        credit5.getInfoAboutAnyProduct();
        account5.getInfoAboutAnyProduct();

        Card card5 = new CorporateClientsCard("92562598459216579841", "TOMAS ANDERSEN", LocalDate.of(2019, 12, 12), 236,
                8954, true, account5, fifthClient);
        System.out.println(card5.toString());
        System.out.println(card5.getExpirationDate());
        card5.blockAfterExpiration();
        System.out.println(card5.toString());

        System.out.println(account5.getAccountBalance());
//		account5.refillBalance(500.52f);
//		account5.deductBalance(5100.25f);
//		account5.blockAccount(emp1);
//		account5.blockAccount(emp2);
//		account5.refillBalance(500.52f);
//		account5.deductBalance(5100.25f);

        List<Account> accountList = new ArrayList<>();
        accountList.add(account5);
        accountList.add(account4);
        accountList.add(account3);
        Account.getSumOfBalances(accountList);

        System.out.println(account4.getAccountBalance());
        System.out.println(account5.getAccountBalance());
        Account.transferMoney(account4, account5, 456.35f);
    }
}
