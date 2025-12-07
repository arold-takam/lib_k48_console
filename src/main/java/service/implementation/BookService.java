package service.implementation;

import model.Book;
import myEnum.SortAlgorithm;
import myEnum.SortOrder;
import repository.IBookRepository;
import service.IBookService;
import validation.BookValidation;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BookService implements IBookService {
	private List<String>errorList = new ArrayList<>();
	
	private final IBookRepository bookRepository;
	private final BookValidation validation;
	
	public BookService(IBookRepository bookRepository, BookValidation validation) {
		this.bookRepository = bookRepository;
		this.validation = validation;
	}
	
	@Override
	public Book save(Book book) {
		errorList.clear();
		errorList = validation.validateSave(book);
		if (!errorList.isEmpty()){
			throw new IllegalArgumentException("Invalid Book to save: "+errorList);
		}
		
		return bookRepository.save(book);
	}
	
	@Override
	public Book update(long bookID, Book newBook) {
		errorList.clear();
		errorList = validation.validateUpdate(bookID, newBook);
		if (!errorList.isEmpty()){
			throw new IllegalArgumentException("Invalid Book to save: "+errorList);
		}
		
		return bookRepository.update(bookID, newBook);
	}
	
	@Override
	public boolean delete(long bookID) {
		errorList.clear();
		errorList = validation.validateDelete(bookID);
		if (!errorList.isEmpty()){
			throw new NoSuchElementException("No book found with the ID: "+bookID);
		}
		
		return bookRepository.delete(bookID);
	}
	
	@Override
	public Book borrow(long BookID) {
		Book book = findByID(BookID);
		book.setBorrowed(true);
		
		update(book.getId(), book);
		
		return book;
	}
	
	@Override
	public Book returnBook(long BookID) {
		Book book = findByID(BookID);
		book.setBorrowed(false);
		
		update(book.getId(), book);
		
		return book;
	}
	
	@Override
	public Book findByID(long bookID) {
		return bookRepository.findByID(bookID);
	}
	
	@Override
	public Book findByTitle(String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}
	
	@Override
	public Book findByAuthor(String bookAuthor) {
		return bookRepository.findByAuthor(bookAuthor);
	}
	
	@Override
	public Book findByISBN(String bookISBN) {
		return bookRepository.findByISBN(bookISBN);
	}
	
	@Override
	public ArrayList<Book> findAll() {
		return bookRepository.findAll();
	}
	
	@Override
	public ArrayList<Book> sortByTitle(SortOrder sortOrder, SortAlgorithm sortAlgorithm) {
		return bookRepository.sortByTitle(sortOrder, sortAlgorithm);
	}
}
