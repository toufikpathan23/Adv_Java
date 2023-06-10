package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import pojo.User;

import static utils.DbUtils.*;
public class UserDaoImp implements UserDao {

	private Connection cn;
	private PreparedStatement pst;
	
	public UserDaoImp() throws SQLException 
	{
		// id | first_name | last_name | email             | password | dob        | status | role
		cn=openConnection();
		pst=cn.prepareStatement("insert into users(first_name,last_name,email,password,dob,status,role) values(?,?,?,?,?,?,?)");
	}
	
	
	@Override
	public String registerUser(String first_name,String last_name,String email,String password,Date dob) throws SQLException
	{
		pst.setString(1, first_name);
		pst.setString(2, last_name);
		pst.setString(3, email);
		pst.setString(4, password);
		if(Period.between(dob.toLocalDate(),LocalDate.now()).getYears()>21)
		pst.setDate(5, dob);
		else
			return "User age is below 21";
		pst.setInt(6,0);
		pst.setString(7, "voter");
		
		int insertCount=pst.executeUpdate();
		
		if(insertCount==1)
		{
			return "User Registered Successfully....";
		}else
			return "User Could not registered successfully";
			
	}
}
