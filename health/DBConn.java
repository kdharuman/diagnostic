package com.teembinsys;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class DBConn extends HttpServlet{
	private static final long serialVersionUID = 1L;
      public void doPost(HttpServletRequest request, 
                        HttpServletResponse response) 
                           throws IOException, ServletException {
        Connection connection = null;
        Statement stmt=null;
        ResultSet rs=null;
        List<Employee> dataList = new ArrayList<Employee>();
        try {
            // Load the JDBC driver
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);

            // Create a connection to the database
            String serverName = "localhost";
            String portNumber = "1521";
            String sid = "orcl";
            String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
            String username = "scott";
            String password = "a5newdelhi";
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Reached the Servlet");
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select employee_id, first_name from employees");
            while (rs.next()) {
                dataList.add(new Employee(rs.getInt("employee_id"),
                                          rs.getString("first_name")));
                System.out.println("Employee ID: "+rs.getInt("employee_id"));
                System.out.println("First Name: "+rs.getString("first_name"));
            }
        } catch (ClassNotFoundException e) {
            // Could not find the database driver
            e.printStackTrace();
        } catch (SQLException e) {
            // Could not connect to the database
            e.printStackTrace();
        } finally{
            if(rs!=null){
                try{ 
                  rs.close();
                }catch(Exception ex) { /* */ ex.printStackTrace();}
            }
            if(stmt!=null){
                try{ 
                  stmt.close();
                }catch(Exception ex) { /* */ ex.printStackTrace();}
            }
            if(connection !=null){
                try{ 
                  connection.close();
                }catch(Exception ex) { /* */ ex.printStackTrace();}
            }
         }
         
         request.setAttribute("data", dataList);
         String strViewPage = "/Register.jsp";
         RequestDispatcher dispatcher = request.getRequestDispatcher(strViewPage);
          if (dispatcher != null) {
             dispatcher.forward(request, response);
          }
       }
}
