package sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class BookDAO {
	// DB ���� ��� �޼ҵ� : DB �����ϰ� Connection ��ü ��ȯ
		private Connection connDB() {
			Connection con = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost:3306/servletdb?serverTimezone=UTC";
				String user = "root";
				String pwd = "1234";
				
				con = DriverManager.getConnection(url, user, pwd);
				
				if(con != null) {
					System.out.println("DB ���� ����!");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return con;		
		}
		
		// ȸ�� ���� ��ȸ �޼ҵ� (��ü ȸ�� ���� SELECT �ؼ� ��ȯ : MemberVO ��ȯ)
		//MemberVO�� ���� �� ��ȯ : ArrayList<MemberVO>
		public ArrayList<BookVO> bookSelect(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			
			ArrayList<BookVO> bookList = new ArrayList<BookVO>();
			
			try {
				con = connDB();
				
				String query = "select * from book";
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				while(rs.next()) { // ��� ��Ʈ���� �� �྿ ó��
					// �� ��(ȸ�� 1����) ó�� 
					String no = rs.getString("book_no");
					String name = rs.getString("book_name");
					String author = rs.getString("book_author");
					int price = rs.getInt("book_price");
					Date date = rs.getDate("book_date");
					String pubNo = rs.getString("book_pubNo");
					
					// �� �� ���� �����ͼ� MemberVO�� ���� : setter �޼ҵ� ���
					BookVO vo = new BookVO();
					vo.setNo(no);
					vo.setName(name);
					vo.setAuthor(author);
					vo.setPrice(price);
					vo.setDate(date);
					vo.setPubNo(pubNo);
					
					// �� MemberVO�� ArrayList�� �߰�(����)
					bookList.add(vo);				
				}		
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				try {
					rs.close();
					pstmt.close();
					con.close();				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return bookList;		
		}
}