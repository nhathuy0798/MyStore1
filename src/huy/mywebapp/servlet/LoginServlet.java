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
	
	//hien thi trang login
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Forward t盻嬖 trang /WEB-INF/views/loginView.jsp
		// (Ngﾆｰ盻拱 dﾃｹng khﾃｴng th盻� truy c蘯ｭp tr盻ｱc ti蘯ｿp
		// vﾃ�o cﾃ｡c trang JSP ﾄ黛ｺｷt trong thﾆｰ m盻･c WEB-INF).
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	// Khi ngﾆｰ盻拱 nh蘯ｭp userName & password, vﾃ� nh蘯･n Submit.
	// Phﾆｰﾆ｡ng th盻ｩc nﾃ�y s蘯ｽ ﾄ柁ｰ盻｣c th盻ｱc thi.
	
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
				//tim user
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
		// Trong trﾆｰ盻拵g h盻｣p cﾃｳ l盻擁,
		// forward (chuy盻ハ hﾆｰ盻嬾g) t盻嬖 /WEB-INF/views/login.jsp	
		if( hasError ) {
			user = new UserAccount();
			user.setUserName(username);
			user.setPassword(password);
			
			// Lﾆｰu cﾃ｡c thﾃｴng tin vﾃ�o request attribute trﾆｰ盻嫩 khi forward.
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			dispatcher.forward(req, resp);
		}
		// Trﾆｰ盻拵g h盻｣p khﾃｴng cﾃｳ l盻擁.
		// Lﾆｰu thﾃｴng tin ngﾆｰ盻拱 dﾃｹng vﾃ�o Session.
		// Vﾃ� chuy盻ハ hﾆｰ盻嬾g sang trang userInfo.
		else {
			HttpSession session = req.getSession();
			MyUtils.storeLoginedUser(session, user);
			
			// N蘯ｿu ngﾆｰ盻拱 dﾃｹng ch盻肱 tﾃｭnh nﾄハg "Remember me".
			if( remember ) {
				MyUtils.storeUserCookie(resp, user);
			}
			// Ngﾆｰ盻｣c l蘯｡i xﾃｳa Cookie
			else {
				MyUtils.deleteUserCookie(resp);
			}
			// Redirect (Chuy盻ハ hﾆｰ盻嬾g) sang trang /userInfo.
			resp.sendRedirect(req.getContextPath() + "/userInfo");
		}	
	}
}
