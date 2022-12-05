package branches;

import java.util.ArrayList;
import clients.Client;

public interface INotifyClients {

	default void notifyAllClients(ArrayList<Client> clients, String message) {
		for (Client cl : clients) {
			String emailAddress = cl.getEmailAddress();
			System.out.println(String.format("New message for client with email:%s %n%s", emailAddress, message));
		}
	}
}
