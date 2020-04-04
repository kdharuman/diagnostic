<html>
<body>
	<form name="form" method="post" action="RegisterUser">
		<br> <br> <br> <br>
		   <center>
			<table>
			   
				<tr>
					<td colspan="2" bgcolor="#b5dcb3">
						
							<h3>Staff Registration</h3>
						
					</td>
				</tr>
            
			</table>
			</center>
			<center>
			<fieldset>
					<legend>
						<b>Registration</b>
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
					<td><br>Gender </td>
					<td><input type="radio" name="gender" id="male" 
						value="M" />Male</td>
					<td><input type="radio" name="gender" id="female"
						value="F" />Female</td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="mobilenumber" id="mobilenumber" size="40"
						value="${request.mobilenumber}" required="required" placeholder="Enter the mobile number"/></td>
				</tr>
				<tr>
					<td>Office Landline Number</td>
					<td><input type="text" name="olandline" id="olandline" size="40"
						value="${request.olandline}" placeholder="Enter your office landline number"/></td>
				</tr>
				<tr>
					<td>Home Landline Number</td>
					<td><input type="text" name="hlandline" id="hlandline" size="40"
						value="${request.hlandline}" placeholder="Enter your home landline number"/></td>
				</tr>
				<tr>
					<td>Address for Communication</td>
					     <td><textarea name="caddress" rows="10" cols="30" value="${request.caddress}" placeholder="Enter your current address"></textarea></td>
					<!-- <input type="text" name="caddress" id="caddress" <td>
						value="${request.caddress}" /></td> -->
				</tr>
				<tr>
					<td>Email Address</td>
					<td><input type="email" name="email" id="email" size="40"
						value="${request.email}"  required="required" placeholder="Enter your email address"/></td>
				</tr>
				<tr>
					<td>Organization</td>
					<td><input type="text" name="organization" id="organization" size="40"
						value="${request.organization}" required="required" placeholder="Enter your Organization"/></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td><input type="text" name="designation" id="designation" size="40"
						value="${request.designation}" required="required" placeholder="Enter your Designation"/></td>
				</tr>
				<tr>
					<td>Organization Address</td>
					<td><input type="text" name="oaddress" id="oaddress" size="40"
						value="${request.oaddress}" placeholder="Enter your organization address"/></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="username" id="username" size="40"
						value="${request.username}" required="required" placeholder="Enter the user name"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="password" size="40"
						value="${request.password}" required="required" placeholder="Enter the password"/></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="confirmpassword" id="confirmpassword" size="40"
						value="${request.confirmpassword}" required="required" placeholder="Enter the confirmation password"/></td>
				</tr>
				<tr>
					<td><br>User Type </td>
					<td><input type="radio" name="usergroup" id="administrator" 
						value="administrator" />Administrator</td>
					<td><input type="radio" name="usergroup" id="normaluser"
						value="normaluser" />Normal User</td>
				</tr>
				<tr>
					
					
					<td><input type="submit" value="         Submit         "></td>
				    <td><a href="Administrator.jsp">Goto Administrator's Page</a></td>
				</tr>
			</table>
			</fieldset>
		</center>
	</form>

</body>
</html>
