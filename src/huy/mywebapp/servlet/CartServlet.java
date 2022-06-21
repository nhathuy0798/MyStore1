package huy.mywebapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import huy.mywebapp.beans.Item;
import huy.mywebapp.beans.Order;
import huy.mywebapp.service.ProductService;

@WebServlet(urlPatterns = { "/cart"})
public class CartServlet extends HttpServlet {

	private ProductService service;
	@Override
	public void init() throws ServletException {
		service = new ProductService();
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if( req.getSession().getAttribute("order") != null ){
			Order order = (Order) req.getSession().getAttribute("order");
			List<Item> listItems = order.getItems();
			req.setAttribute("listItems", listItems);
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/cartView.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		super.doPost(req, resp);
	}
}

