package pojo;

import java.sql.Date;

public class User {

	private int id;
	private String fname,lname,email,password,role;
	private Date dob;
	private boolean status=false;
	
	public User(String fname, String lname, String email, String password, Date dob) {
		
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.dob = dob;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public Date getDob() {
		return dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", role=" + role + ", dob=" + dob + ", status=" + status + "]";
	}
	
	
	

}
