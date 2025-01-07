package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDAO {
    ResultSet rs; //������ ���̽��� ���̺��� ����� ���� �޾� �ڹٿ� ������ �ִ� ��ü
    Connection con;//�����ͺ��̽��� �����Ҽ� �ֵ��� ���� 
    PreparedStatement pstmt;//������ ���̽����� ������ ��������ִ� ��ü 

    public void getcon() {
    	try {
    		String dbURL = "jdbc:oracle:thin:@DESKTOP-OHJGL9K:1522:xe";
    		String dbID = "c##BBC";
    		String dbPassword = "1234";
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		con = DriverManager.getConnection(dbURL, dbID, dbPassword);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    
    //ȸ�� �ѻ���� ���� ������ �����ϴ� �޼ҵ� 
    public void insertMember(MemberBean bean) {
    	getcon();
    	
    	try {
    		//���� �غ� 
    		String sql ="insert into member values(?,?,?,?,?,?,?,?)";
    		
    		//���� ����â ��ü ���� 
    		pstmt  = con.prepareStatement(sql); 
    		
    		//?�� ����
    		pstmt.setString(1, bean.getId());
    		pstmt.setString(2, bean.getPass1());
    		pstmt.setString(3, bean.getEmail());
    		pstmt.setString(4, bean.getTel());
    		pstmt.setString(5, bean.getHobby());
    		pstmt.setString(6, bean.getJob());
    		pstmt.setString(7, bean.getAge());
    		pstmt.setString(8, bean.getInfo());
    		//���� ����
    		pstmt.executeUpdate();
    		con.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    	
	//���ȸ���� ������ �����ϴ� �޼ҵ� �ۼ�
   public Vector<MemberBean> getAllMember(){
	   //���� Ÿ�� ����
	   Vector<MemberBean> v = new Vector<>();
	   getcon();
	   
	   	try {
    		//���� �غ� 
    		String sql ="select * from member";
    		
    		//���� ����â ��ü ���� 
    		pstmt  = con.prepareStatement(sql); 
    		
    		//���� ����
    		rs = pstmt.executeQuery();
    		
    		//�ݺ����� ���鼭 ȸ�� ������ ����
    		while(rs.next()) {
    			MemberBean bean =new MemberBean();
    			bean.setId(rs.getString(1));
    			bean.setPass1(rs.getString(2));
    			bean.setEmail(rs.getString(3));
    			bean.setTel(rs.getString(4));
    			bean.setHobby(rs.getString(5));
    			bean.setJob(rs.getString(6));
    			bean.setAge(rs.getString(7));
    			bean.setInfo(rs.getString(8));
    			//���Ϳ� ��Ŭ������ ����  
    			v.add(bean);
    		}
    		con.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	   return v;
   }
	
	

}
