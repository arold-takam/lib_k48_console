import controller.IBookController;
import controller.implementation.BookController;
import repository.IBookRepository;
import repository.implementation.BookRepository;
import service.IBookService;
import service.implementation.BookService;
import validation.BookValidation;
import view.BookView;
import view.HomeView;

import java.util.Scanner;

public class main {
	Scanner scanner = new Scanner(System.in);
	
	static IBookRepository booRepository = new BookRepository();
	static BookValidation bookValidation = new BookValidation(booRepository);
	static IBookService bookService = new BookService(booRepository, bookValidation);
	static IBookController bookController = new BookController(bookService);
	static BookView bookView = new BookView(bookController);
	static HomeView homeView = new HomeView(bookView);
	
//	-----------------------------------------------------------------------------------------------------------------
	public static void main(String args[]){
		homeView.run();
	}
}
