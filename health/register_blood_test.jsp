<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<html>
	<head>
		<title> Register Blood Tests </title>
	<script>
		function set_first_last_name()	{
			document.getElementById("first_last_name").value=document.getElementById("select_first_last_name").value;
		}
	
		function set_blood_test_name()	{
			document.getElementById("blood_test_names").value=document.getElementById("test_names").value;
		}
	</script>

	</head>

	<body>
		<form method="post" action="Register_Blood_Test">
			<h2><center>Register Blood Tests</center></h2>	
			 <center>
				 <table>
					<tr>
						<td>Patient Name</td>
						<td>
							<%	
								String connectionURL = "jdbc:oracle:thin:@localhost:1521/orcl";
								Connection connection = null;
								Statement stmt=null;
								ResultSet rs=null;
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
										name=fname+","+lname;
									%>
										<option><%= name %></option>
									<%  } %>
								</select>
							<%
								}
								catch(Exception e)
								{
									out.println("wrong entry"+e);
								}
							%>
						</td>
					</tr>
					<tr>
						<td>Test Names</td>
						<td>
							<%
								try
								{
									String sql = "select * from blood_test_names order by test_name";
									rs = stmt.executeQuery(sql);
							%>
							<select id="test_names" onchange="set_blood_test_name()">
							<%  while(rs.next())
							    { %>
								<option><%= rs.getString(3)%></option>
							<%  } %>
							</select>
						<%
								}
								catch(Exception e)
								{
									out.println("wrong entry"+e);
								}
						%>
						</td>
					 </tr>
					 <tr>
						<td>
							<input type=submit value="Submit">
							<input type=hidden id="first_last_name" name="first_last_name">
							<input type=hidden id="blood_test_names" name="blood_test_names">
							<a href="Dashboard.jsp"> Goto Dashboard </a>
						</td>
					 </tr>
			 </table>
		    </center>
		</form>
	</body>
</html>
