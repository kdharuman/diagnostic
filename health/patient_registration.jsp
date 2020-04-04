<html>
<body>
	<form name="form" method="post" action="RegisterPatient">
		<br> <br> <br> <br>
		   <center>
			<table>
			   
				<tr>
					<td colspan="2" bgcolor="#b5dcb3">
						
							<h3>Grandhim Multispeciality Hospital</h3>
						
					</td>
				</tr>
            
			</table>
			</center>
			<center>
			<fieldset>
					<legend>
						<b>Patient Registration</b>
					</legend>
			
			<table>
			
				<tr>				
					<td>First Name</td>
					<td><input type="text" name="firstname" id="firstname" size="40"
						value="${request.firstname}" required="required" placeholder="Enter your first name"/></td>
				</tr>
				<tr>
					<td>Middle Name</td>
					<td><input type="text" name="middlename" id="middlename" size="40"
						value="${request.middlename}" placeholder="Enter your middle name"/></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastname" id="lastname" size="40"
						value="${request.lastname}" placeholder="Enter your last name"/></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="text" name="age" id="age" size="40"
						value="${request.age}" required="required" placeholder="Enter the age"/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="text" name="gender" id="gender" size="40"
						value="${request.gender}" required="required" placeholder="Enter the gender"/></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="mobilenumber" id="mobilenumber" size="40"
						value="${request.mobilenumber}" placeholder="Enter the mobile number"/></td>
				</tr>
				<tr>
					<td>Home Landline Number</td>
					<td><input type="text" name="hlandline" id="hlandline" size="40"
						value="${request.hlandline}" placeholder="Enter your home landline number"/></td>
				</tr>
				<tr>
					<td>Address for Communication</td>
					     <td><textarea name="caddress" id="caddress" rows="10" cols="30" value="${request.caddress}" placeholder="Enter your current address"></textarea></td>
					<!-- <input type="text" name="caddress" id="caddress" <td>
						value="${request.caddress}" /></td> -->
				</tr>
				<tr>
					<td>Email Address</td>
					<td><input type="email" name="email" id="email" size="40"
						value="${request.email}"  placeholder="Enter your email address"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="         Submit         "></td>
				    <td><a href="Dashboard.jsp">Goto Dashboard</a></td>
				</tr>
			</table>
			</fieldset>
		</center>
	</form>

</body>
</html>
