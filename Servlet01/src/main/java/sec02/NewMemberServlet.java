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
		// 한글 데이터 인코딩
		request.setCharacterEncoding("utf-8");
		
		// <form> 태그 안에 입력된 데이터 받아오기
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("hp1")+request.getParameter("hp2")+request.getParameter("hp3");
		// 라디오 버튼
		String grade = request.getParameter("year");
		
		// 체크박스 : 동일한 name 속성으로 여러 개의 값이 전달되는 경우 배열로 받음
		String[] interest = request.getParameterValues("interest");
		
		// select
		String dpt = request.getParameter("department");
		
		
		System.out.println("이름 : " + name);
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pwd);
		System.out.println("휴대폰 번호 : " + phone);
		System.out.println("학년 : " + grade);
		System.out.print("관심분야 : ");
		for(int i=0; i<interest.length; i++) {
			System.out.print(interest[i] + " ");
		}
		System.out.println();
		System.out.println("학과 : " + dpt);
	}

}
