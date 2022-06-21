package huy.mywebapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import huy.mywebapp.beans.UserAccount;
import huy.mywebapp.utils.MyUtils;

@WebServlet(urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public AdminServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		UserAccount loginUser = MyUtils.getLoginedUser(session);
		if( loginUser == null ) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		req.setAttribute("loginedUser", loginUser);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminView.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	
}
