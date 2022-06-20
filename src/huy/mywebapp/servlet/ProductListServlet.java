package huy.mywebapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import huy.mywebapp.beans.Product;
import huy.mywebapp.beans.ProductFilterCondition;
import huy.mywebapp.beans.UserAccount;
import huy.mywebapp.service.ProductService;
import huy.mywebapp.utils.MyUtils;

@WebServlet(urlPatterns = {"/productList"})
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService service;
	public ProductListServlet() {
		super();
		service = new ProductService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		
		String errorString = null;
		List<Product> list = null;
		try {
			list = service.queryProduct(conn);
		} catch( SQLException e ) {
			e.getStackTrace();
			errorString = e.getMessage();
		}
		if( list.size() > 0 ) {
			for( int i = 0 ; i < list.size() ; i++ ) {
			  Product product = list.get(i);
				  String FI = new String(Base64.encodeBase64(product.getImageData()), "UTF-8");
				  String url = "data:image/jpg;base64," + FI;
//				  System.out.print(url);
				  product.setBase64Image(FI);
			}
		}
		UserAccount loginUser = MyUtils.getLoginedUser(req.getSession());	
		if(loginUser != null){
			if(loginUser.isRole_admin()){
				req.setAttribute("userLogined", loginUser);
			}
		}
		// L�ｾ��ｽｰu th�ｾ�ｽｴng tin v�ｾ�ｿｽo request attribute tr�ｾ��ｽｰ逶ｻ雖ｩ khi forward sang views.
		req.setAttribute("errorString", errorString);
		req.setAttribute("productList", list);
		req.setAttribute("productCount", list.size());

		// Forward sang /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/productListView.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = (String) req.getParameter("name");
		int type = Integer.valueOf(req.getParameter("type"));
		int min =  Integer.valueOf(req.getParameter("priceMin"));
		int max =  Integer.valueOf(req.getParameter("priceMax"));
		String bestSalerStr = req.getParameter("bestSaler");
		boolean bestSaler = "Y".equals(bestSalerStr);
		ProductFilterCondition condition = new ProductFilterCondition(name, type, min, max, bestSaler);
		
		doGetFilter(req, resp, condition);
	}
	
	protected void doGetFilter(HttpServletRequest req, HttpServletResponse resp, ProductFilterCondition condition) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		
		String errorString = null;
		List<Product> list = null;
		try {
			list = service.queryProduct(conn, condition);
		} catch( SQLException e ) {
			e.getStackTrace();
			errorString = e.getMessage();
		}
		if( list.size() > 0 ) {
			for( int i = 0 ; i < list.size() ; i++ ) {
			  Product product = list.get(i);
				  String FI = new String(Base64.encodeBase64(product.getImageData()), "UTF-8");
				  String url = "data:image/jpg;base64," + FI;
//				  System.out.print(url);
				  product.setBase64Image(FI);
			}
		}
		UserAccount loginUser = MyUtils.getLoginedUser(req.getSession());	
		if(loginUser != null){
			if(loginUser.isRole_admin()){
				req.setAttribute("userLogined", loginUser);
			}
		}
		// L�ｾ��ｽｰu th�ｾ�ｽｴng tin v�ｾ�ｿｽo request attribute tr�ｾ��ｽｰ逶ｻ雖ｩ khi forward sang views.
		req.setAttribute("errorString", errorString);
		req.setAttribute("productList", list);
		req.setAttribute("condition", condition);
		req.setAttribute("productCount", list.size());
		// Forward sang /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/productListView.jsp");
		dispatcher.forward(req, resp);
	}
}
