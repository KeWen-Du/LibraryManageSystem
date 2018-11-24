package model;

public class User {
	private String UserID;
	private String UserName;
	private int UserType;
	private String UserPassword;
	private int UserStatus;
	private int MonthBorrowNum;
	private int BorrowSum;
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getUserType() {
		return UserType;
	}
	public void setUserType(int userType) {
		UserType = userType;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public int getUserStatus() {
		return UserStatus;
	}
	public void setUserStatus(int userStatus) {
		UserStatus = userStatus;
	}
	public int getMonthBorrowNum() {
		return MonthBorrowNum;
	}
	public void setMonthBorrowNum(int monthBorrowNum) {
		MonthBorrowNum = monthBorrowNum;
	}
	public int getBorrowSum() {
		return BorrowSum;
	}
	public void setBorrowSum(int borrowSum) {
		BorrowSum = borrowSum;
	}
	
	
}
