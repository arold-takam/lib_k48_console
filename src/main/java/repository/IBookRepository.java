package repository;

import model.Book;
import myEnum.SortAlgorithm;
import myEnum.SortOrder;
import java.util.ArrayList;

public interface IBookRepository {
	Book save(Book book);
	
	Book update(long bookID, Book newBook);
	
	boolean delete(long bookID);
	
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
