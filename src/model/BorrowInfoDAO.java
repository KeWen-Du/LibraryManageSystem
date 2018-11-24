package model;

import java.util.Set;

public interface BorrowInfoDAO {
	public int addBorrowInfo(BorrowInfo borrowInfo) ;
	
	public int deleteBorrowInfo(String userID,String bookID,String lendDate);
	
	public int updateBorrowInfo(BorrowInfo borrowInfo);
	
	public BorrowInfo findBorrowInfo(String userID,String bookID,String lendDate);
	
	public Set<BorrowInfo> findAll();
}
