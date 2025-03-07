package com.shop.cafe.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Product;

@Repository
public class ProductDao {
	
	@Value("${spring.datasource.driver-class-name}")
	String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	String DB_URL;
	
	@Value("${spring.datasource.username}")
	String DB_USER;
	
	@Value("${spring.datasource.password}")
	String DB_PW;

	public  List<Product> getAllProducts() throws Exception{
		System.out.println("ProdutDao getAllProducts() 호출됨");
		Class.forName(DB_DRIVER);
		Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
			PreparedStatement stmt=con.prepareStatement("select * from product limit 6");
			ResultSet rs=stmt.executeQuery();
		
		List<Product> list = new ArrayList<>();
		while(rs.next()) {
			int prodcode = rs.getInt("prodcode");
			String prodname = rs.getString("prodname");
			String pimg = rs.getString("pimg");
			int price = rs.getInt("price");
			
			list.add(new Product(prodname, pimg, prodcode, price));
		}
		
		return list;
	}
}
