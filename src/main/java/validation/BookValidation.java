package validation;

import model.Book;
import repository.IBookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookValidation {
	private final List<String>errorList = new ArrayList<>();
	
	private final IBookRepository bookRepository;
	
	public BookValidation(IBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	//	----------------------------------------------------------------------------------------------------------------------
	public List<String> validateSave(Book book){
		errorList.clear();
		
		Book evenBook = bookRepository.findByTitle(book.getTitle());
		
		if (book.getTitle().isBlank()){
			errorList.add("This book title is invalid.");
		}
		
		if (evenBook != null && book.getTitle().equals(evenBook.getTitle())){
			errorList.add("this title is already took by a book.");
		}
		
		if (evenBook != null && evenBook.getISBN().equals(book.getISBN()) && evenBook.getId() != book.getId()){
			errorList.add("This ISBN is already taken by another book.");
		}
		
		return errorList;
	}
	
	public List<String>validateUpdate(long bookID, Book newBook){
		errorList.clear();
		
		Book existingBook = bookRepository.findByID(bookID);
		if (existingBook == null){
			errorList.add("No book found with the ID: "+bookID);
		}
		
		assert existingBook != null;
		if (existingBook.getTitle().equals(newBook.getTitle()) && existingBook.getId() != newBook.getId()){
			errorList.add("This title is already taken by another book.");
		}
		
		if (existingBook.getISBN().equals(newBook.getISBN()) && existingBook.getId() != newBook.getId()){
			System.err.println("This ISBN is already taken by another book.");
		}
		
		return errorList;
	}
	
	public List<String>validateDelete(long bookID){
		errorList.clear();
		
		Book existingBook = bookRepository.findByID(bookID);
		if (existingBook == null){
			errorList.add("No book found with the ID: "+bookID);
		}
		
		return errorList;
	}
}
