package dao;

import java.util.List;
import model.User;

public interface UserDao {
	List<User> findAllUsers();
	UserDao getUserById(String username);
	UserDao getUserByUserName(String username);
	void addUser(String username,String hash, String salt);
	void changePasswordById(Integer id,String newPassword);
	void deletUserById(Integer id);
}
