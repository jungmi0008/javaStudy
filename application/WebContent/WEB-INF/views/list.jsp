<%@page import="org.comstudy21.Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table{
			border : 1px solid gray;
		}
</style>
</head>
<body>
<p><span><%=(String)session.getAttribute("login.id")%>님 환영합니다.</span>&nbsp;&nbsp;<a href="managerPage.do">로그아웃</a></p>
<h1>사람목록</h1>
<hr>
<form action="newList.do" method="POST">
	과정명으로 검색 : <input type="text" name="searchCourse" placeholder="과정명을 입력하세요">
	<input type="submit" value="검색">
</form>
	<br>
	<table width="100%">
		<tr>
			<th>과정</th>
			<th>이름</th>
			<th>주민번호</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>휴대폰번호</th>
			<th>결제수단</th>
			<th>시작일</th>
			<th>종료일</th>
			<th>동의여부</th>
		</tr>
		<%
		if(request.getAttribute("appArr")!=null){
			Dto[] appArr = (Dto[])request.getAttribute("appArr");
			for(int i=0; i<appArr.length; i++){
				Dto app= appArr[i];
		%>
		<tr>
			<td><%=app.getCourse()%></td>
			<td><%=app.getName()%></td>
			<td><%=app.getIdNumber1()%>-<%=app.getIdNumber2()%>***</td>
			<td><%=app.getAddress()%></td>
			<td><%=app.getPhone()%></td>
			<td><%=app.getMobile()%></td>
			<td><%=app.getPayment()%></td>
			<td><%=app.getStartDay()%></td>
			<td><%=app.getEndDay()%></td>
			<td><%=app.getAgree()%></td>
		</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>