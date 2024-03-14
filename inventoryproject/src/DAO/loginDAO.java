package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MODEL.login;
import connectionmanager.Connectionmanager;
public class loginDAO {
	public boolean  loginValidation(login l) throws ClassNotFoundException, SQLException 
	{
		String username = l.getUsername();
		String password = l.getpass();
		Connectionmanager conm = new Connectionmanager();
		Connection con = conm.establishConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from login");
		while (rs.next())
		{
			if (username.equals(rs.getString("username")) && password.equals(rs.getString("pass"))) {
				conm.closeConnection();
				return true;
			}
		}
		conm.closeConnection();
		return false;
	}

}
  