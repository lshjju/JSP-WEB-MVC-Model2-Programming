<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h2> ��� ���� </h2>
	<% 
			// request.setAttribute("exp1",${pram.exp1});
			//String exp1 = request.getParameter("exp1");
			//String exp2 = request.getParameter("exp2");
			//String exp3 = request.getParameter("exp3");
		
			//int result = 0;
		
			//if(exp1.equals("+")){
			//	result = Integer.parseInt(exp1) + Integer.parseInt(exp3);
			//}
		
			//request.setAttribute("exp1",exp1);
			//request.setAttribute("exp2",exp2);
			//request.setAttribute("exp3",exp3);
			//����� ${exp1 exp2 exp3}
	%>
	
	<% 
		String exp2 = request.getParameter("exp2");
	
		if(exp2.equals("+")){
	%>
		�����  ${param.exp1 + param.exp3}
	<% 
		}
		 if(exp2.equals("-")){
	%>
		�����  ${param.exp1 - param.exp3}
	<% 
		}
	
		 if(exp2.equals("*")){
	%>
		�����  ${param.exp1 * param.exp3}
	<% 
		}
	 	if(exp2.equals("/")){
	%>
		�����  ${param.exp1 / param.exp3}
	<% 
		}
	%>
	
	�����  ${param.exp1} , ${param.exp2} , ${param.exp3}
	</center>
</body>
</html>