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
		//el ǥ���� 	
		int i = 3;	
	
		//out.println("i = " +i);
		
		request.setAttribute("ia" , "3");
	%>
	
		<p>
		i = <%=i > 4 %><!--��ü ��ü�� ȣ���� ������ ȭ�鿡 ����Ҽ� �ִ� ���� ���� -->
		i = <%="3" + 4 %>
		
		<p>
		i = ${ia }
		i = ${ia > 4}
		i = ${ia + 4}

</body>
</html>