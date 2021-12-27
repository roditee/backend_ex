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
		System.out.println("init �޼��� ȣ��");
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
	
	// Ŭ���̾�Ʈ�� <form> �±׸� ���� ������ ���޹޾Ƽ� �ܼ�â�� ���
	// request : Ŭ���̾�Ʈ -> ������ ���� ������
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �ѱ� ������ ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		// <form> �±� �ȿ� �Էµ� ������ �޾ƿ���
		// �Ķ���� : bookForm.html���� �޾ƿ����� �ϴ� �������� name �Ӽ���
		String bookNo = request.getParameter("book_no");
		String bookName = request.getParameter("book_name");
		String bookAuthor = request.getParameter("book_author");
		String bookPrice = request.getParameter("book_price");
		String bookDate = request.getParameter("book_date");
		String bookStock = request.getParameter("book_stock");
		String bookPubNo = request.getParameter("book_pubNo");
		
		System.out.println("������ȣ : " + bookNo);
		System.out.println("������ : " + bookName);
		System.out.println("���� : " + bookAuthor);
		System.out.println("���� : " + bookPrice);
		System.out.println("������ : " + bookDate);
		System.out.println("��� : " + bookStock);
		System.out.println("���ǻ��ȣ : " + bookPubNo);
	}

}
