package view;

import controller.IBookHistoryController;
import model.BookHistory;
import myEnum.ActionStatus;

import java.util.LinkedList;
import java.util.Scanner;

public class HistoryView {
	private final Scanner scanner = new Scanner(System.in);
	
	private final IBookHistoryController bookHistoryController;
	
	public HistoryView(IBookHistoryController bookHistoryController) {
		this.bookHistoryController = bookHistoryController;
	}
	
//	----------------------------------------------------------------------------------------------------------------------------------------------
	int choice;
	
	public void screen(){
		System.out.println("___LIB48/HISTORY MANAGEMENT___");
		System.out.println(">______________________");
		System.out.println("1. Consult history;");
		System.out.println("2. Delete an history;");
		System.out.println("0. Back.");
		System.out.println(" ");
		System.out.print("Select an option there: ");
		System.out.println(" ");
		
		if (scanner.hasNextInt()){
			choice = scanner.nextInt();
		}else {
			System.err.println("Invalid choice, please try again.");
			scanner.next();
			choice = -1;
		}
		
		switch (choice){
			case 1->{
				consultHistory();
			}
			case 2->{
				deleteHistory();
			}
			case 0->{
				System.out.println("BACKING....");
			}
			default -> {
				System.err.println("Bad choice, please try again.");
			}
		}
	}

//UTILITY METHODS------------------------------------------------------------------------------------------------------------------
	
	private void consultHistory() {
		int choice;
		
		System.out.println("Consult by (1. All; 2. Action name; 3. Status; 0. Back): ");
		if (scanner.hasNextInt()){
			choice = scanner.nextInt();
		}else {
			System.err.println("Invalid choice, try again.");
			scanner.next();
			choice = -1;
		}
		
		switch (choice){
			case 1->{
				LinkedList<BookHistory> list = bookHistoryController.findAll();
				for (BookHistory bookHistory :  list){
					System.out.println(bookHistory);
				}
			}
			case 2->{
				System.out.println("Enter the action name: ");
				String action = scanner.next();
				LinkedList<BookHistory> list = bookHistoryController.findByActionName(action);
				for (BookHistory bookHistory :  list){
					System.out.println(bookHistory);
				}
			}
			case 3->{
				ActionStatus status;
				System.out.println("Select the status (1.SUCCEED; 2. FAILED): ");
				if (scanner.hasNextInt()){
					choice = scanner.nextInt();
				}else {
					System.err.println("Invalid choice, please try again.");
					scanner.next();
					choice = -1;
				}
				
				switch (choice) {
					case 1 -> {
						status = ActionStatus.SUCCEED;
						LinkedList<BookHistory> list = bookHistoryController.findByStatus(status);
						for (BookHistory bookHistory : list) {
							System.out.println(bookHistory);
						}
					}
					case 2 -> {
						status = ActionStatus.FAILED;
						LinkedList<BookHistory> list = bookHistoryController.findByStatus(status);
						for (BookHistory bookHistory : list) {
							System.out.println(bookHistory);
						}
					}
					case 0 -> System.out.println("Backing...");
					default -> {
						System.err.println("Bad choice, please try again");
					}
				}
			}
		}
	}
	
	private void deleteHistory() {
	
	}
}


