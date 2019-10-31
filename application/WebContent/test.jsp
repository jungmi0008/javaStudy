<%@page import="org.comstudy21.util.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<body>
<%
	Connection conn = JdbcUtil.getConnection();
	out.println(conn);
%>
</body>
</body>
</html>