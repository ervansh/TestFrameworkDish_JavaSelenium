package in.dishtv.library;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Reporter;

public class DatabaseConnection {
	java.sql.Connection con = null;
	java.sql.Statement stmt = null;
	
	String hostName;
	String databaseName;
	String userID;
	String password;

	public DatabaseConnection(String hostName, String userID, String password, String databasename) {
		this.hostName = hostName;
		this.userID = userID;
		this.password = password;
		this.databaseName=databasename;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://" + hostName + ";" + "DatabaseName=" + databasename;
			con = DriverManager.getConnection(url, userID, password);
			stmt = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			Reporter.log(e.getMessage(), true);
		}
	}

	public ResultSet executeQuery(String query) {
		ResultSet result = null;
		try {
			result = stmt.executeQuery(query);
			return result;
		} catch (SQLException e) {
			Reporter.log(e.getMessage(), true);
			return result;
		} 
	}
}
