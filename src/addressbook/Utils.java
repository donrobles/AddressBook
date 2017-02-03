package addressbook;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public class Utils {

    private static final String VALID_NAME = "^[a-zA-Z]+$";
    private static final String VALID_PHONE_NUMBER = "^[0-9]*$";

    boolean validateName(String userInput) {
        return userInput.matches(VALID_NAME);
    }

    protected boolean validateNumber(String userInput) {
        return userInput.matches(VALID_PHONE_NUMBER);
    }
}
