package com.teembinsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teembinsys.Mailer;


public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      PrintWriter out = response.getWriter();
	      System.out.println(out);
	      String connectionURL = "jdbc:oracle:thin:@localhost:1521/orcl";
	      Connection connection=null;
	      Statement s=null;
	      ResultSet rs=null;
	      String user=request.getParameter("user");
	      System.out.println(user);
	      response.setContentType("text/html");
	      int count=0;
	      String uname="";
	      String passwd="";
	      String email="";
	      System.out.println(count);
	      try {
	     // Load the database driver
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      // Get a Connection to the database
	      connection = DriverManager.getConnection(connectionURL, "scott", "a5newdelhi"); 
	      //Add the data into the database
	         s = connection.createStatement();
	         
	         String QueryString = "select username, password, email from signin where username='"+user.trim()+"'";
	         System.out.println("Before executeQuery");
	         rs = s.executeQuery(QueryString);
	         System.out.println("After executeQuery");
	         System.out.println("SQL statement: "+QueryString);
	         
	          
	         
	      if(rs.next ()){//Use If Here not While
	         uname=(String)rs.getString(1);
	         passwd=(String)rs.getString(2);
	         email=(String)rs.getString(3);
	        
	         System.out.println("User: "+uname);
	         System.out.println("Password: "+passwd);
	         System.out.println("Email address: " +email);
	         
	        //request.setAttribute("user",rs.getString(1));
	        //request.setAttribute("password",rs.getString(2));
	          }

	         
	         Mailer.send(email, uname, passwd, "User Credential information", "Username : " + uname +"    Password: "+passwd);  
	         out.print("message has been sent successfully");  
	         //out.close();
	         //RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/Login.jsp" );

	         
	                   
	      rs.close();
	      s.close();
	      RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/Login.jsp" );
	      dispatcher.forward( request, response );
	      }
	      catch(SQLException e){
	    	  e.printStackTrace();
	      System.out.println("Exception is ;"+e);
	      } 
	      catch (ClassNotFoundException e) {
	          System.out.println("Exception is ;"+e);
	    }
   }
}
