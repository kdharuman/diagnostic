<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Javascript Login Form Validation</title>
<!-- Include CSS File Here -->
<link rel="stylesheet" href="style.css"/>
<!-- Include JS File Here -->
<script src="login.js"></script>
</head>
<body>
<div class="container">
<div class="main">
<h2>Javascript Login Form Validation</h2>
<form id="form_id" method="post" name="myform">
<label>User Name :</label>
<input type="text" name="username" id="username"/>
<label>Password :</label>
<input type="password" name="password" id="password"/>
<input type="button" value="Login" id="submit" onclick="validate()"/>
</form>
<span><b class="note">Note : </b>For this demo use following username and password. <br/><b class="valid">User Name : Formget<br/>Password : formget#123</b></span>
</div>
</div>
</body>
</html>