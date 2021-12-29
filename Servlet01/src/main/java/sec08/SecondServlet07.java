package sec08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet07
 */
@WebServlet("/second07")
public class SecondServlet07 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = (String) request.getAttribute("name");
		String address = (String) request.getAttribute("address");
		
		out.println("<html><body>");
		out.println("�̸� : " + name + "<br>");
		out.println("�ּ� : " + address);
		out.println("<br> dispatch �̿��� ���ε�");
		out.println("</body></html>");
		}

}
