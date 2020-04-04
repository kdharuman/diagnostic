<html>
<body>
	<form name="form" method="post" action="ForgotPassword">
		<br> <br> <br> <br>
		<center>
			<table>
			    <tr>
					<td><h3>Retrieve User Password</h3></td>
				</tr>
				<tr>
					<td>Enter the username</td>
					<td><input type="text" name="user" id="user"
						value="${request.user}" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</center>
	</form>

</body>
</html>
