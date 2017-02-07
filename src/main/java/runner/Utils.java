package runner;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public class Utils {

    private static final String VALID_NAME = "^[a-zA-Z]+$";
    private static final String VALID_PHONE_NUMBER = "^\\d{3}-\\d{3}-\\d{4}$";
    private static final String WHITE_SPACE_CHAR = "\\s+";
    private static final String ADD = "ADD";
    private static final String SEARCH = "SEARCH";
    private String[] fullInput;

    boolean validateName(String userInput) {
        return userInput.matches(VALID_NAME);
    }

    protected boolean validateNumber(String userInput) {
        return userInput.matches(VALID_PHONE_NUMBER);
    }

    public void setFullInput(String fullInput) throws InvalidParameterException {
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
        this.fullInput = new String[initInputFormat.length + 1];
        this.fullInput[0] = command;
        int i = 1;
        for (String input : initInputFormat) {
            this.fullInput[i] = input.replaceAll(WHITE_SPACE_CHAR, "");
            i++;
        }
    }

    public String grabCommand() {
        return "";
    }

    public String getCommand(String userInput) {
        return "";
    }

    public ArrayList<String> getPhoneNumbersInputs(String userInput) {
        ArrayList<String> allPhoneNumbers = null;
        System.out.println(fullInput.toString());

        for (String entry : fullInput) {
            entry = entry.replaceAll(WHITE_SPACE_CHAR, "");
            if (entry.matches(VALID_PHONE_NUMBER) ? true : false) {
                if (allPhoneNumbers == null) {
                    allPhoneNumbers = new ArrayList<>();
                }
                allPhoneNumbers.add(entry);
            }
        }

        System.out.println(allPhoneNumbers.toString());
        return allPhoneNumbers;
    }
}
