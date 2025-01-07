package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;

@WebServlet("/Mproc2")
public class MemberJoinProc2 extends HttpServlet {

	/*
	//����� Post�� request, response �� �ΰ� �۰� ���� ���Ѵ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response,MemberBean bean) throws ServletException, IOException {
		reqPro(request, response,bean);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response ,MemberBean bean) throws ServletException, IOException {
		reqPro(request, response,bean);
		
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response ,MemberBean bean) throws ServletException, IOException {
		System.out.println("id ="+bean.getId());
		System.out.println("id ="+request.getParameter("id"));
	}
	*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberBean bean = new MemberBean();
		bean.setId(request.getParameter("id"));
		bean.setPassword(request.getParameter("password"));
		bean.setEmail(request.getParameter("email"));
		bean.setTel(request.getParameter("tel"));
		bean.setAddress(request.getParameter("address"));
		
		//request��ü�� beanŬ������ �߰�
		request.setAttribute("bean", bean);
		
		RequestDispatcher dis =request.getRequestDispatcher("MemberView.jsp");
		dis.forward(request , response);
	}
}
