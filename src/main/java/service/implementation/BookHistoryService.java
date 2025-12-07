package service.implementation;

import model.BookHistory;
import myEnum.ActionStatus;
import repository.IBookHistoryRepository;
import service.IBookHistoryService;

import java.util.LinkedList;

public class BookHistoryService implements IBookHistoryService {
	private final IBookHistoryRepository bookHistoryRepository;
	
	public BookHistoryService(IBookHistoryRepository bookHistoryRepository) {
		this.bookHistoryRepository = bookHistoryRepository;
	}
	
//	------------------------------------------------------------------------------------------------------------------------
	
	@Override
	public boolean delete(long storyID) {
		return bookHistoryRepository.delete(storyID);
	}
	
	@Override
	public LinkedList<BookHistory> findAll() {
		return bookHistoryRepository.findAll();
	}
	
	@Override
	public BookHistory findByID(long storyID) {
		return bookHistoryRepository.findByID(storyID);
	}
	
	@Override
	public LinkedList<BookHistory> findByActionName(String actionName) {
		return bookHistoryRepository.findByActionName(actionName);
	}
	
	@Override
	public LinkedList<BookHistory> findByStatus(ActionStatus status) {
		return bookHistoryRepository.findByStatus(status);
	}
}
