package runner;

import addressbook.UserInfo;

import java.util.ArrayList;

/**
 * Created by Don Robles on 2/7/2017 with IntelliJ IDEA.
 */
public class AddressBookSearcher {

    private final ArrayList<UserInfo> addressBook;

    public AddressBookSearcher(ArrayList<UserInfo> addresBook) {
        this.addressBook = addresBook;
    }

    public ArrayList<String> searchAddressBook(String firstName, String lastName) {

        return null;
    }

    public void returnABInfo() {
        for (UserInfo entry : this.addressBook) {
            String userPhoneNumbers = "";
            for (String phoneNumber : entry.getPhoneNumbers()) {
                userPhoneNumbers += "[" + phoneNumber + "] ";
            }

            String userEmails = "";
            for (String email : entry.getEmailAddresses()) {
                userEmails += "[" + email + "] ";
            }
            System.out.println("Address book contains: " + entry.getFirstName() + " " + entry.getLastName() + " " +
                    userPhoneNumbers + " " + userEmails);
        }
    }
}
