package addressbook;

/**
 * Created by Don Robles on 2/4/2017 with IntelliJ IDEA.
 */
public class AddressBook {

    private UserInfo userInfo;
    private PhoneNumber phoneNumber;
    private EmailAddress emailAddress;

    AddressBook(UserInfo userInfo, PhoneNumber phoneNumber, EmailAddress emailAddress) {
        this.userInfo = userInfo;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

}
