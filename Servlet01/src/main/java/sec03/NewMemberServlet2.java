package sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewMemberServlet2
 */
@WebServlet("/newMember2")
public class NewMemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ŭ���̾�Ʈ ��û ó��
		// Ŭ���̾�Ʈ -> ������ ���۵Ǵ� ������ ���ڵ�
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// ���� ó��
		// HTML ���� �������� ������ ����
		// ���� -> Ŭ���̾�Ʈ�� setContextType
		response.setContentType("text/html;charset=utf-8");
		
		// �������� Ŭ���̾�Ʈ�� ������ ����
		// �ڹ� I/O ��Ʈ�� �̿�
		PrintWriter out = response.getWriter();
		// HTML ���� �������� ������ ����
		out.print("<html><head></head><body>");
		out.print("�̸� : " + name + "<br>");
		out.print("���̵� : " + id + "<br>");
		out.print("��й�ȣ : " + pwd + "<br>");
		out.print("</body></html>");
	}

}