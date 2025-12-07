package controller.implementation;

import controller.IBookHistoryController;
import model.BookHistory;
import myEnum.ActionStatus;
import service.IBookHistoryService;

import java.util.LinkedList;

public class BookHistoryController implements IBookHistoryController {
	private final IBookHistoryService bookHistoryService;
	
	public BookHistoryController(IBookHistoryService bookHistoryService) {
		this.bookHistoryService = bookHistoryService;
	}
	
//	-------------------------------------------------------------------------------------------------
	@Override
	public BookHistory save(BookHistory bookHistory) {
		try {
			return bookHistoryService.save(bookHistory);
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public boolean delete(long storyID) {
		try {
			return bookHistoryService.delete(storyID);
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	@Override
	public LinkedList<BookHistory> findAll() {
		try {
			return bookHistoryService.findAll();
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public BookHistory findByID(long storyID) {
		try {
			return bookHistoryService.findByID(storyID);
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public LinkedList<BookHistory> findByActionName(String actionName) {
		try {
			return bookHistoryService.findByActionName(actionName);
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public LinkedList<BookHistory> findByStatus(ActionStatus status) {
		try {
			return bookHistoryService.findByStatus(status);
		}catch (Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}
}
