package database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Joud
 */
public class DataBaseConnection {

    // data base connection details 
    private static final String db_url = "jdbc:oracle:thin:@192.168.100.18:1521:xe";
    private static final String db_user = "system";
    private static final String db_pass = "1234";

    public  Connection getCon() {
        return con;
    }

    // singleton instance and connection
    private static DataBaseConnection handler = null; // هل يوجد كونيكشن من قبل ؟
    public  Connection con = null;
    private Statement stmt = null;

    private DataBaseConnection() {
        createConnection();
    }

    // method to get the singleton instance of databaseConnection
    public static DataBaseConnection getInstance() throws SQLException {
        if (handler == null || handler.con.isClosed()) {// create new instance
            handler = new DataBaseConnection();
        }
        System.out.println("");
        return handler;
    }

    public void createConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // load the oracle JDBC driver
            con = DriverManager.getConnection(db_url, db_user, db_pass); // 
            System.out.println("Connection established!");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver Class not found: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Exception " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Exception " + e.getMessage());
            e.printStackTrace();
        }
    }
}
