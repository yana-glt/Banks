package main.java.com.solvd.banks;

import main.java.com.solvd.banks.exception_handlers.FileIsEmptyException;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    private final static Logger logger = LogManager.getLogger(FileUtils.class);

    public static void readFromFile(String fileName) {
        try {
            File dir = new File(fileName);
            if (!dir.exists()) {
                throw new FileNotFoundException(String.format("The file or directory %s does not exist.", dir.getName()));
            }
            List<File> files = (List<File>) org.apache.commons.io.FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
            if (files.isEmpty()) {
                throw new FileIsEmptyException("File or directory is empty", dir.getName());
            }
            for (File file : files) {
                List<String> lines = org.apache.commons.io.FileUtils.readLines(file, StandardCharsets.UTF_8);
                int numberOfBranches = 0;
                int numberOfDepartments = 0;
                int numberOfEmployees = 0;
                int numberOfClients = 0;
                int numberOfCredits = 0;
                int numberOfCards = 0;
                for (String str : lines) {
                    if (StringUtils.startsWith(str, "Branch")) {
                        numberOfBranches++;
                    }
                    if (StringUtils.startsWith(str, "Department")) {
                        numberOfDepartments++;
                    }
                    if (StringUtils.startsWith(str, "Employee")) {
                        numberOfEmployees++;
                    }
                    if (StringUtils.startsWith(str, "Client")) {
                        numberOfClients++;
                    }
                    if (StringUtils.startsWith(str, "Credit")) {
                        numberOfCredits++;
                    }
                    if (StringUtils.startsWith(str, "Card")) {
                        numberOfCards++;
                    }
                }
                System.out.println(String.format("The last time the program was launched, %s branches, %s departments, %s employees, %s clients, %s credits, %s cards were created",
                        numberOfBranches, numberOfDepartments, numberOfEmployees, numberOfClients, numberOfCredits, numberOfCards));
            }
        } catch (FileIsEmptyException e) {
            logger.error((String.format("File or directory %s is empty", e.getFileOrDirectoryName())), e);
        } catch (IOException e) {
            logger.error(String.format("Failed to read information"), e);
        }
    }

    public static void readFromFile() {
        try {
            File dir = new File("info.txt");
            if (!dir.exists()) {
                throw new FileNotFoundException(String.format("The file or directory %s does not exist.", dir.getName()));
            }
            List<File> files = (List<File>) org.apache.commons.io.FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
            if (files.isEmpty()) {
                throw new FileIsEmptyException("File or directory is empty", dir.getName());
            }
            for (File file : files) {
                List<String> lines = org.apache.commons.io.FileUtils.readLines(file, StandardCharsets.UTF_8);
                int numberOfBranches = 0;
                int numberOfDepartments = 0;
                int numberOfEmployees = 0;
                int numberOfClients = 0;
                int numberOfCredits = 0;
                int numberOfCards = 0;
                for (String str : lines) {
                    if (StringUtils.startsWith(str, "Branch")) {
                        numberOfBranches++;
                    }
                    if (StringUtils.startsWith(str, "Department")) {
                        numberOfDepartments++;
                    }
                    if (StringUtils.startsWith(str, "Employee")) {
                        numberOfEmployees++;
                    }
                    if (StringUtils.startsWith(str, "Client")) {
                        numberOfClients++;
                    }
                    if (StringUtils.startsWith(str, "Credit")) {
                        numberOfCredits++;
                    }
                    if (StringUtils.startsWith(str, "Card")) {
                        numberOfCards++;
                    }
                }
                System.out.println(String.format("The last time the program was launched, %s branches, %s departments, %s employees, %s clients, %s credits, %s cards were created",
                        numberOfBranches, numberOfDepartments, numberOfEmployees, numberOfClients, numberOfCredits, numberOfCards));
            }
        } catch (FileIsEmptyException e) {
            logger.error((String.format("File or directory %s is empty", e.getFileOrDirectoryName())), e);
        } catch (IOException e) {
            logger.error(String.format("Failed to read information"), e);
        }
    }

    public static void readUsingFileUtils() {
        try (Scanner scanner = new Scanner(System.in)) {
            String s = null;
            System.out.println("Enter the path to the file or directory to read");
            s = scanner.nextLine();
            try {
                File dir = new File(s);
                if (!dir.exists()) {
                    throw new FileNotFoundException(String.format("The file or directory %s does not exist.", dir.getName()));
                }
                List<File> files = (List<File>) org.apache.commons.io.FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
                if (files.isEmpty()) {
                    throw new FileIsEmptyException("File or directory is empty", dir.getName());
                }
                for (File file : files) {
                    List<String> lines = org.apache.commons.io.FileUtils.readLines(file, StandardCharsets.UTF_8);
                    lines.forEach(System.out::println);
                }
            } catch (FileIsEmptyException e) {
                logger.error((String.format("File or directory %s is empty", e.getFileOrDirectoryName())), e);
            } catch (IOException e) {
                logger.error(String.format("Failed to read information"), e);
            }
        }
    }

    public static void writeUsingFileUtils(Collection<?> lines) {
        final File file = new File("info.txt");
        try {
            org.apache.commons.io.FileUtils.writeLines(file, null, lines, true);
        } catch (IOException e) {
            logger.error(String.format("Failed to write information about the current state of the created objects to the file %s",
                    file.getName()), e);
        }
    }
}
