package gncompt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



/*
 *
 * @author 1BestCsharp
 */
/
public class connexion {
	 static Connection conn;
	  public static Connection getMySqlConnection() throws Exception {
		    String driver = "com.mysql.jdbc.Driver";
		    String url = "jdbc:mysql://localhost:3306/ComptClient?useSSL=false";
		    String username = "root";
		    String password = " ";
          //telecharger pilote
		    Class.forName(driver);
			//start connection
		    Connection conn = DriverManager.getConnection(url, username, password);
		    return conn;
		  }
	