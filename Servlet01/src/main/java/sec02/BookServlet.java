package sec02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/bookInsert")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

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
	
	// 클라이언트의 <form> 태그를 통해 데이터 전달받아서 콘솔창에 출력
	// request : 클라이언트 -> 서버로 오는 데이터
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 데이터 인코딩
		request.setCharacterEncoding("utf-8");
		
		// <form> 태그 안에 입력된 데이터 받아오기
		// 파라미터 : bookForm.html에서 받아오고자 하는 데이터의 name 속성값
		String bookNo = request.getParameter("book_no");
		String bookName = request.getParameter("book_name");
		String bookAuthor = request.getParameter("book_author");
		String bookPrice = request.getParameter("book_price");
		String bookDate = request.getParameter("book_date");
		String bookStock = request.getParameter("book_stock");
		String bookPubNo = request.getParameter("book_pubNo");
		
		System.out.println("도서번호 : " + bookNo);
		System.out.println("도서명 : " + bookName);
		System.out.println("저자 : " + bookAuthor);
		System.out.println("가격 : " + bookPrice);
		System.out.println("발행일 : " + bookDate);
		System.out.println("재고 : " + bookStock);
		System.out.println("출판사번호 : " + bookPubNo);
	}

}
