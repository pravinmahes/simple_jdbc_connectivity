package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MODEL.delete;
import connectionmanager.Connectionmanager;

public class deleteDAO {
	public void deleteproduct (delete d) throws ClassNotFoundException, SQLException {
		int dID = d.getID();
		Connectionmanager conm = new Connectionmanager();
		Connection con = conm.establishConnection();
		String deletion = "DELETE FROM product WHERE ID = ?";
		PreparedStatement ps = con.prepareStatement(deletion);
		ps.setInt(1,dID);
		ps.executeUpdate();
		conm.closeConnection();
	}
	public void display() throws ClassNotFoundException, SQLException
	{
		Connectionmanager conm = new Connectionmanager();
		Connection con = conm.establishConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from product");
		while (rs.next())
		{
			System.out.println(rs.getInt("ID")+"|"+rs.getString("name")+ "|"+rs.getInt("sellquantity")+"|"+rs.getFloat("price")+"|"+rs.getInt("quantity"));
		}
	}
	}
