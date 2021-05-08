package core.abstracts;

import entities.concretes.User;

public interface RegisterService {
	User register(String email, String password);
}
