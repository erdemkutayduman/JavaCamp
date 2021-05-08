package business.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserService {

	boolean add(User user);
	void update(User user);
	void delete(User user);
	User getById(int id);
	List<User> getall();
	User getByEmail(String email);
	
}
