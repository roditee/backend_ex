package sec03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginLogout
 */
@WebServlet("/logInOut")
public class LoginLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// ó�� �����̸�
		if(session.isNew()) {
			// user_id �Է� ���� ������
			if(user_id != null) {
				// (���� ù ���� + ���̵� ���� �ִ� ���)
				// SID �̸�, user_id ������ ���� ���� ����
				session.setAttribute("SID", user_id);
				// �ٽ� ������Ѽ� SID Ȯ��
				out.print("<a href='logInOut'>�α��� ���� Ȯ��</a>");				
			}else { // user_id �Է� ���� ������
				// (���� ù ���� + ���̵� ���� ���� ���)
				out.print("<a href='sessionLogin.html'>�ٽ� �α��� �ϼ���!</a>");
				session.invalidate(); // ���� �������ִ� ���� ������� -> �ٽ� �α����϶��
			}
			
		} else {   //�ƴϰ� ������ ������
			user_id = (String) session.getAttribute("SID"); // ������Ʈ ��ȯ�ϱ� ������ string ����ȯ
			if(user_id != null && user_id.length() != 0) {
				out.print("�ȳ��ϼ��� " + user_id + "��!!");
				out.print("<br><a href='logout'>�α׾ƿ�</a>");
			} else {
				out.print("<a href='sessionLogin.html'>�ٽ� �α��� �ϼ���!</a>");
				session.invalidate();
			}
		}
	}
}
