package runner;

import addressbook.AddressBook;

import java.io.InputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public class AddressBookRunner implements AddressInterface {

    private static Utils util = new Utils();
    private static ArrayList<AddressBook> addressBook = new ArrayList<>();

    public static void main(String[] args) {
        AddressBookRunner app = new AddressBookRunner();
        processInput(app, System.in, System.out);
    }

    private static void processInput(AddressBookRunner app, InputStream inputStream, PrintStream outputStream) {
        outputStream.print(app.createMenu());
        boolean appRunning = true;
        Scanner in = new Scanner(inputStream);
        while (appRunning) {
            String userInput = "";
            if (in.hasNext()) {
                //Grab tht user input.
                userInput = in.nextLine().trim();
            }
            //Quit out the application if "q" was entered.
            if ("q".equals(userInput)) {
                appRunning = false;
            }
            try {
                util.setFullInput(userInput);
                //util.getPhoneNumbersInputs(userInput);
            } catch (InvalidParameterException ex) {
                outputStream.print("The command you entered was invalid, please use only ADD or SEARCH.");
            }

        }
        in.close();
    }

    private String createMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to the AddressBook app! \n\n");
        sb.append("You can ADD user entries using the following format... \n");
        sb.append("\"add {First_Name}, {Last_Name}, {XXX-XXX-XXXX}, {...}, {email@address.domain}, {...}\" \n");
        sb.append("NOTE: You must at least specify a first name AND last name. Phone numbers and emails are optional. \n\n");
        sb.append("After records have been entered, you can SEARCH for users by first OR last name... \n");
        sb.append("\"search {First_Name}\" OR \"search {Last_Name}\" \n");
        sb.append("NOTE: You can search with a last name OR a first name, not both. \n\n");
        sb.append("You may begin submitting entries now. \n\n");
        return sb.toString();
    }
}
