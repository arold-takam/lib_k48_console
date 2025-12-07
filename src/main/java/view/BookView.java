package view;

import controller.IBookController;
import model.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookView {
	private final Scanner scanner = new Scanner(System.in);
	
	private final IBookController bookController;
	
	public BookView(IBookController bookController) {
		this.bookController = bookController;
	}
	
	//	------------------------------------------------------------------------------------------------------------------
	int choice;
	
	public void screen(){
		do {
			System.out.println("___LIB48/BOOK MANAGEMENT___");
			System.out.println(">______________________");
			System.out.println("1. Add new book;");
			System.out.println("2. Consult books;");
			System.out.println("3. Update a book");
			System.out.println("4. Delete a book");
			System.out.println("5. Borrow a book");
			System.out.println("6. Return a book");
			System.out.println("0. Back.");
			System.out.println(" ");
			System.out.print("Select an option there: ");
			System.out.println(" ");
			
			if (scanner.hasNextInt()){
				choice = scanner.nextInt();
			}else {
				System.err.println("Invalid choice, please try again.");
				scanner.next();
				choice = -1;
			}
			
			switch (choice){
				case 1 ->{
					saveBook();
				}
				case 2->{
					consultBook();
				}
				case 3->{
					updateBook();
				}
				case 4->{
					deleteBook();
				}
				case 5->{
					borrowBook();
				}
				case 6->{
					returnBook();
				}
				case  0->{
					System.out.println("GOOD BYE ...");
				}
				default -> {
					System.err.println("Bad choice, please try again");
				}
			}
		}while (choice != 0);
	}
	
	//	UTILITIES METHODS----------------------------------------------------------------------------------
	private void saveBook() {
		System.out.print("Enter the title: ");
		String title = scanner.next();
		scanner.nextLine();
		System.out.print("Enter the ISBN: ");
		String isbn = scanner.next();
		
		Book book =new Book();
		book.setTitle(title);
		book.setAuthor("toto");
		book.setISBN(isbn);
		book.setPublicationYear(2025);
		book.setGender("Gender");
		book.setBorrowed(false);
		
		bookController.save(book);
	}
	
	private void consultBook() {
		System.out.println("Select your way to consult (1.All; 2.By title; 3.By Author; 4.By ISBN; 0.Back)? : ");
		if (scanner.hasNextInt()){
			choice = scanner.nextInt();
		}else {
			choice = -1;
		}
		
		switch (choice){
			case 1->{
				ArrayList<Book>bookList = bookController.findAll();
				for (Book book: bookList){
					System.out.println(book);
				}
			}
			case 2->{
				System.out.print("Enter the title: ");
				String title = scanner.next();;
				System.out.println(bookController.findByTitle(title));
			}
			case 3->{
				System.out.print("Enter the Author: ");
				String author = scanner.next();;
				System.out.println(bookController.findByAuthor(author));
			}
			case 4->{
				System.out.print("Enter the ISBN: ");
				String isbn = scanner.next();;
				System.out.println(bookController.findByISBN(isbn));
			}
			case 0->{
				System.out.println("BACKING BEHIND___");
			}
			default -> {
				System.err.println("Bad choice, please try again");
			}
		}
	}
	
	private void updateBook() {
		System.out.print("Enter the book title: ");
		String title = scanner.next();
		Book bookToUpdate = bookController.findByTitle(title);
		scanner.nextLine();
		System.out.print("What do you want to update?(1.title; 2.author; 0.Back): ");
		if (scanner.hasNextInt()){
			choice = scanner.nextInt();
		}else {
			choice = -1;
		}
		
		switch (choice){
			case 1->{
				System.out.print("Enter the new book title: ");
				String newTitle = scanner.next();
				bookToUpdate.setTitle(newTitle);
				bookController.update(bookToUpdate.getId(), bookToUpdate);
			}
			case 2->{
				System.out.print("Enter the new book Author: ");
				String author = scanner.next();
				bookToUpdate.setAuthor(author);
				bookController.update(bookToUpdate.getId(), bookToUpdate);
			}
			case 0->{
				System.out.println("BACKING BEHIND___");
			}
			default -> {
				System.err.println("Bad choice, please try again");
			}
		}
	}
	
	private void deleteBook() {
		System.out.print("Enter the book title: ");
		String title = scanner.next();
		Book bookToDelete = bookController.findByTitle(title);
		scanner.nextLine();
		System.out.print("Would you really delete this book?(1.Yes; 0.No: ");
		if (scanner.hasNextInt()){
			choice = scanner.nextInt();
		}else {
			choice = -1;
		}
		
		switch (choice){
			case 1->{
				bookController.delete(bookToDelete.getId());
				System.out.println("Book deleted successfully !");
			}
			case 0->{
				System.out.println("BACKING BEHIND___");
			}
			default -> {
				System.err.println("Bad choice, please try again");
			}
		}
	}
	
	private void borrowBook() {
		System.out.print("Enter the book title: ");
		String title = scanner.next();
		Book bookToBorrow = bookController.findByTitle(title);
		scanner.nextLine();
		if (bookToBorrow.isBorrowed()){
			System.out.println("This book is already borrowed.");
			
			return;
		}
		
		bookToBorrow.setBorrowed(true);
		bookController.update(bookToBorrow.getId(), bookToBorrow);
		
		System.out.println("Borrow made successfully.");
	}
	
	private void returnBook() {
		System.out.print("Enter the book title: ");
		String title = scanner.next();
		Book bookToReturn = bookController.findByTitle(title);
		scanner.nextLine();
		if (!bookToReturn.isBorrowed()){
			System.out.println("This book is already returned.");
			
			return;
		}
		
		bookToReturn.setBorrowed(false);
		bookController.update(bookToReturn.getId(), bookToReturn);
		
		System.out.println("Return made successfully.");
	}
}
