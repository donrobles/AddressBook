package runner;

/**
 * Created by Don Robles on 2/2/2017 with IntelliJ IDEA.
 */
public interface AddressInterface {
    int EXIT = -2;     // When user enters q/Q
    int RESTOCK = -1;  // When user enters r/R
    int INVALID = 0;   // Invalid user entry

    String COMMA = ",";
    String EOL = System.getProperty("line.separator");

    /* Text messages are all made into variables to ensure that messages used
     * in testing correspond to those used in the app.
     */
    String EXIT_MESG = "Exiting.";
    String INVALID_MESG = "Invalid selection: ";
    String DISPENSING_MESG = "Dispensing: ";
    String OUTOFSTOCK_MESG = "Out of stock: ";
    String INVENTORY_MESG = "Inventory:";
    String MENU_MESG = "Menu:";
}
