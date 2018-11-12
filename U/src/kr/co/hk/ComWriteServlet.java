package kr.co.hk;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/companyWrite")
public class ComWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BoardDAO dao = BoardDAO.getInstance();
		int com_no = dao.getIndexCom_no();
		
		request.setAttribute("com_no", com_no);
		request.setAttribute("template", "companyWrite");
		
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardDAO dao = BoardDAO.getInstance();
		int com_no = Integer.parseInt(request.getParameter("com_no"));
		System.out.println("com_no");
		String com_name = request.getParameter("com_name");
		System.out.println("com_name");
		String com_addr = request.getParameter("com_addr");
		System.out.println("com_addr");
		dao.companyInsert(com_no, com_name, com_addr);
		
		response.sendRedirect("carWrite");
		
		
	}

}
