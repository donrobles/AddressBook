package addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Don Robles on 2/3/2017 with IntelliJ IDEA.
 */
class AddressBookConn {

    private static final String DROP_TABLES =
            "DROP TABLE EMAIL_ADDRESSES, USER_INFO, PHONE_NUMBERS;";
    private static final String USER_INFO =
            "CREATE TABLE USER_INFO (USER_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL, FIRST_NAME INTEGER, LAST_NAME INTEGER);";
    private static final String EMAIL_ADDESSES =
            "CREATE TABLE EMAIL_ADDRESSES (EMAIL_ADDRESS_ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL, EMAIL_ADDRESS VARCHAR(45));";
    private static final String PHONE_NUMBERS =
            "CREATE TABLE PHONE_NUMBERS (PHONE_NUMBER_ID BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL, PHONE_NUMBER VARCHAR(12));";
    private static final String FOREIGN_KEYS =
            "ALTER TABLE PHONE_NUMBERS ADD FOREIGN KEY (PHONE_NUMBER_ID) REFERENCES USER_INFO (USER_ID);" +
                    "ALTER TABLE EMAIL_ADDRESSES ADD FOREIGN KEY (EMAIL_ADDRESS_ID) REFERENCES USER_INFO (USER_ID);";

    private Statement classSt;

    void createDB() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:", "testUser", "te$tP@ss^Or|)");
            classSt = conn.createStatement();
            classSt.execute(USER_INFO + PHONE_NUMBERS + EMAIL_ADDESSES + FOREIGN_KEYS);
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
