package model;

import java.util.Set;

public interface BookDAO {
	public int addBook(Book book) ;
	
	public int deleteBook(String BookID);
	
	public int updateBook(Book Book);
	
	public Book findBook(String BookID);
	
	public Set<Book> findAll();
}
