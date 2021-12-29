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
	// DB 연결 담당 메소드 : DB 연결하고 Connection 객체 반환
	public BookDAO(){
		
		try {
		
			Context init = new InitialContext();
			dataSource = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DB 연결 성공!");

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 회원 정보 조회 메소드 (전체 회원 정보 SELECT 해서 반환 : MemberVO 반환)
	//MemberVO를 여러 행 반환 : ArrayList<MemberVO>
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
			
			while(rs.next()) { // 결과 세트에서 한 행씩 처리
				String no = rs.getString("book_no");
				String name = rs.getString("book_name");
				int price = rs.getInt("book_price");
				String author = rs.getString("book_author");
				Date date = rs.getDate("book_date");
				String pubNo = rs.getString("book_pubNo");
				
				// 한 행 정보 가져와서 BookVO에 저장 : setter 메소드 사용
				BookVO vo = new BookVO();
				vo.setBookNo(no);
				vo.setBookName(name);
				vo.setBookPrice(price);
				vo.setBookAuthor(author);
				vo.setBookDate(date);
				vo.setPubNo(pubNo);
				
				// 각 BookVO를 ArrayList에 추가(저장)
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
			
		//sql문 values에 들어갈 데이터 설정
		
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
			
			
			// 쿼리문 실행 : 영향을 받은 행의 수 반환
			//select : executeQuery - 결과 행 resultSet 반환.
			//insert / update / delete : executeUpdate() - 영향을 받은 행의 수 반환
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("데이터 입력 성공!");
			}
			

			
			// 모든 객체 close() : 리소스 반납
	
			pstmt.close();
			con.close();			
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}		
	}
	
	
	public void bookDelete(String id){
		
		//sql문 values에 들어갈 데이터 설정
			
		try {
			con = dataSource.getConnection();
			
			String sql = "delete from book where bookNo = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			// 쿼리문 실행 : 영향을 받은 행의 수 반환
			//select : executeQuery - 결과 행 resultSet 반환.
			//insert / update / delete : executeUpdate() - 영향을 받은 행의 수 반환
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("데이터 삭제 성공!");
			}
			

			
			// 모든 객체 close() : 리소스 반납
	
			pstmt.close();
			con.close();			
			
		} catch (Exception e) {
			System.out.println("오류 발생!");
			e.printStackTrace();
		}		
	}
	
}