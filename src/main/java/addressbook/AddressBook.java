package addressbook;

import java.util.ArrayList;

/**
 * Created by Don Robles on 2/4/2017 with IntelliJ IDEA.
 */
public class AddressBook {

    private String firstName = "", lastName = "";
    private ArrayList<String> phoneNumbers = new ArrayList<>();
    private ArrayList<String> emailAddresses = new ArrayList<>();

    AddressBook(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        phoneNumbers.add(phoneNumber);
        emailAddresses.add(emailAddress);
    }

    AddressBook(String firstName, String lastName, ArrayList<String> phoneNumbers, ArrayList<String> emailAddresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.emailAddresses = emailAddresses;
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

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public ArrayList<String> getEmailAddresses() {
        return emailAddresses;
    }
}
