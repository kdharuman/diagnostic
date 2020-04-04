<%@page import="java.sql.*" %>
<html>
	<head>
		<%!
			boolean patient_exists=false;
			String connectionURL = "jdbc:oracle:thin:@localhost:1521/orcl";
			Connection connection = null;
			Statement stmt=null;
			ResultSet rs=null;
		%>
        <script>
                function set_first_last_name()  {
                        document.getElementById("first_last_name").value=document.getElementById("select_first_last_name").value;
			var first_last_name_value = document.getElementById("first_last_name").value;
			
			if (first_last_name_value != "")	{
				<%
				   patient_exists=true;
				%>
			}
                }
        </script>

	</head>

	<body>
	
	<form method="post" action="Pre_Billing">
		<h2><center>Billing</center></h2>
		<center>
			<table>
				<tr>
					<td> Patient Name: </td>
					<td>
					<%
						try	
						{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							connection = DriverManager.getConnection(connectionURL, "scott", "a5newdelhi");
							stmt = connection.createStatement(); 
							String sql = "select * from patient order by patient_first_name";
							rs = stmt.executeQuery(sql);
					%>
						<select id="select_first_last_name" onchange="set_first_last_name()">
						<%  while(rs.next())
						    {
							String fname=rs.getString(1);
							String lname=rs.getString(3);
							String name=null;
							name=fname + "," + lname;
						%>
						<option><%= name %></option>
						<%  } %>
						</select>	
					<%
						}
						catch (Exception e)
						{
							out.println("Wrong entry: " + e);
						}
					%>
					</td>
				</tr>
				 <tr>
					<td>
						<input type=submit value="Submit">
						<input type=hidden id="first_last_name" name="first_last_name">
					</td>
				 </tr>

			</table>
		</center>
	</form>

	<form method="get">
<%
      Class.forName("oracle.jdbc.driver.OracleDriver");
      connection = DriverManager.getConnection(connectionURL, "scott", "a5newdelhi");
      stmt = connection.createStatement();

      String sql="select pt.patient_first_name,pt.patient_last_name,pt.age,pt.gender,pt.patient_id,btn.test_name,tp.test_date,btn.mrp from patient pt, blood_test_names btn, test_performed tp where pt.patient_id=tp.patient_id and btn.test_id=tp.test_id order by pt.patient_id desc";
      rs = stmt.executeQuery(sql);
%>

        <table border=1 cellpadding=6>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Patient ID</th>
	    <th>Tests</th>
	    <th>Date</th>
	    <th>MRP</th>
          </tr>

  <%
      while (rs.next()) {
  %>
      <tr>
	   <td><%= rs.getString("patient_first_name") %></td>
	   <td><%= rs.getString("patient_last_name") %></td>
	   <td><%= rs.getInt("age") %></td>
	   <td><%= rs.getString("gender") %></td>
	   <td><%= rs.getInt("patient_id") %></td>
	   <td><%= rs.getString("test_name") %></td>
	   <td><%= rs.getString("test_date") %></td>
	   <td><%= rs.getInt("mrp") %></td>
      </tr>
   <%
      }
   %>
      </table>

  <%
      rs.close();
      stmt.close();
      connection.close();
  %>
	</form>

	<a href="Dashboard.jsp"> Goto Dashboard </a>
	</body>
</html>
