package connectionmanager;
import java.sql.*;
public class Connectionmanager {
	Connection con = null;
	public Connection establishConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName ("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryDB1","pravinmahes","Pm@16022004");
		return con;
	}
	public void closeConnection() throws SQLException
	{
		con.close();
	}
}