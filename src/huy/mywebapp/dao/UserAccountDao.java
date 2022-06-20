package huy.mywebapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import huy.mywebapp.beans.UserAccount;

public class UserAccountDao {
	public UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender,a.role_admin from User_Account a " //
				+ " where a.User_Name = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String gender = rs.getString("Gender");
			int roleAdmin = rs.getInt("role_admin");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			if(roleAdmin == 1){
				user.setRole_admin(true);
			} else{
				user.setRole_admin(false);
			}
			return user;
		}
		return null;
	}

	public UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender, a.role_admin from User_Account a "//
				+ " where a.User_Name = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			int roleAdmin = rs.getInt("role_admin");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			user.setRole_admin(Boolean.parseBoolean(String.valueOf(roleAdmin)));
			return user;
		}
		return null;
	}

	
	public void insertUser(Connection conn, UserAccount user) throws SQLException {
		String sql = "Insert into user_account(user_name, gender,password, role_admin) values (?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getUserName());
		pstm.setString(2, user.getGender());
		pstm.setString(3, user.getPassword());
		pstm.setInt(4,    user.isRole_admin() ? 1 : 0);
		
		pstm.executeUpdate();
	}
}
