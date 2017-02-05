package addressbook;

/**
 * Created by Don Robles on 2/4/2017 with IntelliJ IDEA.
 */
public class PhoneNumber {
    private String phoneNumber = "";

    PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
