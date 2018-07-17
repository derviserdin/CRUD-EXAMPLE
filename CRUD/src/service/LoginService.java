package service;

public class LoginService {

	public boolean authenticate(String userName, String password) {

		if (password == null || password.trim() == "") {
			return false;
		}
		if (userName == null || userName.trim() == "") {
			return false;
		}
		return true;
	}

}
