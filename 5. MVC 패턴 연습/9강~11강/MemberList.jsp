<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2> ��� ȸ�� ���� </h2>
		<table width="800" border="1" bordercolors="gray">
			<tr height ="40">
				<td align="center" width="50">���̵�</td>
				<td align="center" width="200">�̸���</td>
				<td align="center" width="150">��ȭ</td>
				<td align="center" width="150">���</td>
				<td align="center" width="150">����</td>
				<td align="center" width="100">����</td>
			</tr>
			
		<c:forEach var="v" items="${v}">
			<tr height ="40">
				<td align="center" width="50">${bean.id}</td>
				<td align="center" width="200"><a href="#">${bean.email}</a></td>
				<td align="center" width="150">${bean.tel}</td>
				<td align="center" width="150">${bean.hobby}</td>
				<td align="center" width="150">${bean.job}</td>
				<td align="center" width="100">${bean.age}</td>
			</tr>
		</c:forEach>
		</table>
	</center>
</body>
</html>