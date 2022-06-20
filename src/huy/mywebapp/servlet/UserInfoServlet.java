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

@WebServlet(urlPatterns = {"/userInfo"})
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserInfoServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		// Ki盻ノ tra ngﾆｰ盻拱 dﾃｹng ﾄ妥｣ ﾄ惰ハg nh蘯ｭp (login) chﾆｰa.
		UserAccount loginUser = MyUtils.getLoginedUser(session);
		
		// N蘯ｿu chﾆｰa ﾄ惰ハg nh蘯ｭp (login).
		if( loginUser == null ) {
			// Redirect (Chuy盻ハ hﾆｰ盻嬾g) t盻嬖 trang login.
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		// Lﾆｰu thﾃｴng tin vﾃ�o request attribute trﾆｰ盻嫩 khi forward (chuy盻ハ ti蘯ｿp).
		req.setAttribute("user", loginUser);
		// N蘯ｿu ngﾆｰ盻拱 dﾃｹng ﾄ妥｣ login thﾃｬ forward (chuy盻ハ ti蘯ｿp) t盻嬖 trang
		// /WEB-INF/views/userInfoView.jsp
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	
}
