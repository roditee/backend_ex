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
		// 클라이언트 요청 처리
		// 클라이언트 -> 서버로 전송되는 데이터 인코딩
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 응답 처리
		// HTML 문서 형식으로 데이터 전송
		// 서버 -> 클라이언트로 setContextType
		response.setContentType("text/html;charset=utf-8");
		
		// 서버에서 클라이언트로 데이터 전송
		// 자바 I/O 스트림 이용
		PrintWriter out = response.getWriter();
		// HTML 문서 형식으로 데이터 전송
		out.print("<html><head></head><body>");
		out.print("이름 : " + name + "<br>");
		out.print("아이디 : " + id + "<br>");
		out.print("비밀번호 : " + pwd + "<br>");
		out.print("</body></html>");
	}

}
