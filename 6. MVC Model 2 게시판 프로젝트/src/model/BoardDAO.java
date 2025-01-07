package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.BoardBean;

public class BoardDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	
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
	
	//��ü �Խñ��� ������ �����ϴ� �޼ҵ� 
	public int getAllCount(){
		int count = 0;
		getcon();
		
		try {
			//���� �غ� 
			String sql ="select count(*) from board";
			pstmt =con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count = rs.getInt(1);
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return count;
		
	}
	
	
	//��� ȭ�鿡 ������ ������ 10���� �����ؼ� �����ϴ� �żҵ�
	public Vector<BoardBean> getAllBoard(int startRow , int endRow){
		Vector<BoardBean> v = new Vector<>();
		getcon();
		try {
			//���� �غ� 
			String SQL = "select * from (select A.* ,Rownum Rnum from (select *from board order by ref desc ,re_stop asc)A)"
					+ "where Rnum >= ? and Rnum <= ?";
			
			//�������� ��ü 
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1,startRow);
			pstmt.setInt(2,endRow);
			
			//������ ������ ����� ����
			rs = pstmt.executeQuery();	
			
			//������ ������ ����� �𸣱⿡ �ݺ����� �̿��Ͽ� �����͸� ���� 
			while(rs.next()){
				 //�����͸� ��Ű¡(���� = BoardbeanŬ������ �̿�)����
				 BoardBean bean = new BoardBean();
				 bean.setNum(rs.getInt(1));
				 bean.setWrite(rs.getString(2));
				 bean.setEmail(rs.getString(3));
				 bean.setSubject(rs.getString(4));
				 bean.setPassword(rs.getString(5));
				 bean.setReg_date(rs.getDate(6).toString());
				 bean.setRef(rs.getInt(7));
				 bean.setRe_stop(rs.getInt(8));
				 bean.setRe_level(rs.getInt(9));
				 bean.setReadcount(rs.getInt(10));
				 bean.setContent(rs.getString(11));
				 //��Ű¡�� �����͸� ���Ϳ� ���� 
				 v.add(bean);
			 }
			con.close();
			
			}catch(Exception e) {
				e.printStackTrace();	
			}	
			return v;
	}
	
	
	public void insertBoard(BoardBean bean) {
		getcon();
		//�� Ŭ������ �Ѿ���� �ʾҴ� �����͵��� �ʱ�ȭ ���־�� �մϴ�.
		int ref = 0;// �� �׷��� �ǹ� = ������ ������� ����ū ref ���� �������� +1�� �����ָ� �ȴ� 
		int re_stop = 1;//�����̱⿡ = �θ� ���̱⿡
		int re_level = 1;
		try {
			//����ū ref���� �о���� ���� �غ� 
			String refSQL = "SELECT max(ref) FROM BOARD";
			//�������� ��ü 
			pstmt = con.prepareStatement(refSQL);
			//������ ������ ����� ����
			 rs = pstmt.executeQuery();	
			if(rs.next()){//��� ���� �ִٸ�
				ref = rs.getInt(1)+1;//�ִ� ���� +1�� ���ؼ� �� �׷��� ����	
			}
			//������ �Խñ� ��ü���� ���̺� ���� 
			String SQL = "INSERT INTO BOARD VALUES(board_seq.NEXTVAL,?,?,?,?,sysdate,?,?,?,0,?)";
			pstmt = con.prepareStatement(SQL);
			//?�� ���� ����
			pstmt.setString(1, bean.getWrite());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getSubject());
			pstmt.setString(4, bean.getPassword());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_stop);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, bean.getContent());		
			//������ �����Ͻÿ�
			pstmt.executeUpdate();	
			//�ڿ� �ݳ�
			con.close();
			}catch(Exception e) {
				e.printStackTrace();	
			}	
	}
	
	
	//BoardInfo �ϳ��� �Խñ� �����ϴ� �޼ҵ�
	public BoardBean getOneBoard(int num){	
		//���� Ÿ�� ����
		BoardBean bean = new BoardBean();
		getcon();
		try {
			//��ȸ�� ���� ���� 
			String readsql = "update board set readcount = readcount+1 where num=?";
			pstmt = con.prepareStatement(readsql);
			pstmt.setInt(1,num);
			pstmt.executeUpdate();	
				
			//�����غ�
			String SQL = "select * from board where num=?";
			//�������ఴü 
			//�������� ��ü 
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1,num);
			//���� ������ ����� ����
			rs= pstmt.executeQuery();
				
			if(rs.next()) {
				bean.setNum(rs.getInt(1));
				bean.setWrite(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_stop(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				}
				
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			return bean;
		}
	
	
	//�亯���� ����Ǵ� �޼ҵ� 
	public void reWriteBoard(BoardBean bean){
		//�θ�� �׷�� �۷��� �� ������ �о�帲 
		int ref =bean.getRef();
		int re_stop = bean.getRe_stop();
		int re_level = bean.getRe_level();
		
		getcon();
		
		try {
			/////////////////////�ٽ� �ڵ� //////////////////////// 
				//�θ�� ���� ū re_level�� ���� ���� 1�� ���������� 
				String  levelsql = "update board set re_level=re_level+1 where ref=? and re_level > ?";
				//���� ���� ��ü ���� 
				pstmt = con.prepareStatement(levelsql);
				pstmt.setInt(1 , ref);
				pstmt.setInt(2 , re_level);
				//���� ���� 
				pstmt.executeUpdate();
				//�亯�� �����͸� ����
				String sql ="insert into board values(board_seq.NEXTVAL,?,?,?,?,sysdate,?,?,?,0,?)";
				pstmt = con.prepareStatement(sql);
				//?�� ���� ����
				pstmt.setString(1, bean.getWrite());
				pstmt.setString(2, bean.getEmail());
				pstmt.setString(3, bean.getSubject());
				pstmt.setString(4, bean.getPassword());
				pstmt.setInt(5, ref);//�θ��� ref ���� �־��� 
				pstmt.setInt(6, re_stop+1);//����̱⿡ �θ�� re_stop�� 1�� �־��� 
				pstmt.setInt(7, re_level + 1);
				pstmt.setString(8, bean.getContent());
				
				//������ �����Ͻÿ�
				pstmt.executeUpdate();	
				con.close();
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//Boardupdate�� Delete�� �ϳ��� �Խñ��� ����
	public BoardBean getOneUpdateBoard(int num){	
		//���� Ÿ�� ����
		BoardBean bean = new BoardBean();
		getcon();
		try {
			//�����غ�
			String SQL = "select * from board where num=?";
			//�������ఴü 
			//�������� ��ü 
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1,num);
			//���� ������ ����� ����
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				 bean.setNum(rs.getInt(1));
				 bean.setWrite(rs.getString(2));
				 bean.setEmail(rs.getString(3));
				 bean.setSubject(rs.getString(4));
				 bean.setPassword(rs.getString(5));
				 bean.setReg_date(rs.getDate(6).toString());
				 bean.setRef(rs.getInt(7));
				 bean.setRe_stop(rs.getInt(8));
				 bean.setRe_level(rs.getInt(9));
				 bean.setReadcount(rs.getInt(10));
				 bean.setContent(rs.getString(11));
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return bean;
	}
	
	
	//�ϳ��� �Խñ��� �����ϴ� �޼ҵ�
	public void updateBoard(int num ,String subject , String content){
		getcon();
			
		try {		
			//���� �غ� 
			String sql = "update board set subject=? , content= ? where num = ?";
				
			//���� ������ ��ü ����
			pstmt = con.prepareStatement(sql);
			
			//?�� ���� ���� �ϱ�
			pstmt.setString(1,subject);
			pstmt.setString(2,content);
			pstmt.setInt(3,num);
			
			//���� ������ ����� ����
			pstmt.executeUpdate();
				
			//�ڿ� �ݳ�
			con.close();
					
		}catch(Exception e) {
			e.printStackTrace();
		}
	}  
	
	
	//�ϳ��� �Խñ��� �����ϴ� �żҵ�
		public void deleteBoard(int num){
			getcon();
			
			try {		
				//���� �غ� 
				String sql = "delete from board where num=?";
				
				//���� ������ ��ü ����
				pstmt = con.prepareStatement(sql);
				//?
				pstmt.setInt(1,num);
				
				//���� ����
				pstmt.executeUpdate();
				
				//�ڿ� �ݳ�
				con.close();
					
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
	   
}
