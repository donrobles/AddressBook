package runner;

import java.sql.*;

/**
 * Created by Don Robles on 2/3/2017 with IntelliJ IDEA.
 */
class H2DB implements H2DBInterface {


    private Statement classSt;

    void createDB() {
        try {
            // TODO: Change the connection URL from "jdbc:h2:~/runner" to "jdbc:h2:mem:" when app is complete.
            // Get a connection to an in-memory H2 DB that exists only for the duration of tha application.
            Connection conn = DriverManager.getConnection("jdbc:h2:~/runner", "testUser", "te$tP@ss^Or|)");
            classSt = conn.createStatement();
            // TODO: Removed the DROP_TABLE SQL statement when switching the H2 DB from an embedded to in-memory DB.
            classSt.execute(DROP_TABLES);
            classSt.execute(USER_INFO);
            classSt.execute(EMAIL_ADDESSES);
            classSt.execute(PHONE_NUMBERS);

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
