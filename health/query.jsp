<%@page import="java.util.ArrayList"%>
<%@page import="com.teembinsys.BloodTest"%>
<%@page import="java.util.List"%>
<html>
<head>
  <title>Book Query</title>
</head>
<body>
  <h1>Another E-Bookstore</h1>
  <h3>Choose Author(s):</h3>
  <form method="get">
    <input type="checkbox" name="blood_test_names" value="Blood Test Details">Blood Test Details
    <input type="submit" value="Query">
    
    <select>
   <optgroup label="Swedish Cars">
     <option value="volvo">Volvo</option>
     <option value="saab">Saab</option>
   </optgroup>
   <optgroup label="German Cars">
     <option value="mercedes">Mercedes</option>
     <option value="audi">Audi</option>
   </optgroup>
</select> 
  </form>
 
  <%
    String[] authors = request.getParameterValues("blood_test_names");
    if (authors != null) {
  %>
  <%@ page import = "java.sql.*" %>
  <%
      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
      Connection conn = DriverManager.getConnection(
          "jdbc:oracle:thin:@localhost:1521/orcl", "scott", "a5newdelhi"); // <== Check!
      // Connection conn =
      //    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
      Statement stmt = conn.createStatement();
 
      String sqlStr = "SELECT * FROM blood_test_names";
      
      // for debugging
      System.out.println("Query statement is " + sqlStr);
      ResultSet rset = stmt.executeQuery(sqlStr);
  %>
      <hr>
      <form method="get" action="order.jsp">
        <table border=1 cellpadding=6>
          <tr>
            <th>Serial Number</th>
            <th>Test ID</th>
            <th>Test Name</th>
            <th>MRP</th>
            <th>Test Upload Date</th>
            <th>Test Modified Date</th>
          </tr>
  <%
   List<BloodTest> bloodList=new ArrayList<BloodTest>();
   BloodTest bloodtest;//new BloodTest();
      while (rset.next()) {
     bloodtest=new BloodTest();
        int sn = rset.getInt("serial_number");
  %>
          <tr>
            <%--  <td><input type="checkbox" name="sn" value="<%= sn %>"></td>  --%>
            <td><%= bloodtest.setSerial_number(rset.getInt("serial_number")) %></td>
            <td><%= bloodtest.setTest_id(rset.getString("test_id")) %></td>
            <td><%= bloodtest.setTest_name(rset.getString("test_name")) %></td>
            <td>Rs.<%= bloodtest.setMrp(rset.getInt("mrp")) %></td>
            <td><%= bloodtest.setTest_upload_date(rset.getString("test_upload_date")) %></td>
            <td><%= bloodtest.setTest_modified_date(rset.getString("test_modified_date")) %></td>
            bloodList.add(bloodtest);
          </tr>
  <%
      }
  %>
        </table>
        <br>
        <input type="submit" value="Order">
        <input type="reset" value="Clear">
      </form>
      <a href="<%= request.getRequestURI() %>"><h3>Back</h3></a>
  <%
      rset.close();
      stmt.close();
      conn.close();
    }
  %>
</body>
</html>
