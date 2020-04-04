package com.teembinsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      PrintWriter out = response.getWriter();
	      System.out.println(out);
	      String connectionURL = "jdbc:oracle:thin:@localhost:1521/orcl";
	      Connection connection=null;
	      Statement s=null;
	      ResultSet rs=null;
	      String firstname=request.getParameter("firstname");
	      String middlename=request.getParameter("middlename");
	      String lastname=request.getParameter("lastname");
	      String gender=request.getParameter("gender");
	      String mobilenumber=request.getParameter("mobilenumber");
	      String olandline=request.getParameter("olandline");
	      String hlandline=request.getParameter("hlandline");
	      String caddress=request.getParameter("caddress");
	      String email=request.getParameter("email");
	      String organization=request.getParameter("organization");
	      String designation=request.getParameter("designation");
	      String oaddress=request.getParameter("oaddress");
	      String username=request.getParameter("username");
	      String password=request.getParameter("password");
	      String confirmpassword=request.getParameter("confirmpassword");
	      String user_type=request.getParameter("usergroup");
	      System.out.println(firstname);
	      response.setContentType("text/html");
	     
	      out.println("before try block"); 
	      try {
	     // Load the database driver
	     out.println("before OracleDriver");
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	     out.println("after OracleDriver");
	      // Get a Connection to the database
	     out.println("before getConnection");
	      connection = DriverManager.getConnection(connectionURL, "scott", "a5newdelhi"); 
	     out.println("after getConnection");
	      //Add the data into the database
	     out.println("before createStatement");
	         s = connection.createStatement();
	     out.println("after createStatement");
	        

	         String QueryString = "insert into signin values ('"+firstname.trim()+"'"+","+"'"+middlename.trim()+"'"+","
	        		                 +"'"+lastname.trim()+"'"+","+"'"+gender.trim()+"'"+","+"'"+mobilenumber.trim()+"'"+","
	        		                 +"'"+olandline.trim()+"'"+","+"'"+hlandline.trim()+"'"+","+"'"+caddress.trim()+"'"+","
	        		                 +"'"+email.trim()+"'"+","+"'"+organization.trim()+"'"+","+"'"+designation.trim()+"'"+","
	        		                 +"'"+oaddress.trim()+"'"+","+"'"+username.trim()+"'"+","+"'"+password.trim()+"'"+","
	        		                 +"'"+confirmpassword.trim()+"'"+","+"'"+user_type.trim()+"'"+")"; 
	          out.println(""+firstname.trim()+""+""+""+middlename.trim()+""+","
	        		                 +""+lastname.trim()+""+","+""+gender.trim()+""+","+""+mobilenumber.trim()+""+","
	        		                 +""+olandline.trim()+""+","+""+hlandline.trim()+""+","+""+caddress.trim()+""+","
	        		                 +""+email.trim()+""+","+""+organization.trim()+""+","+""+designation.trim()+""+","
	        		                 +""+oaddress.trim()+""+","+""+username.trim()+""+","+""+password.trim()+""+","
	        		                 +""+confirmpassword.trim()+""+","+""+user_type.trim());
//	         String QueryString_2 = "insert into user_tables values ('"+username.trim()+"'"+","+"'"+password+"'"+")";
	     
	         //String QueryString_2 = "insert into user_tables values ('km559u','a22newdelhi')";
	         
	         //String QueryString = "insert into signin values ('kanagaraj','dharuman','muthaiah','M',9980677554,1234,1234,'Bangalore','kdharuman@hotmail.com','IBM','ASA','EGL','mk559u','a33newde','a33newde','normaluser')";
	         //System.out.println("Before first query");
	         out.println("before executeQuery");
	         rs = s.executeQuery(QueryString);
	         out.println("after executeQuery");
	         
	     /* if(rs.next ()){//Use If Here not While
	        request.setAttribute("user",rs.getString(1));
	        request.setAttribute("password",rs.getString(2));
	          }
	       */            
	      rs.close();
	      //rs2.close();
	      s.close();
	      RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/Register.jsp" );
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
