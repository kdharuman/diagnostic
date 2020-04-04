<!DOCTYPE html>
<html lang="en">
<head>
	<title>	Login Page </title>
	<script language="javascript" src="text/javascript">
		function validate ()	{
			alert ("Check credentials");


		}
	</script>
</head>
<body>
	<form name="form" method="post" action="Login">
		<br> <br> <br> <br>
		<center>
			<table>
			    <tr> 
			    <td colspan="2" bgcolor="#b5dcb3">
				   		<center><h3>Login</h3></center>
					</td>
				</tr>
				<tr>
					<td><br>Login as: </td>
					<td><input type="radio" name="usergroup" id="administrator" 
						value="administrator" />Administrator</td>
					<td><input type="radio" name="usergroup" id="normaluser"
						value="normaluser" />Normal User</td>
				</tr>
				<tr>
					<td><br>Username :</td>
					<td><input type="text" name="user" id="user" size=25
						value="${request.user}" required="required" placeholder="Enter the user name here"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password" size=25
						value='${request.password}' required="required" placeholder="Enter the password here"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" onclick="validate()" value="Login"></td>
				</tr>
				<tr> 
					<td></td>
					<td><a href="Forgot_UserID.jsp">Forgot User ID</a></td>
					<td><a href="Forgot_Password.jsp">Forgot Password</a></td>
				</tr>
			</table>
		</center>
  </form>

</body>
</html>
