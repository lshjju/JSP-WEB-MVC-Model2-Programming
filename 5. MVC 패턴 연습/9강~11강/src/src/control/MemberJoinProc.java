package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberBean;
import model.MemberDAO;

@WebServlet("/Proc.do")
public class MemberJoinProc extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}	
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ� ó�� 
		request.setCharacterEncoding("UTF-8");
		
		MemberBean bean = new MemberBean();
		bean.setId(request.getParameter("id"));
		
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		
		bean.setPass1(pass1);
		bean.setPass2(pass2);
		
		bean.setEmail(request.getParameter("email"));
		bean.setTel(request.getParameter("tel"));
		
		String [] arr = request.getParameterValues("hobby");
		String data="";
		
		for(String string : arr) {
			data += string + " ";//�ϳ��� ��Ʈ������ ������ ���� 
		}
		
		bean.setHobby(data);
		bean.setJob(request.getParameter("job"));
		bean.setAge(request.getParameter("age"));
		bean.setInfo(request.getParameter("info"));
		
		
		//�е���尡 ���� ��쿡�� ������ ���̽��� ���� 
		if(pass1.equals(pass2)){
			//������ ���̽� ��ü ����
			MemberDAO mdao = new MemberDAO();
			mdao.insertMember(bean);
			//��Ʈ�ѷ����� �Ǵٸ� ��Ʈ�ѷ��� ȣ���� �־�� �մϴ�. 
			RequestDispatcher dis = request.getRequestDispatcher("/MemberlistCon.do");
			dis.forward(request, response);
			
		}else {
			request.setAttribute("msg","�н����尡 ��ġ���� �ʽ��ϴ�");
			RequestDispatcher dis = request.getRequestDispatcher("LoginError.jsp");
			dis.forward(request, response);
		}
	}
	
	/*
	 1. �żҵ� 
	 2. �żҵ� 
	 3. �żҵ� 
	 ......
	 */
}
