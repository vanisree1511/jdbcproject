package dao;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class BookCrud {
	public void createTable() throws Exception{  //optional can create directly in the data base//
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store?createDatabaseIfNotExist=true","root","root");
		Statement statement=connection.createStatement();
		statement.execute("create table book(id int primary key,name varchar(45) not null,author varchar(45),price double,language varchar(45))");
		statement.close();
		
	}
	public void saveBook(dto.Book book) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store?user=root&password=root");
		PreparedStatement ps=connection.prepareStatement("insert into book values(?,?,?,?,?)");
		ps.setInt(1,book.getId());
		ps.setString(2,book.getName());
		ps.setString(3,book.getAuthor());
		ps.setDouble(4,book.getPrice());
		ps.setString(5,book.getLanguage());
		ps.execute();
		ps.close();
	}
	public void deleteBook(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store?user=root&password=root");
		PreparedStatement ps=connection.prepareStatement("delete from book where id=?" );
		ps.setInt(1, id);
		ps.execute();
		ps.close();
		
	}
	public void update(int id,String name,double price) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store?createDatabaseIfNotExist=true","root","root");
		PreparedStatement ps=c.prepareStatement("update book set name=?,price=? where id=?");
		ps.setString(1,name);
		ps.setDouble(2, price);
		ps.setInt(3, id);
		ps.execute();
		ps.close();		
	
	}	



}
