package sec02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
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
		// �ѱ� ������ ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// <form> �±� �ȿ� �Էµ� ������ �޾ƿ���
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		// ���� ��ư
		String emailRcv = request.getParameter("emailRcv");
		
		// üũ�ڽ� : ������ name �Ӽ����� ���� ���� ���� ���޵Ǵ� ��� �迭�� ����
		String[] subject = request.getParameterValues("subject");
		
		// �ܼ�â�� ��� : ���̵�, ��й�ȣ, �̸��� ���� ����
		System.out.println("���̵� : " + id);
		System.out.println("��й�ȣ : " + pw);
		System.out.println("�̸��� ���� ���� : " + emailRcv);
		
		// �ܼ�â�� ��� : ������ ����
		for (int i=0; i<subject.length; i++) {
			System.out.print(subject[i] + " ");
		}
	}

}