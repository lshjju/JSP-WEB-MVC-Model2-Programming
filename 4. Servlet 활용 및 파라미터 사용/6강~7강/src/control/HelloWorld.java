package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloWorld")//            /HelloWorld��� �ּ� url�� ǥ�����־�� �� ���� Ŭ������ ����˴ϴ� 
public class HelloWorld extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}
	
	//�ϰ�ó�� ��, doget�̴� dopost�� �Ʒ� reqpro�޼ҵ尡 ����ǰ� ����
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//ȭ�鿡 HelloWorld��� ����� �ϰ� �;��...jsp������ �Ѱ��� �����͸� ���� 
		String msg ="Hello World ~~ �ȳ��ϼ���";
		Integer data = 12;
		
		
		//jsp������ �����͸� request�� �����Ͽ� �Ѱ���
		request.setAttribute("msg", msg);
		request.setAttribute("data", data);
		
		
		//�������� jsp�� ȣ���ϸ鼭 �����͸� ���� �Ѱ��ִ� ��ü�� ����
		RequestDispatcher rd = request.getRequestDispatcher("HelloWorld.jsp");//jsp ���� ���� ���
		rd.forward(request,response);
	}
}