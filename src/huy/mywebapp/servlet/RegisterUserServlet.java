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

@WebServlet(urlPatterns = {"/register"})
public class RegisterUserServlet extends HttpServlet {

	public static final long serialVersionUID = 1L;
	private UserAccountService service;
	
	public RegisterUserServlet() {
		super();
		service = new UserAccountService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			UserAccount loginUser = MyUtils.getLoginedUser(session);	
			if(loginUser != null){
				if(loginUser.isRole_admin()){
					req.setAttribute("userLogined", loginUser);
				}
			}
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/registerUserView.jsp");
			dispatcher.forward(req, resp);
	}
	
	// Khi ngﾆｰ盻拱 dﾃｹng nh蘯ｭp cﾃ｡c thﾃｴng tin ﾄ惰ハg kﾃｽ, vﾃ� nh蘯･n Submit.
	// Phﾆｰﾆ｡ng th盻ｩc nﾃ�y s蘯ｽ ﾄ柁ｰ盻｣c g盻絞.
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		
		String username = (String) req.getParameter("user_name");
		String gender = (String) req.getParameter("gender");
		String password = (String) req.getParameter("password");
		String roleAdminStr = req.getParameter("role_admin");
		boolean roleAdmin = "Y".equals(roleAdminStr);
		
		UserAccount user = new UserAccount();
		user.setUserName(username);
		user.setGender(gender);
		user.setPassword(password);
		user.setRole_admin(roleAdmin);
		String errorString = null;

		try {
			service.insertUser(conn, user);
		} catch ( SQLException e ) {
			e.getStackTrace();
			errorString = e.getMessage();
		}
		
		// Lﾆｰu thﾃｴng tin vﾃ�o request attribute trﾆｰ盻嫩 khi forward sang views.
		req.setAttribute("errorString", errorString);
		req.setAttribute("user", user);
		
		// N蘯ｿu cﾃｳ l盻擁 thﾃｬ foward sang trang edit
		if( !StringUtils.isNullOrEmpty(errorString) ) {
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/registerUserView.jsp");
			dispatcher.forward(req, resp);
		}
		// Redirect (chuy盻ハ hﾆｰ盻嬾g) sang trang danh sﾃ｡ch s蘯｣n ph蘯ｩm.
		else {
			resp.sendRedirect(req.getContextPath() + "/home");			
		}
	}
}
