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
		<h2>ȸ�� ���� ���</h2>
		<form action="Mproc2"method="post">
			<table width="400" border="1" bordercolor="gray">
				<tr height ="40">
					<td width="150" align="center">���̵�</td>
					<td width="250"><input type="text" name ="id"></td>
				</tr>
			
				<tr height ="40">
					<td width="150" align="center" >�н�����</td>
					<td width="250"><input type="password" name ="password"></td>
				</tr>
				
				<tr height ="40">
					<td width="150" align="center">�̸��� </td>
					<td width="250"><input type="email" name ="email"></td>
				</tr>
				
				<tr height ="40">
					<td width="150" align="center">��ȭ</td>
					<td width="250"><input type="tel" name ="tel"></td>
				</tr>
				
				<tr height ="40">
					<td width="150" align="center">�ּ�</td>
					<td width="250"><input type="text" name ="address"></td>
				</tr>
			
				<tr height ="40">
					<td colspan="2" align="center"><input type="submit" value ="ȸ������"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>