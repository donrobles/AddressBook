package addressbook;

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

    public String grabMatchRecords(String nameInput) {
        StringBuilder sb = new StringBuilder();
        sb.append("Your search for criteria were... \n");
        sb.append("Name Entry: ").append(nameInput).append("\n");
        sb.append("These were the records found...\n");
        for (UserInfo entry : this.addressBook) {
            if (nameInput.equalsIgnoreCase(entry.getFirstName())) {
                grabAllUserInfo(sb, entry);
            } else if (nameInput.equalsIgnoreCase(entry.getLastName())) {
                grabAllUserInfo(sb, entry);
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    private void grabAllUserInfo(StringBuilder sb, UserInfo entry) {
        sb.append(entry.getFirstName()).append(" ").append(entry.getLastName()).append(" ");
        for (String phoneNumber : entry.getPhoneNumbers()) {
            sb.append(phoneNumber).append(" ");
        }
        for (String email : entry.getEmailAddresses()) {
            sb.append(email).append(" ");
        }
        sb.append("\n");
    }
}
