package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class ConcreteBookDAO implements BookDAO{
	public int addBook(Book book) {
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "insert into bookinfo(BookID,BookName,Author,"
    	    		+ "PublishHouse,BookCategory,PublishDate,BookSum,BookNum,"
    	    		+ "BookStatus,BorrowedNum) values(?,?,?,?,?,?,?,?,?,?)";
    	    ps = con.prepareStatement(sql);
    	    
    	    ps.setString(1, book.getBookID());
    	    ps.setString(2, book.getBookName());
    	    ps.setString(3, book.getAuthor());
    	    ps.setString(4, book.getPublishHouse());
    	    ps.setInt(5, book.getBookCategory());
    	    ps.setString(6, book.getPublishDate());
    	    ps.setInt(7, book.getBookSum());
    	    ps.setInt(8, book.getBookNum());
    	    ps.setInt(9, book.getBookStatus());
    	    ps.setInt(10, book.getBorrowedNum());
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
	public int deleteBook(String BookID) {
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "delete from bookinfo where BookID=?";
    	    ps = con.prepareStatement(sql);
    	    ps.setString(1, BookID);
    	    
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
	public int updateBook(Book book) {
		Connection con = null ;
    	PreparedStatement ps = null ;
    	int i = 0 ;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "update bookinfo set BookName=?, Author=?, PublishHouse=?,"
    	    		+ " BookCategory=?, PublishDate=?, BookSum=?, BookNum=?,"
    	    		+ " BookStatus=?, BorrowedNum=? where BookID=?";
    	    ps = con.prepareStatement(sql);
    	    
    	    ps.setString(1, book.getBookName());
    	    ps.setString(2, book.getAuthor());
    	    ps.setString(3, book.getPublishHouse());
    	    ps.setInt(4, book.getBookCategory());
    	    ps.setString(5, book.getPublishDate());
    	    ps.setInt(6, book.getBookSum());
    	    ps.setInt(7, book.getBookNum());
    	    ps.setInt(8, book.getBookStatus());
    	    ps.setInt(9, book.getBorrowedNum());
    	    ps.setString(10, book.getBookID());

    	    
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
	public Book findBook(String BookID) {
		// TODO Auto-generated method stub
		Connection con = null ;
    	PreparedStatement ps = null ;
    	Book book = null;
    	ResultSet rs = null;
    	try
    	{
    	    con = MySqlConnection.getConnection();
    	    String sql = "select BookID,BookName,Author,"
    	    		+ "PublishHouse,BookCategory,PublishDate,BookSum,BookNum,"
    	    		+ "BookStatus,BorrowedNum from bookinfo where BookID =?";
    	    ps = con.prepareStatement(sql);
    	    ps.setString(1,BookID);
    	    
    	    rs = ps.executeQuery() ;
    	    book=new Book();
    	    while(rs.next())
    	    {
    	    	book.setBookID(rs.getString(1));
    	    	book.setBookName(rs.getString(2));
    	    	book.setAuthor(rs.getString(3));
    	    	book.setPublishHouse(rs.getString(4));
    	    	book.setBookCategory(rs.getInt(5));
    	    	book.setPublishDate(rs.getString(6));
    	    	book.setBookSum(rs.getInt(7));
    	    	book.setBookNum(rs.getInt(8));
    	    	book.setBookStatus(rs.getInt(9));
    	    	book.setBorrowedNum(rs.getInt(10));
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
		
		return book;

	}

	@Override
	public Set<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
