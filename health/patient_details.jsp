<%@page import="java.util.ArrayList"%>
<%@page import="com.teembinsys.BloodTest"%>
<%@page import="java.util.List"%>
<html>
<head>
  <title>Patient Sensitive Personal Information</title>
</head>
<body>
  <center><h3>Patient Sensitive Personal Information</h3>
  </center>
  <form method="get">
  </form>
 
  <%@page import = "java.sql.*" %>
  <%
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      Connection conn = DriverManager.getConnection(
          "jdbc:oracle:thin:@localhost:1521/orcl", "scott", "a5newdelhi"); // <== Check!
      Statement stmt = conn.createStatement();
 
      String sqlStr = "select * from patient order by patient_id desc";
      
      ResultSet rset = stmt.executeQuery(sqlStr);
  %>
      <hr>
      <form method="get" action="order.jsp">
      <td><a href="Dashboard.jsp">Goto Dashboard</a></td>
        <table border=1 cellpadding=6>
          <tr>
            <th>First Name</th>
            <th>Middle Name</th>
            <th>Last Name</th>
            <th>Patient ID</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Mobile Number</th>
            <th>Home Landline Number</th>
            <th>Current Address</th>
            <th>Email Address</th>
            <th>Date of Registration</th>
            
            
          </tr>
  <%
      while (rset.next()) {
  %>         
 		<tr>
            <td><%= rset.getString("patient_first_name") %></td>
            <td><%= rset.getString("patient_middle_name") %></td>
            <td><%= rset.getString("patient_last_name") %></td>
            <td><%= rset.getInt("patient_id") %></td>
            <td><%= rset.getString("age") %></td>
            <td><%= rset.getString("gender") %></td>
            <td><%= rset.getString("mobile_number") %></td>
            <td><%= rset.getString("home_landline_num") %></td>
            <td><%= rset.getString("current_address") %></td>
            <td><%= rset.getString("email_address") %></td>
            <td><%= rset.getString("date_of_registration") %></td>
        </tr>       
  <%
      }
  %>
        </table>
        
      </form>
  <%
      rset.close();
      stmt.close();
      conn.close();
  %>
</body>
</html>
