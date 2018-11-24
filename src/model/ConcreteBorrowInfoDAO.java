package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class ConcreteBorrowInfoDAO implements BorrowInfoDAO{
	public int addBorrowInfo(BorrowInfo borrowInfo) {
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "insert into borrowinfo(UserID,BookID,LendDate,"
    	    		+ "ShouldReturnDate,ReturnDate,BorrowStatus,Penalty) "
    	    		+ "values(?,?,?,?,?,?,?)";
    	    ps = con.prepareStatement(sql);
    	    
    	    ps.setString(1, borrowInfo.getUserID());
    	    ps.setString(2, borrowInfo.getBookID());
    	    ps.setString(2, borrowInfo.getLendDate());
    	    ps.setString(2, borrowInfo.getShouldReturnDate());
    	    ps.setString(2, borrowInfo.getReturnDate());
    	    ps.setInt(2, borrowInfo.getBorrowStatus());
    	    ps.setInt(2, borrowInfo.getPenalty());

    	    i = ps.executeUpdate() ;
    	}
    	catch(SQLException e)
    	{
    		throw new DAOException(e.getMessage(),e);
    	}
    	finally
    	{
    		MySqlConnection.free(null, ps, con);
    	}
    	return i;//i=0添加失败。i=1添加成功
	}

	@Override
	public int deleteBorrowInfo(String UserID , String BookID , String LendDate) {
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "delete from borrowinfo where UserID=? and "
    	    		+ "BookID=? and LendDate=?";
    	    ps = con.prepareStatement(sql);
    	    ps.setString(1, UserID);
    	    ps.setString(2, BookID);
    	    ps.setString(3, LendDate);
    	    
    	    i = ps.executeUpdate() ;
    	    
    	}
    	catch(SQLException e)
    	{
    		throw new DAOException(e.getMessage(),e);
    	}
    	finally
    	{
    		MySqlConnection.free(null, ps, con);
    	}
	    	
		return i;//i=0删除失败。i=1删除成功
	}

	@Override
	public int updateBorrowInfo(BorrowInfo borrowInfo) {
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "update student set ShouldReturnDate=?, ReturnDate=?,"
    	    		+ "BorrowStatus=?, Penalty=?  where UserID=? and BookID=? and "
    	    		+ "LendDate=?";
    	    ps = con.prepareStatement(sql);
    	    
    	    ps.setString(1, borrowInfo.getShouldReturnDate());
    	    ps.setString(2, borrowInfo.getReturnDate()); 
    	    ps.setInt(3, borrowInfo.getBorrowStatus());
    	    ps.setInt(4, borrowInfo.getPenalty());
    	    ps.setString(5, borrowInfo.getUserID()); 
    	    ps.setString(6, borrowInfo.getBookID()); 
    	    ps.setString(7, borrowInfo.getLendDate()); 

    	    
    	    i = ps.executeUpdate() ;
    	    
    	}
    	catch(SQLException e)
    	{
    		throw new DAOException(e.getMessage(),e);
    	}
    	finally
    	{
    		MySqlConnection.free(null, ps, con);
    	}
		
		return i;//i=0更新失败。i=1更新成功
	}

	@Override
	public BorrowInfo findBorrowInfo(String UserID , String BookID , String LendDate) {
		Connection con = null ;
    	PreparedStatement ps = null ;
    	BorrowInfo borrowInfo=null;
    	ResultSet rs = null;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "select UserID,BookID,LendDate,ShouldReturnDate,"
    	    		+ "ReturnDate,BorrowStatus,Penalty from borrowinfo "
    	    		+ "where UserID =? and BookID=? and LendDate=?";
    	    ps = con.prepareStatement(sql);
    	    ps.setString(1,UserID);
    	    
    	    rs = ps.executeQuery() ;
    	    borrowInfo=new BorrowInfo();
    	    while(rs.next())
    	    {
    	    	borrowInfo.setUserID(rs.getString(1));
    	    	borrowInfo.setBookID(rs.getString(2));
    	    	borrowInfo.setLendDate(rs.getString(3));
    	    	borrowInfo.setShouldReturnDate(rs.getString(4));
    	    	borrowInfo.setReturnDate(rs.getString(5));
    	    	borrowInfo.setBorrowStatus(rs.getInt(6));
    	    	borrowInfo.setPenalty(rs.getInt(7));
    	    }
    	    
    	}
    	catch(SQLException e)
    	{
    		throw new DAOException(e.getMessage(),e);
    	}
    	finally
    	{
    		MySqlConnection.free(rs, ps, con);
    	}
		
		return borrowInfo;

	}

	@Override
	public Set<BorrowInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
