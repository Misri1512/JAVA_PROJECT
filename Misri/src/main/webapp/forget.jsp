<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget page</title>
</head>
<body>
	<form action="Forgetservlet" method="POST">
		Username : <input type="text" name="username" placeholder="Enter Username"/>
		New Password : <input type="text" name="password" placeholder="Enter New Password"/>
		Re-enter Password : <input type="text" name="repassword" placeholder="Enter Re-Password"/>
		<input type="submit" name="Submit" value="Submit"/>
	</form>
</body>
</html>