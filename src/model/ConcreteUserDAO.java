package model;

import java.util.Set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConcreteUserDAO implements UserDAO {
	@Override
	public int addUser(User user) {
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "insert into userinfo(UserID,UserName,UserType,UserPWD,"
    	    		+ "UserStatus,MonthBorrowNum,BorrowSum) values(?,?,?,?,?,?,?)";
    	    ps = con.prepareStatement(sql);
    	    
    	    ps.setString(1, user.getUserID());
    	    ps.setString(2, user.getUserName());
    	    ps.setInt(3, user.getUserType());
    	    ps.setString(4, user.getUserPassword());
    	    ps.setInt(5, user.getUserStatus());
    	    ps.setInt(6, user.getMonthBorrowNum());
    	    ps.setInt(7, user.getBorrowSum());
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
	public int deleteUser(String UserID) {
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "delete from userinfo where UserID=?";
    	    ps = con.prepareStatement(sql);
    	    ps.setString(1, UserID);
    	    
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
	public int updateUser(User user) {
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "update userinfo set UserName=?, UserType=?, UserPWD=?,"
    	    		+ " UserStatus=?, MonthBorrowNum=?, BorrowSum=?  where UserID=?";
    	    ps = con.prepareStatement(sql);
    	    
    	    ps.setString(1, user.getUserName());    	    
    	    ps.setInt(2, user.getUserType());
    	    ps.setString(3, user.getUserPassword());
    	    ps.setInt(4, user.getUserStatus());
    	    ps.setInt(5, user.getMonthBorrowNum());
    	    ps.setInt(6, user.getBorrowSum());
    	    ps.setString(7, user.getUserID());
    	    
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
	public User findUser(String UserID) {
		// TODO Auto-generated method stub
		Connection con = null ;
    	PreparedStatement ps = null ;
    	User user=new User();
    	ResultSet rs = null;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "select UserID,UserName,UserType,UserPWD,UserStatus,"
    	    		+ "MonthBorrowNum,BorrowSum from userinfo where UserID =?";
    	    ps = con.prepareStatement(sql);
    	    ps.setString(1,UserID);
    	    
    	    rs = ps.executeQuery() ;

    	    if (rs.next()) {
    	    	rs.previous();
	    	    while(rs.next())
	    	    {
	    	    	user.setUserID(rs.getString(1));
	    	    	user.setUserName(rs.getString(2));
	    	    	user.setUserType(rs.getInt(3));    	    	
	    	    	user.setUserPassword(rs.getString(4));
	    	    	user.setUserStatus(rs.getInt(5));
	    	    	user.setMonthBorrowNum(rs.getInt(6));
	    	    	user.setBorrowSum(rs.getInt(7));
	    	    }
    	    }else{
    	    	user.setUserStatus(-1);
    	    	return user;
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
		
		return user;

	}

	@Override
	public Set<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
