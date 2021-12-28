package sec05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookSelectServlet
 */
@WebServlet("/bookSelect")
public class BookSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// (1) ��û ����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		// (2) ����Ͻ� ���� ó�� : DAO ȣ���ϰ� ��� �޾ƿ�
		BookDAO dao = new BookDAO();
		
		ArrayList<BookVO> bookList = dao.bookSelect();
		
		
		// (3) ���� ó�� : Ŭ���̾�Ʈ���� ��� ����
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>������ȣ</td><td>������</td><td>����</td>" 
				+ "<td>����</td><td>������</td><td>���ǻ��ȣ</td></tr>");
		
		for(int i=0; i<bookList.size(); i++) {
			BookVO vo = (BookVO) bookList.get(i);
			String no = vo.getNo();
			String name = vo.getName();
			String author = vo.getAuthor();
			int price = vo.getPrice();
			Date date = vo.getDate();
			String pubNo = vo.getPubNo();
			
			// �� �྿ ���
			out.print("<tr><td>" + no + "</td><td>" +
							     name + "</td><td>" +
								 author + "</td><td>" +
							     price + "</td><td>" +
							     date + "</td><td>" +
								 pubNo + "</td></tr>");
		}
		
		out.print("</table></body></html>");
	}
}
