package service;

import model.BookHistory;
import myEnum.ActionStatus;
import java.util.LinkedList;

public interface IBookHistoryService{
	
	boolean delete(long storyID);
	
	//	-------------------------------------------------------------------------------------------------------
	LinkedList<BookHistory> findAll();
	
	BookHistory findByID(long storyID);
	//	-------------------------------------------------------------------------------------------------------
	LinkedList<BookHistory>findByActionName(String actionName);
	
	LinkedList<BookHistory>findByStatus(ActionStatus status);
}
