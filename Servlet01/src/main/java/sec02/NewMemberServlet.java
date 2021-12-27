package sec02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewMemberServlet
 */
@WebServlet("/newMember")
public class NewMemberServlet extends HttpServlet {
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
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("hp1")+request.getParameter("hp2")+request.getParameter("hp3");
		// ���� ��ư
		String grade = request.getParameter("year");
		
		// üũ�ڽ� : ������ name �Ӽ����� ���� ���� ���� ���޵Ǵ� ��� �迭�� ����
		String[] interest = request.getParameterValues("interest");
		
		// select
		String dpt = request.getParameter("department");
		
		
		System.out.println("�̸� : " + name);
		System.out.println("���̵� : " + id);
		System.out.println("��й�ȣ : " + pwd);
		System.out.println("�޴��� ��ȣ : " + phone);
		System.out.println("�г� : " + grade);
		System.out.print("���ɺо� : ");
		for(int i=0; i<interest.length; i++) {
			System.out.print(interest[i] + " ");
		}
		System.out.println();
		System.out.println("�а� : " + dpt);
	}

}