package controller;

import java.util.Scanner;

import dao.BookCrud;
import dao.UserCrud;
import dto.Book;



public class User {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("......Welcome to the Bookstore.....");
		System.out.println("***************");

		boolean check = true;
		do {
			System.out.println("1.Book 2.User 3.exit");
			System.out.println("select the option below");
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				boolean check2 = true;
				do {
					System.out.println("1.save 2.update 3.delete.4.exit");
					int i = scan.nextInt();
					switch (i) {
					case 1: {
						System.out.println("enter the id");
						int id = scan.nextInt();
						System.out.println("enter the name");
						String name = scan.next();
						System.out.println("enter the name of the author");
						String author = scan.next();
						System.out.println("enter the price");
						double price = scan.nextDouble();
						System.out.println("enter the language");
						String language = scan.next();
						BookCrud bookcrud = new BookCrud();
						Book book = new Book(id, name, author, price, language);
						bookcrud.saveBook(book);
						System.out.println("saved");
					}
						break;
					case 2: {
						System.out.println("enter the id");
						int id = scan.nextInt();
						System.out.println("enter the name");
						String name = scan.next();
						System.out.println("enter the price");
						double price = scan.nextDouble();

						BookCrud bc = new BookCrud();
						bc.update(id, name, price);
						System.out.println("updated");
					}
						break;
					case 3: {
						System.out.println("enter the id to delete");
						int id = scan.nextInt();
						BookCrud bc = new BookCrud();
						Book book = new Book(id);
						bc.deleteBook(id);
						System.out.println("deleted");
					}
						break;
					case 4: {
						check2 = false;
					}
						break;
					}

				} while (check2);
			}
				break;

			case 2: {
				boolean ch = true;
				do {
					System.out.println("1.newuser 2.purchase 3.exit");
					int ch1 = scan.nextInt();
					switch (ch1) {
					case 1: {
						System.out.println("enter the id");
						int id = scan.nextInt();
						System.out.println("enter the name");
						String name = scan.next();
						System.out.println("enter the amount");
						double d = scan.nextDouble();
						UserCrud uc = new UserCrud();
						uc.details(id, name, d);
						System.out.println("inserted...");
					}
						break;
					case 2: {
						System.out.println("Books availabe in the BookStore");
						UserCrud uc = new UserCrud();
						uc.buy();

						System.out.println("please enter your customer id");
						int cust = scan.nextInt();
						System.out.println("enter the amount available");
						double amt = scan.nextDouble();
						System.out.println("enter the book id to purchase");
						int c = scan.nextInt();
						uc.user(c, amt, cust);

					}
					case 3:{
						ch=false;
					}

					}

				} while (ch);
			}

			case 3: {
				check = false;

			}
				break;

			}
		} while (check);
		System.out.println("@@@@****THANKS VISIT US AGAIN****@@@@");

	}
}
