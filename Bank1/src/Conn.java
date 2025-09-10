import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Conn {	
	Connection c;
	Statement s;
	public Conn() {
		System.out.println(System.getProperty("java.class.path"));

		try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to database
            c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankmanagementsystem",
                "root",
                "dps"
            );
            System.out.println("Connected to mysql");

            // Create statement
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
	}
	
}
