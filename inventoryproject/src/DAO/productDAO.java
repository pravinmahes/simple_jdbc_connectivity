package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MODEL.product;
import connectionmanager.Connectionmanager;

public class productDAO {
	public void addproduct (product p) throws ClassNotFoundException, SQLException {
		int ID = p.getID();
		String name = p.getName();
		int sellquantity=p.getSellquantity();
		float price = p.getPrice();
		int quantity = p.getQuantity();
		Connectionmanager conm = new Connectionmanager();
		Connection con = conm.establishConnection();
		String query = "insert into product values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,ID);
		ps.setString(2, name);
		ps.setInt(3, sellquantity);
		ps.setFloat(4, price);
		ps.setInt(5, quantity);
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
