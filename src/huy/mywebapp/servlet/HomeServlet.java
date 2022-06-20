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
import huy.mywebapp.beans.UserAccount;
import huy.mywebapp.service.ProductService;
import huy.mywebapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/home"})
public class HomeServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   private ProductService service;
   public HomeServlet() {
       super();
       service = new ProductService();
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {

	   Connection conn = MyUtils.getStoredConnection(req);
		
		String errorString = null;
		List<Product> list = null;
		try {
			list = service.queryProductBestSaler(conn);
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
		req.setAttribute("productListBestSaler", list);
		req.setAttribute("productCount", list.size());

       // Forward toi trang /WEB-INF/views/homeView.jsp
       // (Ngﾆｰ盻拱 dﾃｹng khﾃｴng bao gi盻� truy c蘯ｭp tr盻ｱc ti蘯ｿp ﾄ柁ｰ盻｣c vﾃ�o cﾃ｡c trang JSP
       // ﾄ黛ｺｷt trong WEB-INF)
       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
       
       dispatcher.forward(req, resp);       
   }

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request, response);
   }

}
