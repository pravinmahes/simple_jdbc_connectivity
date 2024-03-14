package controller;

import java.sql.SQLException;
import java.util.Scanner;

import MODEL.delete;
import MODEL.login;
import MODEL.product;
import DAO.deleteDAO;
import DAO.loginDAO;
import DAO.productDAO;
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		login l = new login();
		loginDAO ldao = new loginDAO();
		product p = new product();
		productDAO pdao = new productDAO();
		delete d = new delete();
		deleteDAO dDAO = new deleteDAO();
		outerloop:
		while (true) {
		System.out.println("************************************************************************************************");
		System.out.println("Enter your choice");
		System.out.println("1.ADMIN");
		System.out.println("2.USER");
		System.out.println("3.EXIT");
		System.out.println("************************************************************************************************");
		Scanner sc = new Scanner (System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1) {
			System.out.println("Enter Your ADMIN Username and Password");
			String entered_admin_username = sc.next();
			l.setUsername(entered_admin_username);
			String entered_admin_password = sc.next();
			l.setPass(entered_admin_password);
			if (ldao.loginValidation(l))
			{
				System.out.println("You have Successfully Entered");
				System.out.println("Enter your choice");
				System.out.println("1.ADD PRODUCT");
				System.out.println("2.DISPLAY PRODUCT");
				System.out.println ("3.Delete product");
				System.out.println("4.LOGOUT");
				int choice1 = sc.nextInt();
				if (choice1 == 1) {
					System.out.println("Enter the Product ID");
					int ID = sc.nextInt();
					System.out.println("Enter the Product Name");
					sc.nextLine();
					String name = sc.next();
					System.out.println("Enter the Minimum sell quantity");
					int sellquantity = sc.nextInt();
					System.out.println("Enter the price");
					float price = sc.nextFloat();
					System.out.println("Enter the Quantity");
					int quantity = sc.nextInt();
					p.setID(ID);
					p.setName(name);
					p.setSellquantity(sellquantity);
					p.setPrice(price);
					p.setQuantity(quantity);
					pdao.addproduct(p);
					System.out.println("Your product added  successfully");
				}else if (choice1 == 2) {
					System.out.println("Product details are below");
					pdao.display();
				}else if (choice1 == 3){
					System.out.println("Choose the product ID to delete");
					int dID = sc.nextInt();
					d.setID(dID);
					dDAO.deleteproduct(d);
					System.out.println("Updated List");
					dDAO.display();
				}
				else {
					continue outerloop;
				}
			}else {
				System.out.println("Wrong Password or Username");
			}
		}else if (choice == 2) {
			System.out.println("Enter your User LoginId and Password");
			String entered_username = sc.next();
			l.setUsername(entered_username);
			String entered_user_password = sc.next();
			l.setPass(entered_user_password);
			if (ldao.loginValidation(l)) {
				System.out.println("You have Successfully Entered");
				System.out.println("Enter your choice");
				System.out.println("1.DISPLAY PRODUCT");
				System.out.println("2.LOGOUT");
				int choice2 = sc.nextInt();
				if (choice2 == 1) {
					System.out.println("Product details are below");
					pdao.display();
				}else if(choice2 == 2) {
					continue outerloop;
				}
			}else {
				System.out.println("Wrong Password or Username");
			}
		}else {
		
		sc.close();
		}
		}
		}

}
