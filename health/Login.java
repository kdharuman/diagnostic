package com.teembinsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String connectionURL = "jdbc:oracle:thin:@localhost:1521/orcl";
	      Connection connection=null;
	      Statement stmt=null;
	      ResultSet rs=null;
	      String user=request.getParameter("user");
	      String login_status="Failure";
	      String password=request.getParameter("password");
	      String user_type=request.getParameter("usergroup");
	      
	      String username = "";
	      String passwd = "";
	      String usertype = "";
	      
	      response.setContentType("text/html");

	      try {
	     // Load the database driver
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      // Get a Connection to the database
	      connection = DriverManager.getConnection(connectionURL, "scott", "a5newdelhi"); 
	      //Add the data into the database
	         stmt = connection.createStatement();
	         String sql = "select username,password,usertype from signin where username='"+user.trim()+"'";
	         rs = stmt.executeQuery(sql);
	         
		    if(rs.next ())
		    {//Use If Here not While
				request.setAttribute("user", rs.getString(1));
				request.setAttribute("password", rs.getString(2));
				request.setAttribute("user_type", rs.getString(3));
				username = rs.getString(1);
				passwd = rs.getString(2);
				usertype = rs.getString(3);

				if (user.equals(username) && password.equals(passwd) && user_type.equals(usertype)) 
				{
					System.out.println("Login Successful");
					login_status="Success";
					
				}
	    	}
	      
		  if (login_status.equals("Success") && user_type.equals("normaluser"))
		  {
			  rs.close();
			  stmt.close();
			  RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/Dashboard.jsp" );
			  dispatcher.forward( request, response );
	      }
		  else if (login_status.equals("Success") && user_type.equals("administrator"))
		  {
			  rs.close();
			  stmt.close();
			  RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/Administrator.jsp" );
			  dispatcher.forward( request, response );			  
		  }
		  else if (login_status.equals("Failure"))
		  {
			  rs.close();
			  stmt.close();
			  
			  RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/Login.jsp" );
			  dispatcher.forward( request, response );
		  }
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
