package addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Don Robles on 2/3/2017 with IntelliJ IDEA.
 */
class AddressBookConn {

    private Statement classSt;

    void createDB() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:", "testUser", "te$tP@ss^Or|)");
            classSt = conn.createStatement();
            classSt.execute("CREATE TABLE pawn(NAME VARCHAR (20))");
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
