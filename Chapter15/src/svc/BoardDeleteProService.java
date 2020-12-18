package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;

public class BoardDeleteProService {
	//1. 본인 글인 지 확인(즉 패스워드)
	
	//2. 글을 지우기(글번호에 해당하는 글지우기)
	public boolean removeArticle(int board_num) {
		//1. DB연결
		Connection conn = JdbcUtil.getConnection(); //db연결결 객체 생성
		
		//2. 해당 DAO호출
		boolean isWriteSucess=false;   //확인하기 위해 만든 가정
		BoardDAO boardDAO = BoardDAO.getInstance();//싱글톤(하나인 객체)객체 생성 
		boardDAO.setConnection(conn);
		int deleteCount=boardDAO.deleteArticle(board_num);// 정상1,비정상0
		//BoardDAO 55행 을 이용
		
		//3. 트랜젹션 처리
		if(deleteCount>0) {
			JdbcUtil.commit(conn);
			isWriteSucess=true;
		}else {
			JdbcUtil.rollback(conn);
			
		}
//	 	4. DB연결 닫기
		JdbcUtil.close(conn);
		return isWriteSucess;

	}
}
