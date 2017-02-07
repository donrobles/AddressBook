package runner;

import addressbook.UserInfo;
import base.BaseInterface;

import java.io.InputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public class AddressBookRunner implements BaseInterface {

    private static Utils util = new Utils();
    private static ArrayList<UserInfo> addressBook = new ArrayList<>();

    public static void main(String[] args) {
        AddressBookRunner app = new AddressBookRunner();
        processInput(app, System.in, System.out);
    }

    private static void processInput(AddressBookRunner app, InputStream inputStream, PrintStream outputStream) {
        outputStream.print(app.createMenu());
        boolean appRunning = true;
        Scanner in = new Scanner(inputStream);
        while (appRunning) {
            String userInput = ""; // Create a new userInput for each loop iteration.
            if (in.hasNext()) {
                //Grab tht user input.
                userInput = in.nextLine().trim();
                //Quit out the application if "q" was entered.
                if ("q".equals(userInput)) {
                    break; // End the loop to stop the programn.
                }
            }
            try {
                util.parseInput(userInput);
                if (ADD.equalsIgnoreCase(util.getCommand())) {
                    System.out.println("Add");
                } else if (SEARCH.equalsIgnoreCase(util.getCommand())) {
                    System.out.println("Search");
                }
                //util.getPhoneNumbersInputs(userInput);
            } catch (InvalidParameterException ex) {
                outputStream.print("The command you entered was invalid, please use only ADD or SEARCH. \n\n");
            } catch (Exception ex) {
                outputStream.print("Sorry, there was an inforseen error with you input. Please try again. \n\n");
            }
        }
        in.close();
    }

    private String createMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to the UserInfo app! \n\n");
        sb.append("You can ADD user entries using the following format... \n");
        sb.append("\"add {First_Name}, {Last_Name}, {XXX-XXX-XXXX}, {...}, {email@address.domain}, {...}\" \n");
        sb.append("NOTE: You must at least specify a first name AND last name. Phone numbers and emails are optional. \n\n");
        sb.append("After records have been entered, you can SEARCH for users by first OR last name... \n");
        sb.append("\"search {First_Name}\" OR \"search {Last_Name}\" \n");
        sb.append("NOTE: You can search with a last name OR a first name, not both. \n\n");
        sb.append("To quit the application, enter \"q\".\n\n");
        sb.append("You may begin submitting entries now. \n\n");
        return sb.toString();
    }
}
