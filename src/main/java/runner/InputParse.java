package runner;

import base.BaseInterface;
import com.sun.media.sound.InvalidFormatException;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public class InputParse implements BaseInterface {

    private static final String VALID_NAME = "^[a-zA-Z]+$";
    private static final String VALID_PHONE_NUMBER = "^\\d{3}-\\d{3}-\\d{4}$";
    private static final String VALID_EMAIL = "[\\w-]+@([\\w-]+\\.)+[\\w-]+";
    private static final String WHITE_SPACE_CHAR = "\\s+";
    private String[] parsedInput;
    private ArrayList<String> phoneNumbers = new ArrayList<>(), emailsAddresses = new ArrayList<>();
    private String command, firstName, lastName;


    boolean validateName(String userInput) {
        return userInput.matches(VALID_NAME);
    }

    protected boolean validateNumber(String userInput) {
        return userInput.matches(VALID_PHONE_NUMBER);
    }


    public void parseInput(String fullInput) throws InvalidParameterException, InvalidFormatException {
        // Check if the command given was ADD or SEARCH, and remove that part from the String.
        if (fullInput.substring(0, 3).equalsIgnoreCase(ADD)) {
            this.command = ADD;
            fullInput = fullInput.length() >= 4 ? fullInput.substring(4, fullInput.length()) : "";
        } else if (fullInput.substring(0, 6).equalsIgnoreCase(SEARCH)) {
            this.command = SEARCH;
            fullInput = fullInput.length() >= 7 ? fullInput.substring(7, fullInput.length()) : "";
        } else
            throw new InvalidParameterException("The command you entered was invalid, please use only ADD or SEARCH. \n\n");

        //There should still be something in the String after the given command.
        if (fullInput.length() > 0) {
            // Split the remaining inputs
            String[] initInputFormat = fullInput.split(COMMA);
            firstName = removeWhiteSpace(initInputFormat[0]);
            lastName = removeWhiteSpace(initInputFormat[1]);
            //TODO: Simplify the whole class by setting firstName, lastName, phoneNumbers, and emailAddresses Lists here.
            int loopPosition = 1; // Keep track of where we are in the array, to avoid unneeded reads.
            // Grab the phone numbers, which should begin at index 3, or StringArray[2];
            for (int i = 2; i < initInputFormat.length; i++) {
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
            for (; loopPosition < initInputFormat.length; loopPosition++) {
                String entry = removeWhiteSpace(initInputFormat[loopPosition]);
                if (entry.matches(VALID_EMAIL)) {
                    emailsAddresses.add(entry);
                }
            }
        } else
            throw new InvalidFormatException("Please include at least a \"first_name, last_name\" in you ADD or SEARCH command. \n\n");
    }

    private String removeWhiteSpace(String input) {
        return input.replaceAll(WHITE_SPACE_CHAR, EMPTY_STRING);
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
