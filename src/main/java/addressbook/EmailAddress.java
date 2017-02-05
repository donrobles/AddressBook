package addressbook;

/**
 * Created by Don Robles on 2/4/2017 with IntelliJ IDEA.
 */
public class EmailAddress {
    private String emailAddres = "";

    EmailAddress(String emailAddres) {
        this.emailAddres = emailAddres;
    }

    public String getEmailAddres() {
        return emailAddres;
    }

    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
    }
}
