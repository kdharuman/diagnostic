package com.teembinsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register_Blood_Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      PrintWriter out = response.getWriter();
	      String connectionURL = "jdbc:oracle:thin:@localhost:1521/orcl";
	      Connection connection=null;
	      Statement s1=null;
	      Statement s2=null;
	      Statement s3=null;
	      ResultSet rs1=null;
              ResultSet rs2=null;
              ResultSet rs3=null;

	      String fullname=request.getParameter("first_last_name");
	      String blood_test_name=request.getParameter("blood_test_names");
	      String firstname=null;
	      String lastname=null;
	      int patient_id=0;
	      String test_id=null;
	      response.setContentType("text/html");
	      
	      try {
	       out.println("Hello<br>");
	     // Load the database driver
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      // Get a Connection to the database
	      connection = DriverManager.getConnection(connectionURL, "scott", "a5newdelhi"); 
	      //Add the data into the database
	      s1 = connection.createStatement();
//	      String sql = "insert into test_table values ('" + fullname.trim() + "'," + "'" + blood_test_name.trim() + "')";
	      String blood_test_names_sql = "select * from blood_test_names where test_name='" + blood_test_name.trim()+"'";
	      rs1 = s1.executeQuery(blood_test_names_sql);

	      if (rs1.next())
	      {
		  test_id = rs1.getString(2);
	      }

	      String []name=fullname.split("\\,");

	      int count=1;
	      for (String w:name)	{
		   if (count == 1)	{
			firstname=w;
			++count;
		   }
                   else if (count == 2)  {
			lastname=w;
		   }
	      }
	      rs1.close();
	      s1.close();
	      s2 = connection.createStatement();
	      String patient_sql = "select * from patient where patient_first_name='" + firstname.trim() + "'" + "and patient_last_name='" + lastname.trim() + "'";
	      rs2 = s2.executeQuery(patient_sql);
	      if (rs2.next ())  {
         	patient_id = Integer.parseInt(rs2.getString (4));
	      }	 
	      rs2.close();
	      s2.close();
	      
	      s3 = connection.createStatement();
	      String test_performed_sql = "insert into test_performed values (" + patient_id + "," + "'" + test_id + "'" + "," + "sysdate" + ")";
	      rs3 = s3.executeQuery(test_performed_sql);
	      rs3.close();
              s3.close();
	      RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/register_blood_test.jsp" );
	      dispatcher.forward( request, response );
	      }
	      catch(SQLException e){
		  out.println("<br>SQLException" + e);
	    	  e.printStackTrace();
	          System.out.println("Exception is ;"+e);
	      } 
	      catch (ClassNotFoundException e) {
	          System.out.println("Exception is ;"+e);
	    }
   }
}
