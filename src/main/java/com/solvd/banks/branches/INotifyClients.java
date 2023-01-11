package main.java.com.solvd.banks.branches;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.banks.clients.Client;

public interface INotifyClients {

    public final static Logger logger = LogManager.getLogger(INotifyClients.class);
    default void notifyAllClients(ArrayList<Client> clients, String nameOfMessageFile) {
      for (Client cl : clients) {
        String emailAddress = cl.getEmailAddress();
        try (BufferedReader reader = new BufferedReader(new FileReader("" + nameOfMessageFile + ".txt"));
            BufferedWriter writer = new BufferedWriter(
                new FileWriter("message sent to " + emailAddress + ".txt"));) {
          String line;
          while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.write('\n');
          }
        } catch (FileNotFoundException e) {
          logger.warn(String.format("Message template not found while sending message to %s, message wasn't sent", cl.getEmailAddress()), e);
        } catch (IOException e) {
          logger.warn(e);
        }
        System.out.println(String.format("New message for client with email:%s", emailAddress));
      }
    }
}
