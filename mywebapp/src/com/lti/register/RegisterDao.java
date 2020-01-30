package com.lti.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.RegisterM;

//data access object
//classes which contain database interaction
//code in java are commonly referred to as DAO class
public class RegisterDao {
	public boolean insert(RegisterM rm){
				
				Connection conn = null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					String user = "hr";
					String pass = "hr";
					
					conn=DriverManager.getConnection(url,user,pass);
					
					String sql = "insert into tbl_reg values(?,?,?,?)";
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, rm.getName());
					st.setString(2, rm.getEmail());
					st.setString(3, rm.getPass());
					st.setString(4, rm.getCity());
					st.executeUpdate();
					
					return true;
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
					return false;
				}
				finally{
					try{
						conn.close();
					}
					catch(Exception e){

					}
				}
			}


}
