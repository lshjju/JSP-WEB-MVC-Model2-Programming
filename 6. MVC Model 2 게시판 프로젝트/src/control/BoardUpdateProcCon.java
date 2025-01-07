package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;


@WebServlet("/BoardUpdateProcCon.do")
public class BoardUpdateProcCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request ,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request ,response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");

		int num = Integer.parseInt(request.getParameter("num"));
		String password = request.getParameter("password");
		String pass = request.getParameter("pass");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		
		
		//password값과 pass값을 비교 해야합니다
		if(password.equals(pass)) {//패스워가 같다면 데이터를 수정
			BoardDAO bdao = new BoardDAO();
			bdao.updateBoard(num,subject,content);
			
			//수정이 완료 되었다면 전체 게시글 보기로 이동 
			request.setAttribute("msg","수정이 완료 되었습니다");
			
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
			dis.forward(request ,response);
		}else {
			//비밀번호가 틀렸다면 이전 페이지로 이동
			request.setAttribute("msg","수정시 비밀번호가 맞지 않습니다");
			RequestDispatcher dis = request.getRequestDispatcher("BoardListCon.do");
			dis.forward(request ,response);
		}
	}
}
