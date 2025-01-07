<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="Member.MemberBeanDAO"%>
<%@ page import="Member.MemberBean"%>
<%@ page import="java.util.Vector"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. ������ ���̽����� ��� ȸ���� ������ ������  2.table ��ũ�� �̿��Ͽ� ȭ�鿡 ȸ������ ������ ��� -->	
	<% 
		MemberBeanDAO mbao = new MemberBeanDAO();
		mbao.allSelectMember();
		//ȸ������ ������ �󸶳� ���� �Ǿ��ִ��� �𸣱⿡ ���������� Vector�� �̿��Ͽ� �����͸� ��������
		//���� ������ ������ Ʈ�� ���� �������� �θ� �ڽ� ���� 
	    Vector<MemberBean> vec = mbao.allSelectMember();
		request.setAttribute("vec",vec);
	%>
	
	
	<center>
	<h2> ��� ȸ�� ���� </h2>
		<table width ="800" border="1">
			<tr height="50">
				<td align = "center" width = "150">���̵� </td>
				<td align = "center" width = "250">�̸��� </td>
				<td align = "center" width = "200">��ȭ��ȣ </td>
				<td align = "center" width = "200">��� </td>
			</tr>
			
			<c:forEach var="bean" items="${vec}" >
					<tr height="50">
					<td align = "center" width = "150">
					<a href = "MemberInfo.jsp?id=${bean.id}">
						${bean.id}</a>
					</td>
					<td align = "center" width = "250">${bean.email}</td>
					<td align = "center" width = "200">${bean.tel}</td>
					<td align = "center" width = "200">${bean.hobby}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>