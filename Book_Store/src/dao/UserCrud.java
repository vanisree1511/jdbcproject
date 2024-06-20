package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCrud {
	public void createTable() throws Exception { // optional can create directly in the data base//
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/book_store?createDatabaseIfNotExist=true", "root", "root");
		Statement statement = connection.createStatement();
		statement.execute("create table customer(id int primary key,name varchar(45),walletamt double)");
		statement.close();
	}

	public void details(int id, String name, double walletamt) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/book_store?user=root&password=root");
		PreparedStatement ps = connection.prepareStatement("insert into customer values(?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setDouble(3, walletamt);
		ps.execute();
		ps.close();
	}

	public void buy() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/book_store?user=root&password=root");
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery("select * from book");
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " 	" + rs.getString("name") + "  " + rs.getDouble("price"));

		}
		s.close();

	}

	public void user(int choice, double wltamt, int c_id) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/book_store?user=root&password=root";

		Connection connection = DriverManager.getConnection(url);
		Statement s = connection.createStatement(); 

			ResultSet rsCustomer = s.executeQuery("SELECT * FROM customer WHERE id = " + c_id);

			if (rsCustomer.next()) {

				ResultSet rsBook = s.executeQuery("SELECT * FROM book WHERE id = " + choice);

				if (rsBook.next()) {
					double bookPrice = rsBook.getDouble("price");

					if (wltamt >= bookPrice) {
						double balance = wltamt - bookPrice;

						s.executeUpdate("UPDATE customer SET walletamt = " + balance + " WHERE id = " + c_id);
						System.out.println("BALANCE AFTER PURCHASE ="+balance);
						System.out.println("PURCHASE SUCCESSFUL");
					} else {
						System.out.println("INSUFFICIENT BALANCE TO PURCHASE THE BOOK");
					}
				} else {
					System.out.println("Invalid book choice. Book not found.");
				}

				rsBook.close();
			} else {
				System.out.println("Customer with ID " + c_id + " not found.");
			}

			rsCustomer.close();

		}
	}


