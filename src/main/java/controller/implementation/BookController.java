package controller.implementation;

import controller.IBookController;
import model.Book;
import myEnum.SortAlgorithm;
import myEnum.SortOrder;
import service.IBookService;

import java.util.ArrayList;

public class BookController implements IBookController {
	private final IBookService bookService;
	
	public BookController(IBookService bookService) {
		this.bookService = bookService;
	}
	
//	-----------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Book save(Book book) {
		try {
			return bookService.save(book);
		}catch (IllegalArgumentException e){
			System.err.println(e.getMessage());
		}
		
		return null;
	}
	
	@Override
	public Book update(long bookID, Book newBook) {
		try {
			return bookService.update(bookID, newBook);
		}catch (IllegalArgumentException e){
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public boolean delete(long bookID) {
		try {
			return bookService.delete(bookID);
		}catch (IllegalArgumentException e){
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	@Override
	public Book borrow(long BookID) {
		return bookService.borrow(BookID);
	}
	
	@Override
	public Book returnBook(long BookID) {
		return bookService.returnBook(BookID);
	}
	
	@Override
	public Book findByID(long bookID) {
		return bookService.findByID(bookID);
	}
	
	@Override
	public Book findByTitle(String bookTitle) {
		return bookService.findByTitle(bookTitle);
	}
	
	@Override
	public Book findByAuthor(String bookAuthor) {
		return bookService.findByAuthor(bookAuthor);
	}
	
	@Override
	public Book findByISBN(String bookISBN) {
		return bookService.findByISBN(bookISBN);
	}
	
	@Override
	public ArrayList<Book> findAll() {
		return bookService.findAll();
	}
	
	@Override
	public ArrayList<Book> sortByTitle(SortOrder sortOrder, SortAlgorithm sortAlgorithm) {
		return bookService.sortByTitle(sortOrder, sortAlgorithm);
	}
}
