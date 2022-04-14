import javax.swing.*;
import java.sql.*;

public class DatabaseConnector {
    Connection conn;

    // Should take all data as input instead
    public DatabaseConnector(EnvVar env) {

        System.out.println("a " + env.get("DATABASE_USERNAME"));

        String password = env.get("DATABASE_PASSWORD");

        try {
            // Set up connection to database
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + env.get("DATABASE_HOST") + ":" + env.get("DATABASE_PORT") + "/" + env.get("DATABASE_DATABASE") + "?" +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    env.get("DATABASE_USERNAME"), password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to log in, check your database and credentials and try again. Shutting down...");
            System.exit(0);
        }
    }

    public String getDatabaseContent() {
        String result = "";
        try {
            // Setup statement
            Statement stmt = conn.createStatement();

            // Create query and execute
            String SQLQuery = "select * from jabweo_meeps";
            ResultSet rset = stmt.executeQuery(SQLQuery);

            // Loop through the result set and convert to String
            // Need to know the table-structure
            while (rset.next()) {
                result += rset.getInt("id") + ", " +
                        rset.getString("body") + ", " +
                        rset.getString("color") + ", " +
                        rset.getDate("created_at");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Something went wrong, check your tablestructure...");
            return "Error reading result from SQL-query";
        }
        return result;
    }

    public String getTableInfo() {
        String result = "";
        try {
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM meeps");

            // Get resultset metadata
            ResultSetMetaData metadata = results.getMetaData();
            int columnCount = metadata.getColumnCount();

            // Get the column names; column indices start from 1
            for (int i=1; i<=columnCount; i++) {
                String columnName = metadata.getColumnName(i);
                result += columnName + " ";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}