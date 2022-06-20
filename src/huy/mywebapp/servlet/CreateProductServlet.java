package huy.mywebapp.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.jdbc.StringUtils;

import huy.mywebapp.beans.Product;
import huy.mywebapp.service.ProductService;
import huy.mywebapp.utils.MyUtils;

@WebServlet(urlPatterns = {"/createProduct"})
@MultipartConfig
public class CreateProductServlet extends HttpServlet {

	public static final long serialVersionUID = 1L;
	private ProductService service;
	public CreateProductServlet() {
		super();
		service = new ProductService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
			dispatcher.forward(req, resp);
	}
	
	// Khi ngﾆｰ盻拱 dﾃｹng nh蘯ｭp cﾃ｡c thﾃｴng tin s蘯｣n ph蘯ｩm, vﾃ� nh蘯･n Submit.
	// Phﾆｰﾆ｡ng th盻ｩc nﾃ�y s蘯ｽ ﾄ柁ｰ盻｣c g盻絞.
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		String idStr = (String) req.getParameter("id");
		String imageName = (String) req.getParameter("name");
		String priceStr = (String) req.getParameter("price");
		String bestSalerStr = req.getParameter("bestSaler");
		boolean bestSaler = "Y".equals(bestSalerStr);
		String type = (String) req.getParameter("type");
		Long id = 0L;
		BigDecimal price = BigDecimal.ZERO;
		try {
			price = new BigDecimal(priceStr);
			id = Long.parseLong(idStr);
		} catch ( Exception e ) {
			e.getStackTrace();
		}
		
		String imageFileName = (String) req.getParameter("imageFileName"); 	
		Part filePart = req.getPart("imageData"); // Retrieves <input type="file" name="file">
		InputStream inputStream = filePart.getInputStream();
		Product product = new Product( id, imageName, price, imageFileName, null,bestSaler, Integer.parseInt(type));
		
		String errorString = null;
		
		if( errorString == null ) {
			try {
				service.insertProduct(conn, product, inputStream);
			} catch ( SQLException e ) {
				e.getStackTrace();
				errorString = e.getMessage();
			}
		}
		
		// Lﾆｰu thﾃｴng tin vﾃ�o request attribute trﾆｰ盻嫩 khi forward sang views.
		req.setAttribute("errorString", errorString);
		req.setAttribute("product", product);
		
		// N蘯ｿu cﾃｳ l盻擁 thﾃｬ foward sang trang edit
		if( !StringUtils.isNullOrEmpty(errorString) ) {
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
			dispatcher.forward(req, resp);
		}
		// Redirect (chuy盻ハ hﾆｰ盻嬾g) sang trang danh sﾃ｡ch s蘯｣n ph蘯ｩm.
		else {
			resp.sendRedirect(req.getContextPath() + "/productList");
		}
	}
}
