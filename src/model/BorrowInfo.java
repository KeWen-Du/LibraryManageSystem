package model;

public class BorrowInfo {
	private String UserID;
	private String BookID;
	private String LendDate;
	private String ShouldReturnDate;
	private String ReturnDate;
	private int BorrowStatus;
	private int Penalty;
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getBookID() {
		return BookID;
	}
	public void setBookID(String bookID) {
		BookID = bookID;
	}
	public String getLendDate() {
		return LendDate;
	}
	public void setLendDate(String lendDate) {
		LendDate = lendDate;
	}
	public String getShouldReturnDate() {
		return ShouldReturnDate;
	}
	public void setShouldReturnDate(String shouldReturnDate) {
		ShouldReturnDate = shouldReturnDate;
	}
	public String getReturnDate() {
		return ReturnDate;
	}
	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}
	public int getBorrowStatus() {
		return BorrowStatus;
	}
	public void setBorrowStatus(int borrowStatus) {
		BorrowStatus = borrowStatus;
	}
	public int getPenalty() {
		return Penalty;
	}
	public void setPenalty(int penalty) {
		Penalty = penalty;
	}
	
}
