package kr.co.hk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		int c_no = Integer.parseInt(request.getParameter("c_no"));
		
		System.out.println(c_no);
		
		CarVO vo = dao.getDetail(c_no);

		request.setAttribute("vo", vo);
		request.setAttribute("template", "detail");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
	
//		 필요없음
//		String type = request.getParameter("type");
		
		int c_price = Integer.parseInt(request.getParameter("c_price"));
		int com_no = Integer.parseInt(request.getParameter("com_no"));
		
		System.out.println("c_price :"+ c_price);
		System.out.println(com_no);
		
		dao.updateCnt(c_price, com_no);
		
		response.sendRedirect("carList");
		
	}

}
