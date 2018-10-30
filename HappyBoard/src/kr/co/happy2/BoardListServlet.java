package kr.co.happy2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.happy.BoardDAO;
import kr.co.happy.BoardVO;

@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String btype = request.getParameter("btype");
		int intBtype = 1;

		if (btype != null) {
			intBtype = Integer.parseInt(btype);
		}
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardVO> list = dao.getList(intBtype);

		request.setAttribute("list", list);
		request.setAttribute("template", "list");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
