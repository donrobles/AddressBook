package runner;

import base.BaseInterface;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public class Utils implements BaseInterface {

    private static final String VALID_NAME = "^[a-zA-Z]+$";
    private static final String VALID_PHONE_NUMBER = "^\\d{3}-\\d{3}-\\d{4}$";
    private static final String VALID_EMAIL = "[\\w-]+@([\\w-]+\\.)+[\\w-]+";
    private static final String WHITE_SPACE_CHAR = "\\s+";
    private String[] parsedInput;

    boolean validateName(String userInput) {
        return userInput.matches(VALID_NAME);
    }

    protected boolean validateNumber(String userInput) {
        return userInput.matches(VALID_PHONE_NUMBER);
    }


    public void parseInput(String fullInput) throws InvalidParameterException {
        String command = "";
        // Check if the command given was ADD or SERACH, and remove that part from the String.
        if (fullInput.substring(0, 3).equalsIgnoreCase(ADD)) {
            command = ADD;
            fullInput = fullInput.substring(4, fullInput.length());
        } else if (fullInput.substring(0, 6).equalsIgnoreCase(SEARCH)) {
            command = SEARCH;
            fullInput = fullInput.substring(7, fullInput.length());
        } else {
            throw new InvalidParameterException("The command given wasn't ADD or SEARCH.");
        }

        String[] initInputFormat = fullInput.split(",");
        this.parsedInput = new String[initInputFormat.length + 1];
        this.parsedInput[0] = command;
        int i = 1;
        for (String input : initInputFormat) {
            this.parsedInput[i] = input.replaceAll(WHITE_SPACE_CHAR, "");
            i++;
        }
    }

    public String getCommand() {
        return parsedInput[0];
    }

    public String getFirstName() {
        return parsedInput[1];
    }

    public String getLastName() {
        return parsedInput[2];
    }

    public ArrayList<String> getPhoneNumbers() {
        ArrayList<String> allPhoneNumbers = new ArrayList<>();

        int i = 0;
        for (String entry : this.parsedInput) {
            //Skip the first three entries. They're COMMAND, FIRST NAME, and LAST NAME.`
            if (i == 0 || i == 1 || i == 2) {
                i++;
                continue;
            }
            if (entry.matches(VALID_PHONE_NUMBER)) {
                allPhoneNumbers.add(entry);
            } else {
                //Once there are no more numbers, end the loop.
                break;
            }
        }

        System.out.println(allPhoneNumbers.toString());
        return allPhoneNumbers;
    }

    public ArrayList<String> getEmails() {
        ArrayList<String> allEmails = new ArrayList<>();

        //Iterate through the array in reverse since emails will be at the end.
        for (int i = this.parsedInput.length - 1; i > 0; i--) {
            if (this.parsedInput[i].matches(VALID_EMAIL)) {
                allEmails.add(this.parsedInput[i]);
            } else {
                //Once there are no more emails, end the loop.
                break;
            }
        }
        System.out.println(allEmails.toString());
        return allEmails;
    }
}
