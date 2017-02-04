package addressbook;

import java.sql.*;

/**
 * Created by Don Robles on 2/3/2017 with IntelliJ IDEA.
 */
class AddressBookConn {

    private static final String DROP_TABLES =
            "DROP TABLE IF EXISTS EMAIL_ADDRESSES, USER_INFO, PHONE_NUMBERS;";
    private static final String USER_INFO =
            "CREATE TABLE USER_INFO (USER_ID INTEGER AUTO_INCREMENT PRIMARY KEY, FIRST_NAME VARCHAR(45), LAST_NAME VARCHAR(45));";
    private static final String EMAIL_ADDESSES =
            "CREATE TABLE EMAIL_ADDRESSES (EMAIL_ADDRESS_ID INTEGER AUTO_INCREMENT PRIMARY KEY, EMAIL_ADDRESS VARCHAR(45));";
    private static final String PHONE_NUMBERS =
            "CREATE TABLE PHONE_NUMBERS (PHONE_NUMBER_ID INTEGER AUTO_INCREMENT PRIMARY KEY, PHONE_NUMBER VARCHAR(12));";
    private static final String FOREIGN_KEYS =
            "ALTER TABLE PHONE_NUMBERS ADD FOREIGN KEY (PHONE_NUMBER_ID) REFERENCES USER_INFO (USER_ID);" +
                    "ALTER TABLE EMAIL_ADDRESSES ADD FOREIGN KEY (EMAIL_ADDRESS_ID) REFERENCES USER_INFO (USER_ID);";

    private Statement classSt;

    void createDB() {
        try {
            // TODO: Change the connection URL from "jdbc:h2:~/addressbook" to "jdbc:h2:mem:" when app is complete.
            // Get a connection to an in-memory H2 DB that exists only for the duration of tha application.
            Connection conn = DriverManager.getConnection("jdbc:h2:~/addressbook", "testUser", "te$tP@ss^Or|)");
            classSt = conn.createStatement();
            // TODO: Removed the DROP_TABLE SQL statement when switching the H2 DB from an embedded to in-memory DB.
            classSt.execute(DROP_TABLES);
            classSt.execute(USER_INFO);
            classSt.execute(EMAIL_ADDESSES);
            classSt.execute(PHONE_NUMBERS);
            classSt.execute(FOREIGN_KEYS);

            classSt.execute("CREATE ALIAS IF NOT EXISTS getVersion FOR \"org.h2.engine.Constants.getVersion\"");
            ResultSet rs;
            rs = classSt.executeQuery("CALL getVersion()");
            if (rs.next()) System.out.println("Version: " + rs.getString(1));
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
