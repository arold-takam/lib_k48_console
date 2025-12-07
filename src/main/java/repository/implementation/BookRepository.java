package repository.implementation;

import model.Book;
import myEnum.SortAlgorithm;
import myEnum.SortOrder;
import repository.IBookRepository;
import java.util.*;

public class BookRepository implements IBookRepository {
	private final List<Book>bookList = new ArrayList<>();
	
//	-------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Book save(Book book) {
		bookList.add(book);
		
		return book;
	}
	
	@Override
	public Book update(long bookID, Book newBook) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getId() == bookID){
				bookList.set(i, newBook);
				
				return newBook;
			}
		}
		
		return null;
	}
	
	@Override
	public boolean delete(long bookID) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getId() == bookID){
				bookList.remove(i);
				
				return true;
			}
		}
		
		return false;
	}

//	-----------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public Book findByID(long bookID) {
		bookList.sort(Comparator.comparing(Book :: getId));
		
		Book evenBook = new Book();
		evenBook.setId(bookID);
		
		int index = Collections.binarySearch(bookList, evenBook, Comparator.comparing(Book::getId));
		if (index >= 0){
			return bookList.get(index);
		}
		
		return null;
	}
	
	
	@Override
	public Book findByTitle(String bookTitle) {
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getTitle().equals(bookTitle)){
				return bookList.get(i);
			}
		}
		
		return null;
	}
	
	@Override
	public Book findByAuthor(String bookAuthor) {
		for (Book book: bookList){
			if (book.getAuthor().equals(bookAuthor)){
				return book;
			}
		}
		
		return null;
	}
	
	@Override
	public Book findByISBN(String bookISBN) {
		for (Book book : bookList) {
			if (book.getISBN().equals(bookISBN)) {
				return book;
			}
		}
		
		return null;
	}
	
	@Override
	public ArrayList<Book> findAll() {
		return new ArrayList<>(bookList);
	}
	
//	-----------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public ArrayList<Book> sortByTitle(SortOrder sortOrder, SortAlgorithm sortAlgorithm) {
		ArrayList<Book>sortedList = new ArrayList<>(bookList);
		Comparator<Book> titleComparator = Comparator.comparing(Book::getTitle);
		
		Comparator<Book>finalComparator = (sortOrder == SortOrder.DESC) ? titleComparator.reversed() : titleComparator;
		
		switch (sortAlgorithm){
			case BUBBLE_SORT -> {
				applyBubbleSort(sortedList, finalComparator);
			}
			case QUICK_SORT -> {
				applyQuickSort(sortedList, finalComparator);
			}
			case SELECTION_SORT -> {
				applySelectionSort(sortedList, finalComparator);
			}
		}
		
		return sortedList;
	}
	
	//	UTILITIES METHODS-------------------------------------------------------------------------
	private void applyBubbleSort(ArrayList<Book> sortedList, Comparator<Book> finalComparator) {
		int n = sortedList.size();
		
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			
			for (int j = 0; j < n - 1 - i; j++) {
				if (finalComparator.compare(sortedList.get(j), sortedList.get(j + 1)) > 0){
					Book temp = sortedList.get(j);
					sortedList.set(j, sortedList.get(j + 1));
					sortedList.set(j + 1, temp);
					swapped = true;
				}
			}
			
			if (!swapped){
				break;
			}
		}
	}
	
	private void applyQuickSort(ArrayList<Book> sortedList, Comparator<Book> finalComparator) {
		quickSort(sortedList, 0, sortedList.size() - 1, finalComparator);
	}
	
	private void applySelectionSort(ArrayList<Book> sortedList, Comparator<Book> finalComparator) {
		int n = sortedList.size();
		
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			
			for (int j = i + 1; j  <  n; j++) {
				if (finalComparator.compare(sortedList.get(j), sortedList.get(minIndex)) < 0){
					minIndex = j;
				}
			}
			
			if (minIndex != i){
				Book temp = sortedList.get(i);
				sortedList.set(i, sortedList.get(minIndex));
				sortedList.set(minIndex, temp);
			}
		}
	}
	
//	--------------------------------------------------------------------------------
	private int partition(ArrayList<Book>list, int low, int high, Comparator<Book> finalComp){
		Book pivot = list.get(high);
		
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (finalComp.compare(list.get(j), pivot) <= 0){
				i++;
				
				Book temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}
		
		Book temp = list.get(i + 1);
		list.set(i + 1, list.get(high));
		list.set(high, temp);
		
		return i + 1;
	}
	
	private void quickSort(ArrayList<Book>list, int low, int high, Comparator<Book>finalComp){
		if (low < high){
			int pi = partition(list, low, high, finalComp);
			
			quickSort(list, low, pi - 1, finalComp);
			
			quickSort(list, low, pi + 1, finalComp);
		}
	}
}
