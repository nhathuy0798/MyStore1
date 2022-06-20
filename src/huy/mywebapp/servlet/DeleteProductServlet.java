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

import com.mysql.jdbc.StringUtils;

import huy.mywebapp.beans.Product;
import huy.mywebapp.service.ProductService;
import huy.mywebapp.utils.MyUtils;

@WebServlet(urlPatterns = {"/deleteProduct"})
public class DeleteProductServlet extends HttpServlet {

	public static final long serialVersionUID = 1L;
	
	private ProductService service;
	public DeleteProductServlet() {
		super();
		service = new ProductService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection conn = MyUtils.getStoredConnection(req);
		
		String idStr = (String) req.getParameter("id");
		
		Product product = null;
		
		String errorString = null;
		Long id = 0L;
		try {
			id = Long.parseLong(idStr);
			service.deleteProduct(conn, id);
		} catch ( SQLException e ) {
			e.getStackTrace();
			errorString = e.getMessage();
		}
		// Nếu có lỗi, forward (chuyển tiếp) sang trang thông báo lỗi.

		if( !StringUtils.isNullOrEmpty(errorString) ) {
			req.setAttribute("errorString", errorString);	
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/deleteProductErrorView.jsp");
			dispatcher.forward(req, resp);
		} else {
		// OK Redirect ve trang Productlist
			resp.sendRedirect(req.getContextPath() + "/productList");
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);	
	}
}
