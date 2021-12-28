package sec04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MemberDAO {
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
	public ArrayList<MemberVO> memberSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			con = connDB();
			
			String query = "select * from member";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // ��� ��Ʈ���� �� �྿ ó��
				// �� ��(ȸ�� 1����) ó�� 
				String id = rs.getString("memId");
				String pwd = rs.getString("memPwd");
				String name = rs.getString("memName");
				String email = rs.getString("memEmail");
				Date joinDate = rs.getDate("memJoinDate");
				
				// �� �� ���� �����ͼ� MemberVO�� ���� : setter �޼ҵ� ���
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				// �� MemberVO�� ArrayList�� �߰�(����)
				memList.add(vo);				
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
		
		return memList;		
	}
	
}