package sec02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	// Ŭ���̾�Ʈ�� <form> �±׸� ���� ������ ���޹޾Ƽ� �ܼ�â�� ��� (������ ��û�Ǵ� ���븸 ���)
	// request : Ŭ���̾�Ʈ -> ������ ���� ������
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �ѱ� ������ ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// <form> �±� �ȿ� �Էµ� ������ �޾ƿ���
		// �Ķ���� : login.html���� �޾ƿ����� �ϴ� �������� name �Ӽ���
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("���̵� : " + id);
		System.out.println("��й�ȣ : " + pw);
	}

}
