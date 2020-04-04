package com.teembinsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Billing_Type extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      PrintWriter out = response.getWriter();
	      System.out.println(out);
	      String connectionURL = "jdbc:oracle:thin:@localhost:1521/orcl";
	      Connection connection=null;
	      Statement s=null;
	      ResultSet rs=null;
	      String billingtype=request.getParameter("billingtype");
	      out.println(billingtype);
	      response.setContentType("text/html");
	     
	      out.println("before try block"); 
/*
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
	        
*/	
	     RequestDispatcher dispatcher;
	     if (billingtype.equals("I"))	{
		      dispatcher=getServletContext().getRequestDispatcher( "/individual_billing.jsp" );
		      dispatcher.forward( request, response );
	     }
	     else if (billingtype.equals("B"))  {
		out.println("<html>");
		out.println("<head>");
		out.println("<script> alert (\"Bulk Billing selected\")");
		out.println("</script>");
		out.println("</html>");

	     }
			
/*
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
	    } */

   }
}
