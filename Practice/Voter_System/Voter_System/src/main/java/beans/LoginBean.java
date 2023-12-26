package beans;

import daos.UserDao;
import daos.UserDaoImpl;
import pojos.User;

public class LoginBean {
	private String email;
	private String passwd;
	private User user;
	public LoginBean() {
		this.user = null;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void authenticate() {
		try(UserDao userDao = new UserDaoImpl()) {
			User u = userDao.findByEmail(email);
			if(u != null && u.getPassword().equals(passwd))
				this.user = u;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
