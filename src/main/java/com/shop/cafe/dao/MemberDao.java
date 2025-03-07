package com.shop.cafe.dao;

import java.sql.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.shop.cafe.dto.Member;
import com.shop.cafe.dto.Product;

@Repository
public class MemberDao {
	
	@Value("${spring.datasource.driver-class-name}")
	String DB_DRIVER;
	
	@Value("${spring.datasource.url}")
	String DB_URL;
	
	@Value("${spring.datasource.username}")
	String DB_USER;
	
	@Value("${spring.datasource.password}")
	String DB_PW;

	public  void inserMember(Member m) throws Exception{
		System.out.println("ProdutDao inserMember() 호출됨");
		Class.forName(DB_DRIVER);
		Connection con=DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
		PreparedStatement stmt=con.prepareStatement("insert into member(email, pwd, nickname) values(?,?,?)");
		stmt.setString(1, m.getEmail());
		stmt.setString(2, m.getPwd());
		stmt.setString(3, m.getNickname());
		int i=stmt.executeUpdate();
		
		System.out.println(i+"행이 insert됨");

	}
}
