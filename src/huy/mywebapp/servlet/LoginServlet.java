package huy.mywebapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.StringUtils;

import huy.mywebapp.beans.UserAccount;
import huy.mywebapp.service.UserAccountService;
import huy.mywebapp.utils.MyUtils;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserAccountService service;
	
	public LoginServlet() {
		super();
		service = new UserAccountService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("userName");
		String password = req.getParameter("password");
		String rememberMeStr = req.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);
		
		UserAccount user = null;
		boolean hasError = false;
		String errorString = null;
		
		if( StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password) ) {
			hasError = true;
			errorString = "Required username and password";
		} else {
			Connection conn = MyUtils.getStoredConnection(req);
			
			try {
				user = service.findUser(conn, username, password);
				
				if( user == null ) {
					hasError = true;
					errorString = "user or password is incorrect!";
				}
				
			} catch ( SQLException e ) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
			
		}
		if( hasError ) {
			user = new UserAccount();
			user.setUserName(username);
			user.setPassword(password);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			HttpSession session = req.getSession();
			MyUtils.storeLoginedUser(session, user);
			if( remember ) {
				MyUtils.storeUserCookie(resp, user);
			} else {
				MyUtils.deleteUserCookie(resp);
			}
			if( !user.isRole_admin() ){
				resp.sendRedirect(req.getContextPath() + "/");
			} else {
				resp.sendRedirect(req.getContextPath() + "/admin");
			}
		}	
	}
}
