package beans;

import daos.UserDao;
import daos.UsersDaoImpl;
import pojos.Users;

public class RegisterBean {
	String fname;
	String lname;
	String email;
	String password;
	String mobile;
	String birth;
	boolean status;

	public RegisterBean() {

	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void saveUser() {
		try (UserDao udao = new UsersDaoImpl()) {
			Users u = new Users();
			u.setFirstName(fname);
			u.setLastName(lname);
			u.setEmail(email);
			u.setPassword(password);
			u.setMobileNo(Long.parseLong(mobile));
			u.setDob(birth);

			System.out.println(u);
			int cnt = udao.save(u);

			status = (cnt != 0);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}