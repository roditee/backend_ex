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
		// Cookie 객체 생성 후 cookieTest 이름으로 한글 정보 인코딩하여 쿠키에 저장
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("Cookie 테스트입니다.", "utf-8"));
		cookie.setMaxAge(24*60*60); // 유효기간 설정 : 하루 = 24시간 * 60분 * 60초
		response.addCookie(cookie); // 생성한 쿠키를 브라우저로 전송하여 저장
		out.println("현재 시간 : " + d);
		out.println("<br> Cookie에 저장");
	}

}
