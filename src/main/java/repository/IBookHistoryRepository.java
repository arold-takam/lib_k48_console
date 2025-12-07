package repository;

import model.BookHistory;
import myEnum.ActionStatus;
import java.util.LinkedList;

public interface IBookHistoryRepository {

	BookHistory save(BookHistory bookHistory);
	
	boolean delete(long storyID);
	
//	-------------------------------------------------------------------------------------------------------
	LinkedList<BookHistory>findAll();
	
	BookHistory findByID(long storyID);
//	-------------------------------------------------------------------------------------------------------
	LinkedList<BookHistory>findByActionName(String actionName);
	
	LinkedList<BookHistory>findByStatus(ActionStatus status);
}
