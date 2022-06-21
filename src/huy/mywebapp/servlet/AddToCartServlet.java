package huy.mywebapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import huy.mywebapp.beans.Item;
import huy.mywebapp.beans.Order;
import huy.mywebapp.beans.Product;
import huy.mywebapp.service.ProductService;
import huy.mywebapp.utils.MyUtils;

@WebServlet(urlPatterns = { "/addtoCart" })
public class AddToCartServlet extends HttpServlet {
	private ProductService productService;
	
	@Override
	public void init() throws ServletException {
		productService = new ProductService();
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int quantity = 1;
		int id;
		Connection conn = MyUtils.getStoredConnection(req);
		if( req.getParameter("id") != null ){
			id = Integer.parseInt(req.getParameter("id"));
			try {
				Product product = productService.findProduct(conn, (long)id);
				
				if( product != null ){
					if( req.getParameter("quantity") != null){
						quantity = Integer.parseInt(req.getParameter("id"));
					}
					HttpSession session = req.getSession();
					
					if( session.getAttribute("order")==null ){
						Order order = new Order();
						List<Item> listItems = new ArrayList<Item>();
						Item item = new Item();
						item.setQuantity(quantity);
						item.setProduct(product);
						item.setPrice(product.getPrice());
						listItems.add(item);
						order.setItems(listItems);
						session.setAttribute("order", order);
					} else {
						Order order = (Order) session.getAttribute("order");
						List<Item> listItems = order.getItems();
						boolean check = false;
						for( Item item : listItems ){
							if( item.getProduct().getId() == product.getId() ){
								item.setQuantity(item.getQuantity() + quantity );
								check = true;
							}
						}
						
						if( !check ){
							Item item = new Item();
							item.setQuantity(quantity);
							item.setProduct(product);
							item.setPrice(product.getPrice());
							listItems.add(item);
						}
						session.setAttribute("order", order);
					}
				}
				String page = "";
				if( req.getParameter("page") != null ){
					page = req.getParameter("page");
				}
				resp.sendRedirect(req.getContextPath()+"/" + page);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		} else {
			resp.sendRedirect(req.getContextPath()+"/");
		}
	}
}
