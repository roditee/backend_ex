package sec07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import sec07.BookVO;

public class BookDAO {
	
	private Connection con = null;
	DataSource dataSource = null;
	// DB ���� ��� �޼ҵ� : DB �����ϰ� Connection ��ü ��ȯ
	public BookDAO(){
		
		try {
		
			Context init = new InitialContext();
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DB ���� ����!");

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// ȸ�� ���� ��ȸ �޼ҵ� (��ü ȸ�� ���� SELECT �ؼ� ��ȯ : MemberVO ��ȯ)
	//MemberVO�� ���� �� ��ȯ : ArrayList<MemberVO>
	public ArrayList<BookVO> bookSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		ArrayList<BookVO> bookList = new ArrayList<BookVO>();
		
		try {
			con = dataSource.getConnection();
			
			String query = "select * from book";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // ��� ��Ʈ���� �� �྿ ó��
				String no = rs.getString("book_no");
				String name = rs.getString("book_name");
				int price = rs.getInt("book_price");
				String author = rs.getString("book_author");
				Date date = rs.getDate("book_date");
				String pubNo = rs.getString("book_pubNo");
				
				// �� �� ���� �����ͼ� BookVO�� ���� : setter �޼ҵ� ���
				BookVO vo = new BookVO();
				vo.setBookNo(no);
				vo.setBookName(name);
				vo.setBookPrice(price);
				vo.setBookAuthor(author);
				vo.setBookDate(date);
				vo.setPubNo(pubNo);
				
				// �� BookVO�� ArrayList�� �߰�(����)
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
	
	public void bookInsert(BookVO bv){
			
		//sql�� values�� �� ������ ����
		
		try {
			con = dataSource.getConnection();
			
			String sql = "insert into book values(?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String newDate = sdf.format(bv.getBookDate());
			
			pstmt.setString(1, bv.getBookNo()); 
			pstmt.setString(2, bv.getBookName()); 
			pstmt.setInt(3, bv.getBookPrice()); 
			pstmt.setString(4,  bv.getBookAuthor());
			//pstmt.setDate(5, "");
			//new java.sql.Date(bv.getBookDate())
			pstmt.setString(5, newDate.toString());
			pstmt.setString(6,  bv.getPubNo());
			
			
			// ������ ���� : ������ ���� ���� �� ��ȯ
			//select : executeQuery - ��� �� resultSet ��ȯ.
			//insert / update / delete : executeUpdate() - ������ ���� ���� �� ��ȯ
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("������ �Է� ����!");
			}
			

			
			// ��� ��ü close() : ���ҽ� �ݳ�
	
			pstmt.close();
			con.close();			
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}		
	}
	
	
	public void bookDelete(String id){
		
		//sql�� values�� �� ������ ����
			
		try {
			con = dataSource.getConnection();
			
			String sql = "delete from book where bookNo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			// ������ ���� : ������ ���� ���� �� ��ȯ
			//select : executeQuery - ��� �� resultSet ��ȯ.
			//insert / update / delete : executeUpdate() - ������ ���� ���� �� ��ȯ
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("������ ���� ����!");
			}
			

			
			// ��� ��ü close() : ���ҽ� �ݳ�
	
			pstmt.close();
			con.close();			
			
		} catch (Exception e) {
			System.out.println("���� �߻�!");
			e.printStackTrace();
		}		
	}
	
}