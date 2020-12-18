package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JdbcUtil;
import vo.BoardBean;

public class BoardDAO {
	
	static BoardDAO boardDAO; //BoardDAO ��ü
	Connection conn;
//	private Object boardbean ;   �̰��� �����߳�?
	
	//�̱��� ���������ؼ� �ܺο��� ��ü �����Ұ����ϰ�
	private BoardDAO(){		
	}
	
	//��ü�� �����ϴ� �޼ҵ� (��ü �Ѱ��� ������)
	public static BoardDAO getInstance(){
		if(boardDAO==null) {	
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	public void setConnection(Connection conn){
		this.conn=conn;
	}
	

	//��ü ���� ������ ���ϴ� �޼ҵ�
	public int selectListCount() {
	//2.�ش����� ����
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int listCount = 0;
		try {
			pstmt = conn.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			rs.next();
			listCount=rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	//3.�������
		return listCount;
	}
	
	// �� ���
	public int insertArticle(BoardBean article) {

	//1.�ش����� ����
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int insertCount=0;
		try {
			pstmt=conn.prepareStatement("select max(board_num) from board");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			
			pstmt = conn.prepareStatement("insert into board values(?,?,?,?,?,?,?,?,?,?,now())");
			// BoardBean���� �ҷ��´�?
			pstmt.setInt(1, num+1);
			pstmt.setString(2,article.getBoard_name());
			pstmt.setString(3, article.getBoard_pass());
			pstmt.setString(4, article.getBoard_subject());
			pstmt.setString(5, article.getBoard_content());
			pstmt.setString(6, article.getBoard_file());
//			pstmt.setInt(7, num+1);
//			pstmt.setInt(8, article.getRe_lev());
//			pstmt.setInt(9, article.getRe_step());
//			pstmt.setInt(10, article.getBoard_readcount());
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
		    insertCount=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);

		}
	//2.�������
		return insertCount;
	}		
	
	// #��ȸ�� ������Ʈ
		public int updateRedCount(int board_num) {
	// ��ȸ�� ������Ʈ(������Ʈ ������ �� ����)
		//1. �ش����� ����
			PreparedStatement pstmt=null;
			int updateCount=0;
			
			try {
pstmt = conn.prepareStatement(
							  "UPDATE board " + 
							  "SET board_readcount= board_readcount+1 " + 
		                      "WHERE (board_num = ?)"
							  );
/* �ٿ��ֱ⸦ �� ������ ������ String�� ��°�� �����ؼ� �־�� �������� ����.
 * �׷��� ������ ������ Enter�� �ĳ��� �κп��� eclipse�� �ڵ����� \"\r\n"�� �ν��Ͽ� 
 * �ٿ��ִ� ����� �־ ���� ���ڸ�  ("a")��� �� ���� 'a'�κи� ������
 * ��ġ�ʴ� " \"\r\n"�κе��� �ڵ����� �ԷµǾ� �߸��� ������ �ڵ����� ���޾� ����.
 */
				pstmt.setInt(1, board_num);        // �����ϼ�
				updateCount=pstmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				JdbcUtil.close(pstmt);
			}
	// ��� ����
			return updateCount;
			
		}	
		
	// �� �󼼺���
	public BoardBean selectArticle(int board_num) {
		//1. �ش����� ����
			PreparedStatement pstmt=null;
			BoardBean boardbean = null;
			ResultSet rs = null;

	try {
			pstmt= conn.prepareStatement("select*from board where board_num=?"); // sq2�ֱ�
			pstmt.setInt(1, board_num);        // �����ϼ�
			rs=pstmt.executeQuery();
			boardbean = new BoardBean();       
			// VO ��ü���� (Value Object:���������� �ִ� object)
			rs.next();  //  ù��° �� ����Ű�� ? Why????
			
			boardbean.setBoard_num(rs.getInt("board_num"));
			boardbean.setBoard_name(rs.getString("board_name"));
			boardbean.setBoard_pass(rs.getString("board_pass"));
			boardbean.setBoard_subject(rs.getString("board_subject"));
			boardbean.setBoard_content(rs.getString("board_content"));
			boardbean.setBoard_file(rs.getString("board_file"));
			boardbean.setRe_ref(rs.getInt("re_ref"));
			boardbean.setRe_lev(rs.getInt("re_lev"));
			boardbean.setRe_step(rs.getInt("re_step"));
			boardbean.setBoard_readcount(rs.getInt("board_readcount"));
			boardbean.setBoard_date(rs.getDate("board_date"));
			System.out.println("�ۻ󼼺��� ������ ����:"+boardbean.toString());
			
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				JdbcUtil.close(pstmt);
				JdbcUtil.close(rs);
			}
	// ��� ����
			return boardbean;
		}	
	//�ۻ���
	public int deleteArticle(int board_num) {
		//1.�ش����� ����
				PreparedStatement pstmt=null;
				int deleteCount=0;
				try {
					pstmt = conn.prepareStatement("delete from board where board_num=?");
					pstmt.setInt(1, board_num); ///�����ϼ�
					deleteCount=pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JdbcUtil.close(pstmt);

				}
			//2.�������
				return deleteCount;		
			}	
	
	// �۸�� ���� -���� ������ ó�� �ʿ�
	public ArrayList<BoardBean> selectArticleList(){

		//1.�ش����� ����
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
			BoardBean boardbean = null;
				
			try {
				pstmt = conn.prepareStatement("select * from board");
				rs = pstmt.executeQuery();
//				boardbean = new BoardBean(); - ���⿡ ������ ��� ���� �������� ��ϼ� ��ŭ ���´�
				while(rs.next()) { //���྿ ��������
					
				boardbean = new BoardBean();//����(Ʃ��)���� ��ü ����.
					
				boardbean.setBoard_num(rs.getInt("board_num"));
				boardbean.setBoard_name(rs.getString("board_name"));
				boardbean.setBoard_pass(rs.getString("board_pass"));
				boardbean.setBoard_subject(rs.getString("board_subject"));
				boardbean.setBoard_content(rs.getString("board_content"));
				boardbean.setBoard_file(rs.getString("board_file"));
				boardbean.setRe_ref(rs.getInt("re_ref"));
				boardbean.setRe_lev(rs.getInt("re_lev"));
				boardbean.setRe_step(rs.getInt("re_step"));
				boardbean.setBoard_readcount(rs.getInt("board_readcount"));
				boardbean.setBoard_date(rs.getDate("board_date"));
				articleList.add(boardbean);// ���� vo�� �� ���� �� �� vo�� ����Ʈ�� �߰�
				}
			} catch (Exception e) {
					e.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			//2.�������
			return articleList;
	}
	
	
	
}