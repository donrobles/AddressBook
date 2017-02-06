package runner;

import java.util.ArrayList;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public class Utils {

    private static final String VALID_NAME = "^[a-zA-Z]+$";
    private static final String VALID_PHONE_NUMBER = "^\\d{3}-\\d{3}-\\d{4}$";
    private static final String REMOVE_WHITE_SPACE = "\\s+";

    boolean validateName(String userInput) {
        return userInput.matches(VALID_NAME);
    }

    protected boolean validateNumber(String userInput) {
        return userInput.matches(VALID_PHONE_NUMBER);
    }
    
    public ArrayList<String> getPhoneNumbersInputs(String userInput) {
        String[] allInputs = userInput.split(",");
        ArrayList<String> allPhoneNumbers = null;
        System.out.println(allInputs.toString());

        for (String entry : allInputs) {
            entry = entry.replaceAll(REMOVE_WHITE_SPACE, "");
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
