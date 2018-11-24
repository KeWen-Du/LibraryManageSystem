package model;

import java.util.Set;
import model.MySqlConnection;
public interface UserDAO {
	public int addUser(User user) ;
	
	public int deleteUser(String UserID);
	
	public int updateUser(User user);
	
	public User findUser(String UserID);
	
	public Set<User> findAll();

}
