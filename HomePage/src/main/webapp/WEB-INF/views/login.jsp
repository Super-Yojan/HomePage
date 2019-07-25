<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body style ="margin:0px;background-color: #5aed89;">
<div style="position:absolute; width:100%;background-color: #ff4049; height:100px; padding:0px;margin:0px; top: 0px">
	<h1>Joarch</h1>
</div>
	<div
		style="border-radius: 15px; position: absolute; left: 70%; right: 10%; bottom: 10%; top:20%; background-color: #f4f0f5; height: 500px">
		<!--  <img id="image-1" alt="logo" src="HomePage/src/main/webapp/WEB-INF/views/logo.jpeg"/>
		--><form action="login" method="post">
			Enter Username: <br> <input type="text" name="userName"><br>
			Enter Password:<br> <input type="password" name="userPass"><br>
			<div style="font-size: 12px">
				<a href="">Forget Password?</a>
			</div>
			<input type="submit" value="Login">
		</form>
		<form action="singup" method="post">
			<input type="submit" value="Create Account">
		</form>
	</div>


</body>
</html>