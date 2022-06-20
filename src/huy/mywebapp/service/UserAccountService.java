package huy.mywebapp.service;

import java.sql.Connection;
import java.sql.SQLException;

import huy.mywebapp.beans.UserAccount;
import huy.mywebapp.dao.UserAccountDao;

public class UserAccountService {
	
	private UserAccountDao dao;
	public UserAccountService() {
		dao = new UserAccountDao();
	}
	
	public UserAccount findUser( Connection conn, //
			String userName, String password) throws SQLException {
		return dao.findUser(conn, userName, password);
	}
	
	public UserAccount findUser( Connection conn, //
			String userName) throws SQLException {
		return dao.findUser(conn, userName);
	}
	
	public void insertUser(Connection conn, UserAccount user) throws SQLException {
		dao.insertUser(conn, user);
	}
}
