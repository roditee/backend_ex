package sec06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sec04.MemberDAO;
import sec04.MemberVO;

/**
 * Servlet implementation class MemberSelectServlet2
 */
@WebServlet("/memberSelect2")
public class MemberSelectServlet2 extends HttpServlet {
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
		MemberDAO dao = new MemberDAO();
		
		ArrayList<MemberVO> memList = dao.memberSelect();
		
		
		// (3) ���� ó�� : Ŭ���̾�Ʈ���� ��� ����
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td>" 
				+ "<td>�̸���</td><td>������</td><td>����</td></tr>");
		
		for(int i=0; i<memList.size(); i++) {
			MemberVO vo = (MemberVO) memList.get(i);
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			Date joinDate = vo.getJoinDate();
			
			// �� �྿ ���
			out.print("<tr><td>" + id + "</td><td>" +
												     pwd + "</td><td>" +
													 name + "</td><td>" +
												     email + "</td><td>" +
													 joinDate + "</td><td>" +
												     "<a href='/Servlet01/memberDelete?id=" + id + "'>����</a></td></tr>");
													 		
		}
		
		out.print("</table></body></html>");
	}

}