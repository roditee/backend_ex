package sec01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		if(user_id!=null && user_id.length()!=0) {
		String data = "<html><body>";
		data+="�ȳ��ϼ���!<br> �α����ϼ̽��ϴ�.<br><br>";
		data+="���̵� :" + user_id + "<br>";
		data+="��й�ȣ :" + user_pw + "<br>";
		data+="�ּ� :" + user_address + "<br>";
		data+="�̸��� :" + user_email + "<br>";
		data+="�޴���ȭ :" + user_hp;
		data+="</body></html>";
		out.print(data);
		
		// URL Rewriting ��� �̿�
		user_address = URLEncoder.encode(user_address, "utf-8");
		out.print("<a href='/Servlet02/second?user_id=" + user_id
					+ "&user_pw=" + user_pw
					+ "&user_address=" + user_address
					+ "'><br>�� ��° �������� ������</a>");
		data = "</body></html>";
		} else {
			out.println("�α��� ���� �ʾҽ��ϴ�.<br><br>");
			out.println("�ٽ� �α��� �ϼ���<br><br>");
			out.println("<a href='/Servlet02/login.html'>");
		}
	}

}
