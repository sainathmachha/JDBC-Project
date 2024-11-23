import java.sql.Connection;
import java.sql.*;

public class MysqlConnection {

    static Connection connection;

    public static Connection createConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sms";
            String username = "root";
            String password = "Sainath1811@mysqL";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
