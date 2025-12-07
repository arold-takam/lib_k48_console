package controller;

import model.Book;
import myEnum.SortAlgorithm;
import myEnum.SortOrder;

import java.util.ArrayList;

public interface IBookController {
	Book save(Book book);
	
	Book update(long bookID, Book newBook);
	
	boolean delete(long bookID);
	
	Book borrow(long BookID);
	
	Book returnBook(long BookID);
	
	//	----------------------------------------------------------------------------------------------------------------
	Book findByID(long bookID);
	
	Book findByTitle(String bookTitle);
	
	Book findByAuthor(String bookAuthor);
	
	Book findByISBN(String bookISBN);
	
	//	----------------------------------------------------------------------------------------------------------------
	ArrayList<Book> findAll();
	
	//	----------------------------------------------------------------------------------------------------------------
	ArrayList<Book>sortByTitle(SortOrder sortOrder, SortAlgorithm sortAlgorithm);
}
