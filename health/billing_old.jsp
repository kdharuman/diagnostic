<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>

<html>
	<head>
<title>Billing</title>
	</head>
<body>


<form action="Billing">
	<h2><center>Billing</center></h2>
  <%-- <input list="bloos_test_names">
   <datalist id="bloos_test_names">
     <option value="ANTI SACCHAROMYCES CERVISIAE (IMMUNOFLOURESCENCE)">
     <option value="BENCE JONES PROTEINS URINE (ELECTROPHORESIS)">
     <option value="BETA 2 MICROGLOBULIN SERUM / URINE">
     <option value="BLOOD GROUPING AND RH TYPING">
     <option value="C REACTIVE PROTEIN - HIGH SENSITIVITY">
   </datalist>
   --%>
   <center>
   <table>
	  	        <tr>				
					<td>S.No</td>
					<td><input type="text" name="serial_number" id="serial_number" size="40"
						value="${request.serial_number}" disabled/></td>
				</tr>
				<tr>
					<td>Patient Name</td>
					<td><input type="text" name="patient_name" id="patient_name" size="40"
						value="${request.patient_name}" required="required" placeholder="Enter the patient name" /></td>
				</tr>
				<tr>
					<td>Patient ID</td>
					<td><input type="text" name="patient_id" id="patient_id" size="40"
						value="${request.patient_id}" disabled/></td>
				</tr>
				<tr>
					<td>Blood Test Name</td>
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
								String sql = "select * from blood_test_names order by test_name";
								rs = stmt.executeQuery(sql);
						%>
						<center>
							<select>
							<%  while(rs.next())
							    { %>
								<option><%= rs.getString(3)%></option>
							<%  } %>
							</select>
						</center>			

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
					<td>Test Code</td>
					<td><input type="text" name="test_code" id="test_code" size="40"
						value="${request.test_code}" disabled/></td>
				</tr>
				<tr>
					<td>Transaction Number</td>
					<td><input type="text" name="transaction_num" id="transaction_num" size="40"
						value="${request.transaction_num}"  disabled/></td>
				</tr>
				<tr>
					<td>Transaction Date</td>
					<td><input type="text" name="transaction_date" id="transaction_date" size="40"
						value="${request.transaction_date}" disabled/></td>
				</tr>
				
				<tr>
					<td>Test Date</td>
					<td><input type="text" name="test_date" id="test_date" size="40"
						value="${request.test_date}" disabled/></td>
				</tr>
				<tr>
					<td>MRP</td>
					<td><input type="text" name="mrp" id="mrp" size="40"
						value="${request.mrp}" disabled/></td>
				</tr>
				<tr>
					<td>Total Amount</td>
					<td><input type="text" name="total_amount" id="total_amount" size="40"
						value="${request.total_amount}" disabled/></td>
				</tr>
				<tr>
				    <td><input type="submit" value="Save"></td>
					<td><input type="submit" value="Submit"></td>
		            <td><input type="submit" value="Add"></td>
		            
		            <td><a href="Dashboard.jsp">Go to Dashboard</a></td>
		        </tr>
		
	</table>
	</center>			
</form>
</body>
</html>
