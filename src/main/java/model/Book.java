package model;

public class Book {
	private static long cpt = 0;
	
	private long id;
	private String title;
	private String author;
	private String ISBN;
	public long publicationYear;
	private String gender;
	private boolean isBorrowed;
	
	public Book() {
		this.id = cpt++;
	}
	
	public Book(String title, String author, String ISBN, long publicationYear, String gender, boolean isBorrowed) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.publicationYear = publicationYear;
		this.gender = gender;
		this.isBorrowed = isBorrowed;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public long getPublicationYear() {
		return publicationYear;
	}
	
	public void setPublicationYear(long publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public boolean isBorrowed() {
		return isBorrowed;
	}
	
	public void setBorrowed(boolean borrowed) {
		isBorrowed = borrowed;
	}
	
	@Override
	public String toString() {
		return "Book{" +"id=" + id +", title=" + title  +", author=" + author +", ISBN=" + ISBN  +", publicationYear=" + publicationYear +", gender=" + gender  +", isBorroweb=" + isBorrowed +'}';
	}
}
