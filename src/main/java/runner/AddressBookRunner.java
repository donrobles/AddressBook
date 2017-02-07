package runner;

import addressbook.UserInfo;
import base.BaseInterface;
import com.sun.media.sound.InvalidFormatException;

import javax.naming.InvalidNameException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public class AddressBookRunner implements BaseInterface {

    private static InputParser inputParser = new InputParser();
    private static ArrayList<UserInfo> addressBook = new ArrayList<>();
    private static AddressBookSearcher searcher = new AddressBookSearcher(addressBook);

    public static void main(String[] args) {
        AddressBookRunner app = new AddressBookRunner();
        processInput(app, System.in, System.out);
    }

    private static void processInput(AddressBookRunner app, InputStream inputStream, PrintStream outputStream) {
        outputStream.print(app.createMenu());
        boolean appRunning = true;
        Scanner in = new Scanner(inputStream);
        while (appRunning) {
            String userInput; // Create a new userInput for each loop iteration.
            if (in.hasNext()) {
                try {
                    // Grab tht user input.
                    userInput = in.nextLine().trim();
                    // Quit out the application if "q" was entered.
                    if ("q".equals(userInput)) {
                        outputStream.print("The program will now exit. \n\n");
                        break; // End the loop to stop the programn.
                    }
                    // Use the Util to parse through the input.
                    inputParser.parseInput(userInput);
                    if (ADD.equalsIgnoreCase(inputParser.getCommand())) {
                        // Build the User entry using the inputParser
                        UserInfo newUserEntry = new UserInfo(inputParser.getFirstName(), inputParser.getLastName(),
                                inputParser.getPhoneNumbers(), inputParser.getEmails());

                        // Add the User to the AddressBook.
                        addressBook.add(newUserEntry);
                        // Output the successful addition to the AddressBook.
                        outputStream.print("The entry for \"" + newUserEntry.getFirstName() + "\" \"" +
                                newUserEntry.getLastName() + "\" has been added! \n\n");

                    } else if (SEARCH.equalsIgnoreCase(inputParser.getCommand())) {
                        outputStream.print(searcher.grabMatchRecords(inputParser.getFirstName()));
                    }
                } catch (InvalidFormatException | InvalidNameException | InvalidParameterException ex) {
                    outputStream.print(ex.getMessage());
                } catch (Exception ex) {
                    outputStream.print("Sorry, there was an unforeseen error with you input. Please try again. \n\n");
                }
            }
        }
        in.close();
    }

    /*
    Outputs the menu for the user to get an understanding of what the application does.
     */
    private String createMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to the UserInfo app! \n\n");
        sb.append("You can ADD user entries using the following format... \n");
        sb.append("\"add {First_Name}, {Last_Name}, {XXX-XXX-XXXX}, {...}, {email@address.domain}, {...}\" \n");
        sb.append("NOTE: You must specify a first name, last name, phone number, and email. \n\n");
        sb.append("After records have been entered, you can SEARCH for users by first OR last name... \n");
        sb.append("\"search {First_Name}\" OR \"search {Last_Name}\" \n");
        sb.append("NOTE: You can search with a last name OR a first name, not both. \n\n");
        sb.append("To quit the application, enter \"q\".\n\n");
        sb.append("You may begin submitting entries now. \n\n");
        return sb.toString();
    }
}
