<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
background-image:url("images/A Juice.jpeg");
background-size:cover;
}

</style>
</head>
<body>
<%@include file="header.jsp" %>
<%Random r=new Random(); %>
<h1><%=r.nextLong()%></h1>
<%Date d=new Date(); %>
<h1><%=d%></h1>
</body>
</html>