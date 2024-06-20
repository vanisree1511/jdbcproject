package dto;

public class Book {
	private int id;
	private String name;
	private String author;
	private double price;
	private String language;
	public Book(int id) {
		this.id=id;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Book(int id, String name, String author, double price, String language) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.language = language;
	}
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", language="
				+ language + "]";
	}
	

}
