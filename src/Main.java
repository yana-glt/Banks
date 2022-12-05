import branches.Branch;
import branches.Department;
import branches.Employee;
import clients.CorporateClient;
import clients.IndividualClient;
import products.accounts.CorporateClientsAccount;
import products.Currency;
import products.accounts.IndividualClientsAccount;
import products.credits.CorporateClientsCredit;
import products.credits.IndividualClientsCredit;

public class Main {

	public static void main(String[] args) {

		Branch krakowBranch = new Branch("Bank branch in Krakow", "Krakow", "+48963365100");
		Branch warsawBranch = new Branch("Bank branch in Warsaw", "Warsaw", "+48702502630");

//		System.out.println(krakowBranch.getId());
//		System.out.println(warsawBranch.getId());
//		System.out.println(Branch.getNumberOfBranches());
//		System.out.println(krakowBranch.toString());

		Department finance = new Department("Finance");
		Department treasury = new Department("Treasury");
		Department hr = new Department("Human resources");

//		System.out.println(finance.getDepartmentId());
//		System.out.println(treasury.getDepartmentId());
//		System.out.println(hr.getDepartmentId());
//		System.out.println(Department.getNumberOfDepartments());
//		System.out.println(hr.toString());

		Employee emp1 = new Employee("Susan", "Smith", "04/09/1990", 1400, "+48962456981", "Manager", finance,
				warsawBranch);
		Employee emp2 = new Employee("Carol", "Brown", "04/09/1990", 1400, "+48962456981", "Manager", treasury,
				warsawBranch);
		Employee emp3 = new Employee("Edward", "Evans", "04/09/1990", 1400, "+48962456981", "Manager", hr,
				krakowBranch);
		warsawBranch.getListOfEmployees().add(emp1);
		warsawBranch.getListOfEmployees().add(emp2);
		krakowBranch.getListOfEmployees().add(emp3);
		finance.getListOfEmployees().add(emp1);
		treasury.getListOfEmployees().add(emp2);
		hr.getListOfEmployees().add(emp3);

//		System.out.println(emp1.getId());
//		System.out.println(emp3.getId());
//		System.out.println(Employee.getNumberOfEmployees());
//		System.out.println(emp1.equals(emp2));
//		System.out.println(emp3.toString());
//		System.out.println(warsawBranch.getListOfEmployees());
//		System.out.println(treasury.getListOfEmployees());

		IndividualClient firstClient = new IndividualClient("KL54687848OIO", "+45951862459", "tomasandersen@gmail.com",
				"Tomas", "Andersen", "12/22/1996", "Polish", 2000.00);
		IndividualClientsAccount account1 = new IndividualClientsAccount("PL00000000000000000000000001", "current",
				true, 900.54f, Currency.USD, warsawBranch, firstClient);
		firstClient.setAccount(account1);

		IndividualClient secondClient = new IndividualClient("1549874651354", "+45789258654", "annaandersen@gmail.com",
				"Anna", "Andersen", "07/14/1999", "Polish", 2600.00);
		IndividualClientsAccount account2 = new IndividualClientsAccount("PL00000000000000000000000002", "current",
				true, 8400.54f, Currency.EUR, warsawBranch, secondClient);
		secondClient.setAccount(account2);

		IndividualClient thirdClient = new IndividualClient("0265921056489", "+48236102003", "gwenmartin@gmail.com",
				"Gwen", "Martin", "07/14/1999", "Polish");
		IndividualClientsAccount account3 = new IndividualClientsAccount("PL00000000000000000000000003", "current",
				true, 920.4f, Currency.EUR, warsawBranch, thirdClient);
		thirdClient.setAccount(account3);

		warsawBranch.getListOfClients().add(firstClient);
		warsawBranch.getListOfClients().add(secondClient);
		warsawBranch.getListOfClients().add(thirdClient);
//		System.out.println(warsawBranch.getListOfClients());
//		warsawBranch.notifyAllClients(warsawBranch.getListOfClients(), "Hello");

//		System.out.println(firstClient.equals(secondClient));
//		System.out.println(firstClient.hashCode());
//		System.out.println(secondClient.hashCode());
//		System.out.println(firstClient.toString());
//		System.out.println(secondClient.toString());
//		System.out.println(account1.equals(account2));
//		System.out.println(account1.hashCode());
//		System.out.println(account2.hashCode());
//		System.out.println(account3.hashCode());
//		System.out.println(account1.toString());
//		System.out.println(account2.toString());
//		System.out.println(account3.toString());

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
//		krakowBranch.notifyAllClients(krakowBranch.getListOfClients(), "Bye");

//		System.out.println(secondClient.getId());
//		System.out.println(fourthClient.getId());
//		System.out.println(CorporateClient.getNumberOfClients());

//		System.out.println(fifthClient.equals(fourthClient));
//		System.out.println(fifthClient.hashCode());
//		System.out.println(fourthClient.hashCode());
//		System.out.println(fifthClient.toString());
//		System.out.println(fourthClient.toString());

//		System.out.println(account5.getAccountBalance());
//		account5.refillBalance(5000.52f);
//		account5.deductBalance(1000.25f);
//		account5.closeAccount();
//		System.out.println(account5.getStatus());

		IndividualClientsCredit credit1 = new IndividualClientsCredit(10.00, 36, 80000, Currency.EUR);
		// credit1.giveCredit(firstClient);

		IndividualClientsCredit credit2 = new IndividualClientsCredit(11.50, 24, 60000, Currency.EUR);
		// credit2.giveCredit(secondClient);

		CorporateClientsCredit credit4 = new CorporateClientsCredit(10.00, 36, 80000.00, Currency.EUR);
		// credit4.giveCredit(fourthClient);

		CorporateClientsCredit credit5 = new CorporateClientsCredit(11.50, 24, 60000.00, Currency.EUR);
		// credit5.giveCredit(fifthClient);

//		System.out.println(credit3.equals(credit4));
//		System.out.println(credit3.hashCode());
//		System.out.println(credit4.hashCode());
//		System.out.println(credit3.toString());
//		System.out.println(credit4.toString());

//		 firstClient.assessSolvency();
//		 secondClient.assessSolvency();
//		 fourthClient.assessSolvency();
//		 fifthClient.assessSolvency();

	}

}