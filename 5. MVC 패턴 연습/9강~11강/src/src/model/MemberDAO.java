package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDAO {
    ResultSet rs; //데이터 베이스의 테이블의 결과를 리턴 받아 자바에 저장해 주는 객체
    Connection con;//데이터베이스에 접근할수 있도록 설정 
    PreparedStatement pstmt;//데이터 베이스에서 쿼리를 실행시켜주는 객체 

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
    
    
    //회원 한사람에 대한 정보를 저장하는 메소드 
    public void insertMember(MemberBean bean) {
    	getcon();
    	
    	try {
    		//쿼리 준비 
    		String sql ="insert into member values(?,?,?,?,?,?,?,?)";
    		
    		//쿼리 실행창 객체 선언 
    		pstmt  = con.prepareStatement(sql); 
    		
    		//?에 대입
    		pstmt.setString(1, bean.getId());
    		pstmt.setString(2, bean.getPass1());
    		pstmt.setString(3, bean.getEmail());
    		pstmt.setString(4, bean.getTel());
    		pstmt.setString(5, bean.getHobby());
    		pstmt.setString(6, bean.getJob());
    		pstmt.setString(7, bean.getAge());
    		pstmt.setString(8, bean.getInfo());
    		//쿼리 실행
    		pstmt.executeUpdate();
    		con.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    	
	//모든회원의 정보를 리턴하는 메소드 작성
   public Vector<MemberBean> getAllMember(){
	   //리턴 타입 선언
	   Vector<MemberBean> v = new Vector<>();
	   getcon();
	   
	   	try {
    		//쿼리 준비 
    		String sql ="select * from member";
    		
    		//쿼리 실행창 객체 선언 
    		pstmt  = con.prepareStatement(sql); 
    		
    		//쿼리 실행
    		rs = pstmt.executeQuery();
    		
    		//반복문을 돌면서 회원 정보를 저장
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
    			//벡터에 빈클래스를 저장  
    			v.add(bean);
    		}
    		con.close();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	   return v;
   }
	
	

}
