package service;

public class UserService {

	public boolean authenticateAddUser(String username, String password, String email) {

		if (password == null || password.trim() == "") {
			return false;
		}
		if (username == null || username.trim() == "") {
			return false;
		}
		if (email == null || email.trim() == "") {
			return false;
		}
		return true;
	}

}
