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

import org.apache.tomcat.util.codec.binary.Base64;

import com.mysql.jdbc.StringUtils;

import huy.mywebapp.beans.Product;
import huy.mywebapp.service.ProductService;
import huy.mywebapp.utils.MyUtils;

@WebServlet(urlPatterns = {"/detailProduct"})
@MultipartConfig
public class DetailProductServlet extends HttpServlet {

	public static final long serialVersionUID = 1L;
	
	private ProductService service;
	
	public DetailProductServlet() {
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
			product = service.findProduct(conn, id);
			String FI = new String(Base64.encodeBase64(product.getImageData()), "UTF-8");
			String url = "data:image/jpg;base64," + FI;
			product.setBase64Image(FI);
		} catch ( SQLException e ) {
			e.getStackTrace();
			errorString = e.getMessage();
		}
		// Khﾃｴng cﾃｳ l盻擁.
		// S蘯｣n ph蘯ｩm khﾃｴng t盻渡 t蘯｡i ﾄ黛ｻ� edit.
		// Redirect sang trang danh sﾃ｡ch s蘯｣n ph蘯ｩm.
		if( !StringUtils.isNullOrEmpty(errorString) && product == null ) {
			resp.sendRedirect(req.getServletPath() + "/productlist");
			return;
		}
		// Lﾆｰu thﾃｴng tin vﾃ�o request attribute trﾆｰ盻嫩 khi forward sang views.
		
		req.setAttribute("errorString", errorString);
		req.setAttribute("product", product);
	
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/detailProductView.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	// Sau khi ngﾆｰ盻拱 dﾃｹng s盻ｭa ﾄ黛ｻ品 thﾃｴng tin s蘯｣n ph蘯ｩm, vﾃ� nh蘯･n Submit.
	// Phﾆｰﾆ｡ng th盻ｩc nﾃ�y s蘯ｽ ﾄ柁ｰ盻｣c th盻ｱc thi.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		
		String idStr = (String) req.getParameter("id");
		String name = (String) req.getParameter("name");
		String priceStr = (String) req.getParameter("price");
		String imageFileName = (String) req.getParameter("imageFileName");
		Part filePart = req.getPart("imageData"); // Retrieves <input type="file" name="file">
		InputStream inputStream = filePart.getInputStream();
		String nameImage = filePart.getSubmittedFileName();
		BigDecimal price = BigDecimal.ZERO;
		Long id = 0L;
		
		String bestSaler = (String) req.getParameter("bestsaler");
		String type = (String) req.getParameter("type");
		
		try {
			price = new BigDecimal(priceStr);
			id = Long.parseLong(idStr);
		} catch ( Exception e ) {
			e.getStackTrace();
		}
		
		Product product = new Product(id, name, price, imageFileName, null, false , Integer.parseInt(type));
		
		String errorString = null;
		
		try {
			service.updateProduct(conn, product, inputStream, nameImage);
		} catch ( SQLException e ) {
			e.getStackTrace();
			errorString = e.getMessage();
		}
		// Lﾆｰu thﾃｴng tin vﾃ�o request attribute trﾆｰ盻嫩 khi forward sang views.
		req.setAttribute("errorString", errorString);
		req.setAttribute("product", product);
		// N蘯ｿu cﾃｳ l盻擁 forward sang trang edit.
		if( !StringUtils.isNullOrEmpty(errorString) ) {
			RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/editProductView.jsp");
			dispatcher.forward(req, resp);
		} else {
			// N蘯ｿu m盻絞 th盻ｩ t盻奏 ﾄ黛ｺｹp.
			// Redirect sang trang danh sﾃ｡ch s蘯｣n ph蘯ｩm.
			resp.sendRedirect(req.getContextPath() + "/productList");
		}
	
	}
}
