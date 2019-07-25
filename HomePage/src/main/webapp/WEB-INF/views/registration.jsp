<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Joarch</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#email").change(function() {
			$.ajax({
				url:'validateEmail',
				data:{email:$("#email").val()},
				success:function(responseText){
					$("#errMsg").text(responseText);

					if(responseText != null){
						$("#email").focus()}
					}
				});
		});
	});
</script>
</head>
<body style="margin: 0px; background-color: #5aed89">
	<div
		style="position: absolute; width: 100%; background-color: #ff4049; height: 100px; padding: 0px; margin: 0px; top: 0px">
		<h1>Joarch</h1>
	</div>
	<div
		style="border-radius: 15px; position: fixed; left: 70%; right: 10%; bottom: 10%; top: 20%; background-color: #f4f0f5; height: 500px">
		<form action="register" method="post">
			FirstName: <input type="text" name="firstName"> LastName: <input
				type="text" name="lastName"><br> UserName: <input
				type="text" name="userName"><br>Email:<br> <input
				type="text" name="email" id="email"><br> <span style="color:red"
				id="errMsg"></span> <br> Phone Number: <input type="text"
				name="number" placeholder="Optional"><br> Password: <input
				type="password" name="password"><br>
			<!--  Retype Password: <input type="password" name="rePassword"><br>
			-->
			<input type="submit" value="Create Account">
		</form>
	</div>
</body>
</html>