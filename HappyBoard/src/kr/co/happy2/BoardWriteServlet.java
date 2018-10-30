package kr.co.happy2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.happy.BoardDAO;


@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btype = request.getParameter("btype");
		request.setAttribute("btype", btype);
		
				//템플릿이라는 write라는 내용을 보여준다
		request.setAttribute("template", "write");
		
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int btype = Integer.parseInt(request.getParameter("btype"));
		
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String pw = request.getParameter("pw");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.insert(btype, btitle, bcontent, pw);
		
		response.sendRedirect("boardList?btype="+btype);
		
		
		
		
	}

}
