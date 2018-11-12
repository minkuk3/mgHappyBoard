package kr.co.hk;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/carWrite")
public class CarWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<CompanyVO> list = dao.getComList();
		
		int c_no = dao.getIndexC_no();
				
		request.setAttribute("c_no", c_no);
		
		request.setAttribute("list", list);
		request.setAttribute("template", "carWrite");
		RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int c_no = Integer.parseInt(request.getParameter("c_no"));
		int com_no = Integer.parseInt(request.getParameter("com_no"));
		String c_name = request.getParameter("c_name");
		String c_type = request.getParameter("c_type");
		String c_regdate = request.getParameter("c_regdate");
		int c_price = Integer.parseInt(request.getParameter("c_price"));
		int c_cc = Integer.parseInt(request.getParameter("c_cc"));
		
		dao.insert(c_no, com_no, c_name, c_type, c_regdate, c_price, c_cc);
		
		response.sendRedirect("carList");
		
		
		
		
		
		
		
		
	}

}
