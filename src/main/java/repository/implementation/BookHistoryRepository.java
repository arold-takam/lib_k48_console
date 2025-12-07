package repository.implementation;

import model.BookHistory;
import myEnum.ActionStatus;
import repository.IBookHistoryRepository;

import java.util.LinkedList;

public class BookHistoryRepository implements IBookHistoryRepository
{
	LinkedList<BookHistory> bookHistoryLinkedList  = new LinkedList<>();
//	-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public BookHistory save(BookHistory bookHistory) {
		bookHistoryLinkedList.add(bookHistory);
		
		return bookHistory;
	}
	
	@Override
	public boolean delete(long storyID) {
		return bookHistoryLinkedList.removeIf(history -> history.getId() == storyID);
	}
	
	@Override
	public LinkedList<BookHistory> findAll() {
		return bookHistoryLinkedList;
	}
	
	@Override
	public BookHistory findByID(long storyID) {
		for (BookHistory history : bookHistoryLinkedList){
			if (history.getId() == storyID){
				return history;
			}
		}
		
		return null;
	}
	
	@Override
	public LinkedList<BookHistory> findByActionName(String actionName) {
		LinkedList<BookHistory>bookHistories = new LinkedList<>();
		
		for (BookHistory bookHistory: bookHistoryLinkedList){
			if (bookHistory.getActionName().equals(actionName)){
				bookHistories.add(bookHistory);
			}
		}
		
		return bookHistories;
	}
	
	@Override
	public LinkedList<BookHistory> findByStatus(ActionStatus status) {
		LinkedList<BookHistory>bookHistories = new LinkedList<>();
		
		for (BookHistory bookHistory: bookHistoryLinkedList){
			if (bookHistory.getStatus().equals(status)){
				bookHistories.add(bookHistory);
			}
		}
		
		return bookHistories;
	}
}
