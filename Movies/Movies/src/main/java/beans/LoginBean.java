package beans;

import daos.UserDao;
import daos.UsersDaoImpl;
import pojos.Users;

public class LoginBean {
	private String email;
	private String password;
	private boolean status;
	public LoginBean()
	{
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getStatus() {
				return status;
			}
			public void setStatus(boolean status) {
				this.status = status;
			}
	public void authenticate()
	{
		try(UserDao userDao=new UsersDaoImpl())
		{
			Users user=userDao.findByEmail(email);
			if(user!=null && user.getPassword().equals(password))
			{
								status = true;

			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
