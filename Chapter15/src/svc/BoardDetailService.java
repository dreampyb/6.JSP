package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardDetailService {

	// 글 상세보기(글을 클릭했을 때)
	public BoardBean getArticle(int board_num) {
		//비지니스 로직(모델)
		//1.db연결
		Connection conn = JdbcUtil.getConnection();
		//2. 해당 DAO호출
		boolean isWriteSucess=false;
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		//서비스1-조회수1-조회수 업데이트
		int updateCount=boardDAO.updateRedCount(board_num);
		//서비스2-상세글 가져오기
		BoardBean article=boardDAO.selectArticle(board_num);
		
		if(updateCount>0) {
			JdbcUtil.commit(conn);
		}else {
			JdbcUtil.rollback(conn);
		}
		//3.DB연결 닫기
		JdbcUtil.close(conn);
		//4.결과값(글상세보기내용-즉 하나의 튜플) 리턴
		return article;
	}
	
}
