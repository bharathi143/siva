package com.lti.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.lti.model.RegisterM;

public class SearchDao {
	public List<RegisterM> select(String city){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String pass="hr";
			
			conn=DriverManager.getConnection(url, user, pass);
			
			String sql= "select * from tbl_reg where city = ?";
			PreparedStatement st1= conn.prepareStatement(sql);
			st1.setString(1, city);
			ResultSet rs = st1.executeQuery();
			
			List<RegisterM> list = new ArrayList<>();
			
			while(rs.next()) {
				RegisterM m = new RegisterM();
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setPass(rs.getString("password"));
				m.setCity(rs.getString("city"));
				list.add(m);
			}
			
			return list;
			   
		} catch (ClassNotFoundException | SQLException e) {
	
		       e.printStackTrace(); //actually we should check what the error is
		      return null;         //instead we should throw user defined exception
		}
		finally {
			try { conn.close(); }
			catch(Exception e) { }
				
			}
	}
}
