package kr.co.happy2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.happy.BoardDAO;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int btype = Integer.parseInt(request.getParameter("btype"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteBoard(btype, seq);
		response.sendRedirect("boardList?btype=" +btype);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
