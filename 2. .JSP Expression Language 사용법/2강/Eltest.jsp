<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<% 
		//el 표현식 	
		int i = 3;	
	
		//out.println("i = " +i);
		
		request.setAttribute("ia" , "3");
	%>
	
		<p>
		i = <%=i > 4 %><!--객체 자체는 호출이 되지만 화면에 출력할수 있는 값만 가능 -->
		i = <%="3" + 4 %>
		
		<p>
		i = ${ia }
		i = ${ia > 4}
		i = ${ia + 4}

</body>
</html>