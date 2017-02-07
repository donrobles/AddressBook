package addressbook;

import base.BaseInterface;
import com.sun.media.sound.InvalidFormatException;

import javax.naming.InvalidNameException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public class InputParser implements BaseInterface {

    private static final String VALID_NAME = "^[a-zA-Z\\d]+$";
    private static final String VALID_PHONE_NUMBER = "^\\d{3}-\\d{3}-\\d{4}$";
    private static final String VALID_EMAIL = "[\\w-]+@([\\w-]+\\.)+[\\w-]+";
    private static final String WHITE_SPACE_CHAR = "\\s+";
    private static final String EMPTY_STRING = "";
    private static final String COMMA = ",";
    private ArrayList<String> phoneNumbers, emailsAddresses;
    private String command, firstName, lastName;

    public void parseInput(String fullInput) throws InvalidParameterException, InvalidFormatException, InvalidNameException {
        //Reset the outputs each time a new input is given.
        resetOutputs();
        // Check if the command given was ADD or SEARCH, and remove that part from the String.
        if (fullInput.substring(0, 3).equalsIgnoreCase(ADD)) {
            this.command = ADD;
            fullInput = fullInput.length() >= 4 ? fullInput.substring(4, fullInput.length()) : "";
        } else if (fullInput.substring(0, 6).equalsIgnoreCase(SEARCH)) {
            this.command = SEARCH;
            fullInput = fullInput.length() >= 7 ? fullInput.substring(7, fullInput.length()) : "";
        } else
            throw new InvalidParameterException("The command you entered was invalid, please use only ADD or SEARCH. \n\n");

        if (ADD.equalsIgnoreCase(this.command)) {
            handleAddCommandInput(fullInput);
        } else if (SEARCH.equalsIgnoreCase(this.command)) {
            setFirstAndLastNames(fullInput);
        }
    }

    private void resetOutputs() {
        this.command = "";
        this.firstName = "";
        this.lastName = "";
        this.phoneNumbers = new ArrayList<>();
        this.emailsAddresses = new ArrayList<>();
    }

    private boolean validateName(String name) {
        return name.matches(VALID_NAME);
    }

    private String removeWhiteSpace(String input) {
        return input.replaceAll(WHITE_SPACE_CHAR, EMPTY_STRING);
    }

    private void handleAddCommandInput(String fullInput) throws InvalidFormatException, InvalidNameException {
        //There should still be something in the String after the given command.
        if (fullInput.length() > 0) {
            //Set the first and last name class variables.
            String[] initInputFormat = setFirstAndLastNames(fullInput);
            int inputArrayLength = initInputFormat.length;

            // Keep track of where we are in the array, to avoid unneeded reads.
            int loopPosition = 1;
            // Grab the phone numbers, which should begin at index 3, or StringArray[2];
            for (int i = 2; i < inputArrayLength; i++) {
                String entry = removeWhiteSpace(initInputFormat[i]);
                if (entry.matches(VALID_PHONE_NUMBER)) {
                    phoneNumbers.add(entry);
                    loopPosition++;
                } else {
                    loopPosition++;
                    break;
                }
            }
            // Now grab the remaining entries, which should be email addresses.
            for (; loopPosition < inputArrayLength; loopPosition++) {
                String entry = removeWhiteSpace(initInputFormat[loopPosition]);
                if (entry.matches(VALID_EMAIL)) {
                    emailsAddresses.add(entry);
                } else
                    throw new InvalidFormatException("The entry \"" + entry + "\" wasn't a valid email. \n\n");
            }
        } else
            throw new InvalidFormatException("Please include at least a \"first_name, last_name\" in you ADD or SEARCH command. \n\n");
    }

    private String[] setFirstAndLastNames(String fullInput) throws InvalidFormatException, InvalidNameException {
        // Split the remaining inputs
        String[] initInputFormat = fullInput.split(COMMA);
        int inputArrayLength = initInputFormat.length;
        //Check if the array has entries
        if (inputArrayLength > 0) {
            // Validate/Set the first name entry.
            String firstName = removeWhiteSpace(initInputFormat[0]);
            if (validateName(firstName)) {
                this.firstName = firstName;
            } else {
                throw new InvalidFormatException("The first name \"" + firstName + "\" isn't a valid first name. No special characters. \n\n");
            }

            // Check if there's a last name entry.
            if (inputArrayLength > 1) {
                // Validate/Set the last name entry.
                String lastName = removeWhiteSpace(initInputFormat[1]);
                if (validateName(lastName)) {
                    this.lastName = lastName;
                } else {
                    throw new InvalidFormatException("The last name \"" + lastName + "\" isn't a valid last name. No special characters. \n\n");
                }
            }
        } else {
            throw new InvalidNameException("You didn't provide a first name or last name. \n\n");
        }
        return initInputFormat;
    }

    public String getCommand() {
        return command;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public ArrayList<String> getEmails() {
        return emailsAddresses;
    }
}
