package com.lti.servlet;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import com.lti.login.*;

@WebServlet("/Login.lti")
public class LoginServlet extends HttpServlet {
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserService userService=new UserService();
		boolean isValid = userService.isValidUser(username,password);
		if(isValid){
			//checking if remember me option was selected

			 Base64.Encoder enc = Base64.getEncoder();
			 String encoded = enc.encodeToString(password.getBytes());
			 
			String rememberMe=request.getParameter("rememberMe");
			if(rememberMe!=null && rememberMe.equals("yes")){
				Cookie c1=new Cookie( username,encoded);
				c1.setMaxAge(60 * 60);
				Cookie c2=new Cookie("pass", Base64.getEncoder().encodeToString(password.getBytes()));
				c2.setMaxAge(60 * 60);
				response.addCookie(c1);
				response.addCookie(c2);
				
			        System.out.println("encoded value is \t" + encoded);

			}
			response.sendRedirect("Welcome.html");
			
		}
		else
			response.sendRedirect("login.html");
	}

	
	

}
