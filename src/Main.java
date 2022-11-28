
import branches.Branch;
import clients.CorporateClient;
import clients.IndividualClient;
import products.accounts.CorporateClientsAccount;
import products.accounts.IndividualClientsAccount;
import products.credits.CorporateClientsCredit;
import products.credits.IndividualClientsCredit;

public class Main {

	public static void main(String[] args) {
		
		IndividualClient firstClient = new IndividualClient(1, "KL54687848OIO", "+45951862459", "Krakow", "Tomas", "Andersen",
				"12/22/1996", "Warsaw", "Polish", 7000.00);
		IndividualClientsAccount account1 = new IndividualClientsAccount("PL00000000000000000000000001", "current", true, 900.54f, "USD", new Branch(), firstClient);
		firstClient.setAccount(account1);
		
		
		IndividualClient secondClient = new IndividualClient(2, "1549874651354", "+45789258654", "Krakow", "Anna", "Andersen",
				"07/14/1999", "Warsaw", "Polish", 600.00);
		IndividualClientsAccount account2 = new IndividualClientsAccount("PL00000000000000000000000002", "current", true, 8400.54f, "EUR", new Branch(), secondClient);
		secondClient.setAccount(account2);
		
	
		System.out.println(firstClient.equals(secondClient));
		System.out.println(firstClient.hashCode());
		System.out.println(secondClient.hashCode());
		System.out.println(firstClient.toString());
		System.out.println(secondClient.toString());
		
		System.out.println(account1.equals(account2));
		System.out.println(account1.hashCode());
		System.out.println(account2.hashCode());
		System.out.println(account1.toString());
		System.out.println(account2.toString());
		
		IndividualClientsCredit credit1 = new IndividualClientsCredit(10.00, 36, 80000,account1, firstClient);	
		credit1.giveCredit(firstClient, credit1);

		IndividualClientsCredit credit2 = new IndividualClientsCredit(11.50, 24, 60000,account2, secondClient);	
		credit2.giveCredit(secondClient, credit2);
		
		
		CorporateClient thirdClient = new CorporateClient(3, "123456789", "+45456951753", "Krakow", "ASB", "Tomas", "Andersen", 78.89);
		CorporateClientsAccount account3 = new CorporateClientsAccount("PL00000000000000000000000003", "current", true, 900.54f, "USD", new Branch(), thirdClient);
		thirdClient.setAccount(account3);
		
		
		CorporateClient fourthClient = new CorporateClient(4, "987654321", "+45654987321", "Krakow", "KLM", "Anna", "Andersen", 56.12);
		CorporateClientsAccount account4 = new CorporateClientsAccount("PL00000000000000000000000002", "current", true, 8400.54f, "EUR", new Branch(), fourthClient);
		fourthClient.setAccount(account4);
		
		System.out.println(thirdClient.equals(fourthClient));
		System.out.println(thirdClient.hashCode());
		System.out.println(fourthClient.hashCode());
		System.out.println(thirdClient.toString());
		System.out.println(fourthClient.toString());
		
		CorporateClientsCredit credit3 = new CorporateClientsCredit(10.00, 36, 80000, account3, thirdClient);	
		credit3.giveCredit(thirdClient, credit3);

		CorporateClientsCredit credit4 = new CorporateClientsCredit(11.50, 24, 60000, account4, fourthClient);	
		credit4.giveCredit(fourthClient, credit4);
		
		System.out.println(credit3.equals(credit4));
		System.out.println(credit3.hashCode());
		System.out.println(credit4.hashCode());
		System.out.println(credit3.toString());
		System.out.println(credit4.toString());
		
		

	}

}
