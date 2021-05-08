package core.concretes;

import core.abstracts.RegisterService;
import entities.concretes.User;
import google.GoogleManager;
import google.UserForGoogle;

public class GoogleManagerAdapter implements RegisterService{

	@Override
	public User register(String email, String password) {
		GoogleManager googleManager = new GoogleManager();
		UserForGoogle userForGoogle = googleManager.register(email, password);
		User user = new User(userForGoogle.getFirstName(),
				userForGoogle.getLastName(), userForGoogle.getEmail(),
				userForGoogle.getPassword());
		return user;
	}

}
