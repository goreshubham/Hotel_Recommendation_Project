package Service;

import Models.Login;
import Repository.LoginRepository;

public class LoginService {
	LoginRepository lr=new LoginRepository();
	public boolean logserv(Login l)
	{
		return lr.logrepo(l);
	}
}
