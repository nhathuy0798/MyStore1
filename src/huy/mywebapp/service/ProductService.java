package huy.mywebapp.service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import huy.mywebapp.beans.Product;
import huy.mywebapp.beans.ProductFilterCondition;
import huy.mywebapp.dao.ProductDao;

public class ProductService {
	
	private ProductDao dao;
	
	public ProductService() {
		dao = new ProductDao();
	}
	
	public List<Product> queryProduct(Connection conn) throws SQLException {
		return dao.queryProduct(conn);
	}
	
	public List<Product> queryProduct(Connection conn, ProductFilterCondition condition) throws SQLException {
		return dao.queryProduct(conn, condition);
	}
	
	public List<Product> queryProductBestSaler(Connection conn) throws SQLException {
		return dao.queryProductBestSaler(conn);
	}
	
	public Product findProduct(Connection conn, Long id) throws SQLException {
		return dao.findProduct(conn, id);
	}
	
	public void updateProduct(Connection conn, Product item, InputStream fin, String name) throws SQLException {
		dao.updateProduct(conn, item, fin, name);
	}
	
	public void insertProduct(Connection conn, Product item, InputStream fin) throws SQLException {
		dao.insertProduct(conn, item, fin);
	}
	
	public void deleteProduct(Connection conn, Long id) throws SQLException {
		dao.deleteProduct(conn, id);
	}
}
