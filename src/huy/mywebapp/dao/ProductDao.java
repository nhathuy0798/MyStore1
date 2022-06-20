package huy.mywebapp.dao;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import huy.mywebapp.beans.Product;
import huy.mywebapp.beans.ProductFilterCondition;

public class ProductDao {
	public List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.Id, a.Name, a.Price, a.Image_Data, a.Image_File_Name, a.bestsaler, a.type  from Product a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			Long id = rs.getLong("Id");
			String name = rs.getString("Name");
			BigDecimal price = rs.getBigDecimal("Price");
			byte[] image_Data = rs.getBytes("Image_Data");
			String image_File_Name = rs.getString("Image_File_Name");
			boolean isBestSaler = rs.getInt("BestSaler") == 1? true : false ;
			int type = rs.getInt("Type");
			Product item = new Product(id, name, price, image_File_Name, image_Data, isBestSaler, type);
			list.add(item);
		}
		return list;
	}
	
	public List<Product> queryProduct(Connection conn, ProductFilterCondition condition) throws SQLException {
		StringBuffer sb = new StringBuffer();
		String sqlBase = "Select a.Id, a.Name, a.Price, a.Image_Data, a.Image_File_Name, a.bestsaler, a.type  from Product a ";
		sb.append(sqlBase);
		sb.append(getWhereBlock(condition));
		
		PreparedStatement pstm = conn.prepareStatement(sb.toString());

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			Long id = rs.getLong("Id");
			String name = rs.getString("Name");
			BigDecimal price = rs.getBigDecimal("Price");
			byte[] image_Data = rs.getBytes("Image_Data");
			String image_File_Name = rs.getString("Image_File_Name");
			boolean isBestSaler = rs.getInt("BestSaler") == 1? true : false ;
			int type = rs.getInt("Type");
			Product item = new Product(id, name, price, image_File_Name, image_Data, isBestSaler, type);
			list.add(item);
		}
		return list;
	}
	
	public List<Product> queryProductBestSaler(Connection conn) throws SQLException {
		String sql = "Select a.Id, a.Name, a.Price, a.Image_Data, a.Image_File_Name, a.bestsaler, a.type  from Product a where a.bestsaler = 1 ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			Long id = rs.getLong("Id");
			String name = rs.getString("Name");
			BigDecimal price = rs.getBigDecimal("Price");
			byte[] image_Data = rs.getBytes("Image_Data");
			String image_File_Name = rs.getString("Image_File_Name");
			boolean isBestSaler = rs.getInt("BestSaler") == 1? true : false ;
			int type = rs.getInt("Type");
			Product item = new Product(id, name, price, image_File_Name, image_Data, isBestSaler, type);
			list.add(item);
		}
		return list;
	}

	public Product findProduct(Connection conn, Long id) throws SQLException {
		String sql = "Select a.Id, a.Name, a.Price, a.Image_Data, a.Image_File_Name, a.BestSaler, a.Type from Product a where a.Id=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setLong(1, id);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("Name");
			BigDecimal price = rs.getBigDecimal("Price");
			byte[] imageData = rs.getBytes("Image_Data");
			String imageFileName = rs.getString("Image_File_Name");
			boolean isBestSaler = rs.getInt("BestSaler") == 1? true : false ;
			int type = rs.getInt("Type");
			Product item = new Product(id, name, price, imageFileName, imageData, isBestSaler, type);
			return item;
		}
		return null;
	}

	public void updateProduct(Connection conn, Product item, InputStream fin, String name) throws SQLException {
		String sql = "Update Product set Name =?, Price=?, Image_Data=? , Image_File_Name=?, BestSaler=?, Type=? where Id=? ";
		String sql2 = "Update Product set Name =?, Price=?, Image_File_Name=?, BestSaler=?, Type=? where Id=? ";
		PreparedStatement pstm = null;
		if (!StringUtils.isNullOrEmpty(name)) {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, item.getName());
			pstm.setBigDecimal(2, item.getPrice());
			pstm.setBlob(3, fin);
			pstm.setString(4, item.getImageFileName());
			pstm.setInt(5, item.isBestSaler()? 1:0);
			pstm.setInt(6, item.getType());
			pstm.setLong(7, item.getId());
			
		} else {
			pstm = conn.prepareStatement(sql2);
			pstm.setString(1, item.getName());
			pstm.setBigDecimal(2, item.getPrice());
			pstm.setString(3, item.getImageFileName());
			pstm.setInt(4, item.isBestSaler()? 1:0);
			pstm.setInt(5, item.getType());
			pstm.setLong(6, item.getId());
		}
		pstm.executeUpdate();
	}

	public void insertProduct(Connection conn, Product item, InputStream fin) throws SQLException {
		String sql = "Insert into Product(Id, Name,Price,Image_Data,Image_File_Name, BestSaler, Type) values (?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setLong(1, item.getId());
		pstm.setString(2, item.getName());
		pstm.setBigDecimal(3, item.getPrice());
		pstm.setBlob(4, fin);
		pstm.setString(5, item.getImageFileName());
		pstm.setInt(6, item.isBestSaler()? 1:0);
		pstm.setInt(7, item.getType());
		pstm.executeUpdate();
	}

	public void deleteProduct(Connection conn, Long id) throws SQLException {
		String sql = "Delete From Product where Id= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setLong(1, id);

		pstm.executeUpdate();
	}
	
	private String getWhereBlock( ProductFilterCondition condition){
		StringBuffer sb = new StringBuffer();
		sb.append("WHERE 1=1 ");
		sb.append(!StringUtils.isNullOrEmpty(condition.getName())? " AND a.Name LIKE '%"+condition.getName()+"%'" : "");
		sb.append(condition.getType() !=0 ? " AND a.Type = "+condition.getType() : "");
		sb.append(" AND a.Price BETWEEN " + condition.getMin() + " AND " + condition.getMax() ); 
		sb.append(condition.isBestSaler() ? " AND a.BestSaler = " + String.valueOf(condition.isBestSaler()) : "" );
		return sb.toString();
	}
}
