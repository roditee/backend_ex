package sec02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieValue
 */
@WebServlet("/setCookie")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		// Cookie ��ü ���� �� cookieTest �̸����� �ѱ� ���� ���ڵ��Ͽ� ��Ű�� ����
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("Cookie �׽�Ʈ�Դϴ�.", "utf-8"));
		cookie.setMaxAge(24*60*60); // ��ȿ�Ⱓ ���� : �Ϸ� = 24�ð� * 60�� * 60��
		response.addCookie(cookie); // ������ ��Ű�� �������� �����Ͽ� ����
		out.println("���� �ð� : " + d);
		out.println("<br> Cookie�� ����");
	}

}
