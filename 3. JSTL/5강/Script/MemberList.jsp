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
	<!-- 1. 데이터 베이스에서 모든 회원의 정보를 가져옴  2.table 태크를 이용하여 화면에 회원들의 정보를 출력 -->	
	<% 
		MemberBeanDAO mbao = new MemberBeanDAO();
		mbao.allSelectMember();
		//회원들의 정보가 얼마나 저장 되어있는지 모르기에 가변길이인 Vector를 이용하여 데이터를 저장해줌
		//폴리 모피즘 다형성 트리 구조 하위구조 부모 자식 관계 
	    Vector<MemberBean> vec = mbao.allSelectMember();
		request.setAttribute("vec",vec);
	%>
	
	
	<center>
	<h2> 모든 회원 보기 </h2>
		<table width ="800" border="1">
			<tr height="50">
				<td align = "center" width = "150">아이디 </td>
				<td align = "center" width = "250">이메일 </td>
				<td align = "center" width = "200">전화번호 </td>
				<td align = "center" width = "200">취미 </td>
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