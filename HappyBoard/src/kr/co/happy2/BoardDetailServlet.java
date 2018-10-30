package kr.co.happy2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.happy.BoardDAO;
import kr.co.happy.BoardVO;

@WebServlet("/boarddetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int btype = Integer.parseInt(request.getParameter("btype"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.getDetail(btype, seq);

		request.setAttribute("vo", vo);
		request.setAttribute("template", "detail");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int btype = Integer.parseInt(request.getParameter("btype"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");

		BoardDAO dao = BoardDAO.getInstance();
		dao.update(btype, seq, btitle, bcontent);

		response.sendRedirect("dedail?btype=" + btype + "&seq" + seq); // 이사이트에
																		// 그냥
																		// 보내땔

	}

}
