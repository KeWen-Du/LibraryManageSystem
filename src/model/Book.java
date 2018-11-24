package model;

public class Book {
	private String BookID;
	private String BookName;
	private String Author;
	private String PublishHouse;
	private int BookCategory;
	private String PublishDate;
	private int BookSum;
	private int BookNum;
	private int BookStatus;
	private int BorrowedNum;
	
	public int getBookSum() {
		return BookSum;
	}
	public void setBookSum(int bookSum) {
		BookSum = bookSum;
	}
	public String getBookID() {
		return BookID;
	}
	public void setBookID(String bookID) {
		BookID = bookID;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublishHouse() {
		return PublishHouse;
	}
	public void setPublishHouse(String publishHouse) {
		PublishHouse = publishHouse;
	}
	public int getBookCategory() {
		return BookCategory;
	}
	public void setBookCategory(int bookCategory) {
		BookCategory = bookCategory;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public int getBookNum() {
		return BookNum;
	}
	public void setBookNum(int bookNum) {
		BookNum = bookNum;
	}
	public int getBookStatus() {
		return BookStatus;
	}
	public void setBookStatus(int bookStatus) {
		BookStatus = bookStatus;
	}
	public int getBorrowedNum() {
		return BorrowedNum;
	}
	public void setBorrowedNum(int borrowedNum) {
		BorrowedNum = borrowedNum;
	}
	
}
