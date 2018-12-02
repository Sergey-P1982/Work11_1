import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class MyConnector {
    Connection dbCon;
    Statement stmt;
    ResourceBundle resource =
            ResourceBundle.getBundle("property.database");
    String url = resource.getString("url");
    String user = resource.getString("user");
    String pass = resource.getString("password");

    MyConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbCon = DriverManager.getConnection(url, user, pass);
            stmt = dbCon.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void closeConnection() throws SQLException {
        dbCon.close();
    }

    public void closeStatement(Statement statement) throws SQLException {
        stmt.close();
    }
}


