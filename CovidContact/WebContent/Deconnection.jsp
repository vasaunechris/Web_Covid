<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deconnection</title>
</head>
<body>

<% 
session.setAttribute("current_user",null);
request.setAttribute("current_user",null);
request.getRequestDispatcher( "/Home.jsp" ).forward( request, response );
%>

</body>
</html>