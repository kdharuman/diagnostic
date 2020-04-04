<html>
<head>
  <title>Order Book</title>
</head>
 
<body>
  <h1>Another E-Bookstore</h1>
  <h2>Thank you for ordering...</h2>
 
  <%
    String[] sn = request.getParameterValues("serial_number");
    if (sn == null) {
  %>
  <%@ page import = "java.sql.*" %>
  <%
      System.out.println("Reached the order.jsp page");
      Connection conn = DriverManager.getConnection(
    		  "jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger"); // <== Check!
      // Connection conn =
      //    DriverManager.getConnection("jdbc:odbc:eshopODBC");  // Access
      Statement stmt = conn.createStatement();
      String sqlStr;
      int recordUpdated;
      ResultSet rset;
  %>
      <table border=1 cellpadding=6 cellspacing=0>
        <tr>
            <th>Serial Number</th>
            <th>Test ID</th>
            <th>Test Name</th>
            <th>MRP</th>
            <th>Test Upload Date</th>
            <th>Test Modified Date</th>
        </tr>
  <%
      for (int i = 0; i < sn.length; ++i) {
        // Subtract the QtyAvailable by one
        // carry out a query to confirm
        sqlStr = "SELECT * FROM blood_test_names WHERE serial_number =" + sn[i];
        rset = stmt.executeQuery(sqlStr);
        while (rset.next()) {
        System.out.println("Reached till rset.next()");
  %>
          <tr>
            <td><%= rset.getString("serial_number") %></td>
            <td><%= rset.getString("test_id") %></td>
            <td><%= rset.getString("test_name") %></td>
            <td>Rs.<%= rset.getInt("mrp") %></td>
            <td><%= rset.getString("test_upload_date") %></td>
            <td><%= rset.getString("test_modified_date") %></td>
          </tr>
  <%    }
        rset.close();
      }
      stmt.close();
      conn.close();
    }
  %>
  </table>
  <a href="query.jsp"><h3>BACK</h3></a>
</body>
</html>