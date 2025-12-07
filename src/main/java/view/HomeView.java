package view;

import java.util.Scanner;

public class HomeView {
	private final Scanner scanner = new Scanner(System.in);
	
	private final BookView bookView;
	
	public HomeView(BookView bookView) {
		this.bookView = bookView;
	}
	
	//	------------------------------------------------------------------------------------------------------------------
	int choice;
	
	public void run(){
		do {
			System.out.println("___WELCOME IN LIB48___");
			System.out.println(">______________________");
			System.out.println("1. Manage books;");
			System.out.println("2. Go to history;");
			System.out.println("0. Quit.");
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
				case 1 ->{
					bookView.screen();
				}
				case 2->{
					System.out.println("Not available yet.");
				}
				case  0->{
					System.out.println("GOOD BYE ...");
				}
				default -> {
					System.err.println("Bad choice, please try again");
				}
			}
		}while (choice != 0);
	}
}
