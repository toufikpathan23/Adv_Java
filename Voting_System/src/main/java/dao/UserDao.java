package dao;

import java.sql.Date;
import java.sql.SQLException;

import pojo.User;

public interface UserDao {

	String registerUser(String first_name,String last_name,String email,String password,Date dob) throws SQLException;
}
