package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JdbcUtil;
import vo.BoardBean;

public class BoardDAO {
	
	static BoardDAO boardDAO; //BoardDAO 객체
	Connection conn;
//	private Object boardbean ;   이것은 삭제했네?
	
	//싱글톤 생성을위해서 외부에서 객체 생성불가능하게
	private BoardDAO(){		
	}
	
	//객체를 생성하는 메소드 (객체 한개만 생성됨)
	public static BoardDAO getInstance(){
		if(boardDAO==null) {	
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}
	
	public void setConnection(Connection conn){
		this.conn=conn;
	}
	

	//전체 글의 개수를 구하는 메소드
	public int selectListCount() {
	//2.해당쿼리 실행
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
	//3.결과리턴
		return listCount;
	}
	
	// 글 등록
	public int insertArticle(BoardBean article) {

	//1.해당쿼리 실행
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int insertCount=0;
		try {
			pstmt=conn.prepareStatement("select max(board_num) from board");
			rs=pstmt.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			
			pstmt = conn.prepareStatement("insert into board values(?,?,?,?,?,?,?,?,?,?,now())");
			// BoardBean에서 불러온다?
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
	//2.결과리턴
		return insertCount;
	}		
	
	// #조회수 업데이트
		public int updateRedCount(int board_num) {
	// 조회수 업데이트(업데이트 실행결과 수 리턴)
		//1. 해당쿼리 실행
			PreparedStatement pstmt=null;
			int updateCount=0;
			
			try {
pstmt = conn.prepareStatement(
							  "UPDATE board " + 
							  "SET board_readcount= board_readcount+1 " + 
		                      "WHERE (board_num = ?)"
							  );
/* 붙여넣기를 할 때에는 완전한 String을 통째로 복사해서 넣어야 문제없이 들어간다.
 * 그렇지 않으면 기존에 Enter를 쳐놓은 부분에서 eclipse가 자동으로 \"\r\n"를 인식하여 
 * 붙여넣는 기능이 있어서 예를 들자면  ("a")라고 할 때에 'a'부분만 넣으면
 * 원치않는 " \"\r\n"부분들이 자동으로 입력되어 잘못된 쿼리가 자동으로 만듷어 진다.
 */
				pstmt.setInt(1, board_num);        // 쿼리완성
				updateCount=pstmt.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				JdbcUtil.close(pstmt);
			}
	// 결과 리턴
			return updateCount;
			
		}	
		
	// 글 상세보기
	public BoardBean selectArticle(int board_num) {
		//1. 해당쿼리 실행
			PreparedStatement pstmt=null;
			BoardBean boardbean = null;
			ResultSet rs = null;

	try {
			pstmt= conn.prepareStatement("select*from board where board_num=?"); // sq2넣기
			pstmt.setInt(1, board_num);        // 쿼리완성
			rs=pstmt.executeQuery();
			boardbean = new BoardBean();       
			// VO 객체생성 (Value Object:값만가지고 있는 object)
			rs.next();  //  첫번째 행 가리키기 ? Why????
			
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
			System.out.println("글상세보기 가져온 내용:"+boardbean.toString());
			
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				JdbcUtil.close(pstmt);
				JdbcUtil.close(rs);
			}
	// 결과 리턴
			return boardbean;
		}	
	//글삭제
	public int deleteArticle(int board_num) {
		//1.해당쿼리 실행
				PreparedStatement pstmt=null;
				int deleteCount=0;
				try {
					pstmt = conn.prepareStatement("delete from board where board_num=?");
					pstmt.setInt(1, board_num); ///쿼리완성
					deleteCount=pstmt.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JdbcUtil.close(pstmt);

				}
			//2.결과리턴
				return deleteCount;		
			}	
	
	// 글목록 보기 -차후 페이지 처리 필요
	public ArrayList<BoardBean> selectArticleList(){

		//1.해당쿼리 실행
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			ArrayList<BoardBean> articleList = new ArrayList<BoardBean>();
			BoardBean boardbean = null;
				
			try {
				pstmt = conn.prepareStatement("select * from board");
				rs = pstmt.executeQuery();
//				boardbean = new BoardBean(); - 여기에 생성할 경우 같은 내용으로 목록수 만큼 나온다
				while(rs.next()) { //한행씩 접근힌다
					
				boardbean = new BoardBean();//한행(튜플)담을 객체 생성.
					
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
				articleList.add(boardbean);// 값을 vo에 다 넣은 후 그 vo룰 리스트에 추가
				}
			} catch (Exception e) {
					e.printStackTrace();
			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			//2.결과리턴
			return articleList;
	}
	
	
	
}