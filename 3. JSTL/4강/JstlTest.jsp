<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		//int i = 4;
		//request.setAttribute("i",4); == <c:set var="i" value="4" />
	%>
	
	<!--���� ����  -->
	<c:set var="i" value="4" />
	
	<!-- if�� ����  -->
	<c:if test="${4 < 3}"><!--������ ���̷�Ʈ�� ������ ����� �Ҽ� ����  -->
		�ȳ��ϼ���
	</c:if>
	
	
	<!-- �ݺ��� for -->
	<c:forEach var="k" begin="1"  end ="10" step="${k=k+1}">
	 	���ɽð� �Դϴ�. ${k}<br>
	</c:forEach>
	
	<c:forEach  begin="1"  end ="10">
	 	���ɽð� �Դϴ�.1<br>
	</c:forEach>
	
	
	<c:forEach var = "i" begin="1"  end ="10">
	 	<c:set var="sum" value="${sum=sum+i}" />
	</c:forEach>
	
	${sum}
	
	
	<c:forEach var = "j" begin="1"  end ="10" step="${j=j+2}" >
	 	<c:set var="sum1" value="${sum1=sum1+j}" /> 
	</c:forEach>
	
	${sum1}
	
	
	
	
</body>
</html>