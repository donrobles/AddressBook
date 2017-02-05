package addressbook;

/**
 * Created by Don Robles on 2/4/2017 with IntelliJ IDEA.
 */
public class UserInfo {
    private String firstName = "";
    private String lastName = "";

    UserInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
