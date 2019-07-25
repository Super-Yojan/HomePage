<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body style="padding:0px;margin:0px">
	<div style="background-color:#c42d6f;height:100px;align-content:center;" > 
		<h1 style="align:center"><i>Welcome <%=request.getAttribute("user") %></i></h1>
	</div>
</body>
</html>