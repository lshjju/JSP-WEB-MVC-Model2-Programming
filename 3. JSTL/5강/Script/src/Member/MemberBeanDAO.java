package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;


//����Ŭ ������ ���̽��� �����ϰ� select, insert , update , delete �۾��� ������ �ִ� Ŭ���� �Դϴ�.
public class MemberBeanDAO{

    
    ResultSet rs; //������ ���̽��� ���̺��� ����� ���� �޾� �ڹٿ� ������ �ִ� ��ü
    Connection conn;//�����ͺ��̽��� �����Ҽ� �ֵ��� ���� 
    PreparedStatement pstmt;//������ ���̽����� ������ ��������ִ� ��ü 
	
   
   //������ ���̽��� �����Ҽ� �ֵ��� �����ִ� �޼ҵ�
	public void getcon() {
		 try{
				//����Ŭ�� �����ϴ� �ҽ��� �ۼ�
			    String dbID = "root";//���� ���̵�
			    String dbPassword = "root";
			    String dbURL = "jdbc:mysql://localhost:3306/MEMBER?useSSL=false";
			    
		   		//1.�ش� ������ ���̽��� ����Ѵٰ� ����(Ŭ������ ��� = ����Ŭ�� ���) 	
			    Class.forName("com.mysql.jdbc.Driver");
		   		//2.�ش� ������ ���̽��� ����
			    conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		   		
		   		
		    }catch(Exception e){
		    	e.printStackTrace();
		   	}
		   
	}
	
	//������ ���̽��� �ѻ���� ȸ�� ������ �������ִ� �żҵ�
	public void insertMember(MemberBean mbean){
		try {
		getcon();
		String SQL = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?)";
		//������ ����ϵ��� ���� 
			pstmt = conn.prepareStatement(SQL);
			//?�� �°� �����͸� ����
			pstmt.setString(1,mbean.getId());
			pstmt.setString(2,mbean.getPass1());
			pstmt.setString(3,mbean.getEmail());
			pstmt.setString(4,mbean.getTel());
			pstmt.setString(5,mbean.getHobby());
			pstmt.setString(6,mbean.getJob());
			pstmt.setString(7,mbean.getAge());
			pstmt.setString(8,mbean.getInfo());
			//4.����Ŭ���� ������ ���� �Ͻÿ� 
			pstmt.executeUpdate();//insert,update,delete �� ����ϴ� �޼ҵ� 
			//5.�ڿ� �ݳ� 
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();	
		}
	}
	
	
	//��� ȸ���� ������ ������ �ִ� �żҵ� ȣ�� 
	public Vector<MemberBean> allSelectMember(){
		//�������̷� �����͸� ����
		Vector<MemberBean> v = new Vector<>();
		
		//������ ������ ���̽��� ���� ó���� �ݵ�� �ؾ� �մϴ�.
		 try{
			 //Ŀ�ؼ� ���� 
			 getcon();
			 
			 //���� �غ� 
			 String SQL = "SELECT * FROM MEMBER";
			 
			 //������ ���� �����ִ� ��ü ���� 
			 pstmt = conn.prepareStatement(SQL);
			 
			 //�޼ҵ� �� �ܿ��
			 //������ ���� ��Ų ����� �����ؼ� �޾���(����Ŭ�� ���̺��� �˻��� ����� �ڹ� ��ü�� ����) 
			 rs = pstmt.executeQuery();
			 
			 //�ݺ����� ����ؼ� rs�� ����� �����͸� ������ ���ƾ��մϴ�
			 while(rs.next()){//����� ������ ��ŭ���� �ݺ����� �����ڴٴ� �� �Դϴ�. 
				 MemberBean bean = new MemberBean(); //�÷����� �������� �����͸� �� Ŭ������ ���� 
				 bean.setId(rs.getString(1));
				 bean.setPass1(rs.getString(2));
				 bean.setEmail(rs.getString(3));
				 bean.setTel(rs.getString(4));
				 bean.setHobby(rs.getString(5));
				 bean.setJob(rs.getString(6));
				 bean.setAge(rs.getString(7));
				 bean.setInfo(rs.getString(8));	 
				 //��Ű¡�� memberbeanŬ������ ���Ϳ� ���� 
				 v.add(bean);//0���� ���� ������� �����Ͱ� ����
			 }
			 //�ڿ� �ݳ�
			 conn.close();
			 
		    }catch(Exception e){
		    	e.printStackTrace();
		   	}
		 
		 	//�� ����� ���͸� ����
		 	return v;	
	}
	
	
	public MemberBean oneSelectMember(String id){
		//�ѻ���� ���� ������ �����ϱ⿡ ��Ŭ���� ��ü ����
		MemberBean bean = new MemberBean();
		//������ ������ ���̽��� ���� ó���� �ݵ�� �ؾ� �մϴ�.
		 try{
			 //Ŀ�ؼ� ���� 
			 getcon();
			 
			 //���� �غ� 
			 String SQL = "SELECT *FROM MEMBER WHERE id= ?";
			 //������ ���� �����ִ� ��ü ���� 
			 pstmt = conn.prepareStatement(SQL);		 
			 //?�� ���� ���� 
			 pstmt.setString(1,id);
			 //���� ���� 
			 rs = pstmt.executeQuery();
			 if(rs.next()){//���ڵ尡 �ִٸ� 
				 bean.setId(rs.getString(1));
				 bean.setPass1(rs.getString(2));
				 bean.setEmail(rs.getString(3));
				 bean.setTel(rs.getString(4));
				 bean.setHobby(rs.getString(5));
				 bean.setJob(rs.getString(6));
				 bean.setAge(rs.getString(7));
				 bean.setInfo(rs.getString(8));	 		 
			 }
			 
			 //�ڿ� �ݳ�
			 conn.close();
			 
		    }catch(Exception e){
		    	e.printStackTrace();
		   	}	
		 //���� 
		return bean;	
	}
	
	//�� ȸ���� �н����� ���� �����ϴ� �޼ҵ� �ۼ�
	public String getPass1(String id){
		//��Ʈ������ ������ �ؾ��ϱ⿡ ��Ʈ�� ���� ����
		String pass="";
		try {
		 //Ŀ�ؼ� ���� 
		 getcon();
		 //���� �غ� 
		 String SQL = "SELECT pass1 FROM MEMBER WHERE id= ?";
		 //������ ���� �����ִ� ��ü ���� 
		 pstmt = conn.prepareStatement(SQL);		 
		 //?�� ���� ���� 
		 pstmt.setString(1,id);
		 //���� ���� 
		 rs = pstmt.executeQuery();
		 
		 if(rs.next()){
			 pass=rs.getNString(1);	 
		 }
		 
		 //�ڿ� �ݳ�
		 conn.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	   	}	
		//���� 
		return pass;	
	}
	
	//�� ȸ���� ������ �����ϴ� �żҵ� 
	public void updateMember(MemberBean bean){
		getcon();
		try {
		 //���� �غ� 
		 String SQL = "UPDATE MEMBER SET email=?,tel=? WHERE id=?";
		 //������ ���� �����ִ� ��ü ���� 
		 pstmt = conn.prepareStatement(SQL);		 
		 //?�� ���� ���� 
		 pstmt.setString(1,bean.getEmail());
		 pstmt.setString(2,bean.getTel());
		 pstmt.setString(3,bean.getId());
		 //���� ���� 
		 pstmt.executeUpdate();
		 //�ڿ� �ݳ�
		 conn.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	   	}	
	}
	
	//��ȸ���� �����ϴ� �޼ҵ� �ۼ� 
	public void deleteMember(String id) {
		getcon();

		try {
		 //���� �غ� 
		 String SQL = "DELETE FROM MEMBER WHERE id=?";
		 //������ ���� �����ִ� ��ü ���� 
		 pstmt = conn.prepareStatement(SQL);		 
		 //?�� ���� ���� 
		 pstmt.setString(1,id);
		 //���� ���� 
		 pstmt.executeUpdate();
		 //�ڿ� �ݳ�
		 conn.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	   	}	
	}
}