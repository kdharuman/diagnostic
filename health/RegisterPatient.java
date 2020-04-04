package com.teembinsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      int patient_id_count=1;
	      PrintWriter out = response.getWriter();
	      String connectionURL = "jdbc:oracle:thin:@localhost:1521/orcl";
	      Connection connection=null;
	      Statement s=null;
	      ResultSet rs=null;
	      String firstname=request.getParameter("firstname");
	      String middlename=request.getParameter("middlename");
	      String lastname=request.getParameter("lastname");
	      String age=request.getParameter("age");
	      String gender=request.getParameter("gender");
	      String mobilenumber=request.getParameter("mobilenumber");
	      //int mobilenumber=Integer.parseInt(request.getParameter("mobilenumber"));
	      //String olandline=request.getParameter("olandline");
	      String hlandline=request.getParameter("hlandline");
	      //int hlandline=Integer.parseInt(request.getParameter("hlandline"));
	      String caddress=request.getParameter("caddress");
	      String email=request.getParameter("email");
	      String patient_id;
	      /*String organization=request.getParameter("organization");
	      String designation=request.getParameter("designation");
	      String oaddress=request.getParameter("oaddress");
	      String username=request.getParameter("username");
	      String password=request.getParameter("password");
	      String confirmpassword=request.getParameter("confirmpassword");
	      System.out.println(firstname);*/
	      response.setContentType("text/html");
	      
	      try {
	     // Load the database driver
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      // Get a Connection to the database
	      connection = DriverManager.getConnection(connectionURL, "scott", "a5newdelhi"); 
	      //Add the data into the database
	         s = connection.createStatement();
	         System.out.println("Before QueryString");
	         /*
	         String patient_id="G0000"+patient_id_count;
	         System.out.println("Patient ID in string format is : " + patient_id);*/
	         
	         
	         	         
			String QueryString = "insert into patient values "
	         		+ "('"+firstname.trim()+"'"+","+"'"+middlename.trim()+"'"+","
	                 +"'"+lastname.trim()+"'"+","+"patient_id_seq.nextval"+","
	         		 +"'"+age.trim()+"'"+","+"'"+gender.trim()+"'"+","
	         		 +"'"+mobilenumber.trim()+"'"+","
	                 +"'"+hlandline.trim()+"'"+","+"'"+caddress.trim()+"'"+","
	                 +"'"+email.trim()+"'"+","+"sysdate"+")";
	         
	         /*String QueryString = "insert into patient values ('"+firstname.trim()+"'"+
	                                                           ","+"'"+middlename.trim()+"'"+
	                                                           ","+"'"+lastname.trim()+"'"+
	                                                           ","+"'"+patient_id.trim()+"'"+
	                                                           ","+"'"+gender.trim()+"'"+
	                                                           ","+"'"+mobilenumber+"'"+
	                                                           ","+hlandline+","+
	                                                           "'"+caddress.trim()+"'"+
	                                                           ","+"'"+email.trim()+"'"+
	                                                           ","+"NULL"+")";*/
	         //String QueryString = "insert into signin values ('kanagaraj','dharuman','muthaiah','M',9980677554,1234,1234,'Bangalore','kdharuman@hotmail.com','IBM','ASA','EGL','mk559u','a33newde','a33newde')";
	         //String QueryString = "insert into patient values ("
	         	//	+ "'suresh','kumar','kamaraj',1,'M',1234,1234,'Arikere,Bangalore','kdharuman@hotmail.com',NULL)";
	         System.out.println("After QueryString");
	         System.out.println("Before executeQuery");
	         rs = s.executeQuery(QueryString);
	         System.out.println("After executeQuery");
	     /* if(rs.next ()){//Use If Here not While
	        request.setAttribute("user",rs.getString(1));
	        request.setAttribute("password",rs.getString(2));
	          }
	       */            
	      rs.close();
	      s.close();
	      RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/patient_registration.jsp" );
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
