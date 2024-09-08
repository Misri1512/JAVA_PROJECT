<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register page</title>
</head>
<body>
	<form action="Registerservlet" method="post">
		Name : <input type="text" name="name" placeholder="Enter Name"/>
		Email : <input type="email" name="email" placeholder="Enter Email"/>
		Password : <input type="password" name="password" placeholder="Enter Password"/>
		Age : <input type="number" name="age" placeholder="Enter Age"/>
		No. : <input type="number" name="no" placeholder="Enter No."/>
		Gender : <input type="text" name="gender" placeholder="Enter Gender"/>
		Address : <input type="text" name="address" placeholder="Enter Address"/>
		Course : <select name="course">
			<option value="CE">CE</option>
			<option value="IT">IT</option>
			<option value="Btech">Btech</option>
			<option value="BCA">BCA</option>
		</select>
		Accept Terms <input type="checkbox" value="checked" name="accept"/>
		<input type="submit" name="Submit" value="Submit"/>
		<input type="submit" name="Reset" value="Reset"/>
		Already Registered?<a href="login.jsp"> click here to login</a>
		<a href="forget.jsp">Forget Password?</a>
	</form>
</body>
</html>