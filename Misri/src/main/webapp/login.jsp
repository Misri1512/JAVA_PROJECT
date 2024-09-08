<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="Loginservlet" method="post">
		<input type="text" name="Uname" placeholder="Enter Username"/>
		<input type="password" name="Upass"/>
		<input type="submit" name="Submit" value="Submit"/>
		<input type="submit" name="Reset" value="Reset"/>
	</form>
</body>
</html>