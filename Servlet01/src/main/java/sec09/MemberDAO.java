package sec09;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con = null;
	DataSource dataSource = null;
	
	// �����ڿ��� DB ���� ����
	public MemberDAO() {
		try {
			Context init = new InitialContext();
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DB ���� ����");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	// ȸ�� ���� ��ȸ �޼ҵ� (��ü ȸ�� ���� SELECT �ؼ� ��ȯ : MemberVO ��ȯ)
	//MemberVO�� ���� �� ��ȯ : ArrayList<MemberVO>
	public ArrayList<MemberVO> memberSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			con = dataSource.getConnection();
			
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
	
	
	// ȸ�� ���� ����ϴ� �޼ҵ� : memberInsert()
	public void memberInsert(MemberVO vo){
		
		//sql�� values�� �� ������ ����
			
		try {
			con = dataSource.getConnection();
			
			//String sql = "insert into member values(?, ?, ?, ?, default)";
			String sql = "insert into member (memId, memPwd, memName, memEmail)  values(?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId()); 
			pstmt.setString(2, vo.getPwd()); 
			pstmt.setString(3, vo.getName()); 
			pstmt.setString(4,  vo.getEmail());
			
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
	
	
	// ȸ�� ���� ���� �޼ҵ�
	public void memberDelete(String id ) {
		
		try {
			con = dataSource.getConnection();
			
			String sql = "delete from member where memId=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id); 
			
			// ������ ���� : ������ ���� ���� �� ��ȯ
			//select : executeQuery - ��� �� resultSet ��ȯ.
			//insert / update / delete : executeUpdate() - ������ ���� ���� �� ��ȯ
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("ȸ�� ���� ���� ����!");
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