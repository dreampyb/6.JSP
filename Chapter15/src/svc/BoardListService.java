package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardListService {
	public ArrayList<BoardBean> getArticleList(){
		System.out.println("게시글 불러오기");
		Connection conn =JdbcUtil.getConnection(); // DB연결 conn 생성
		BoardDAO boardDAO = BoardDAO.getInstance(); // DAO객체 생성
		boardDAO.setConnection(conn);				// 생성된 conn DAO 넘겨주기
		ArrayList<BoardBean> articleList=boardDAO.selectArticleList();
		//
		JdbcUtil.close(conn);						// db 연결 닫기
		
		return articleList;							// 결과 리턴
		
	}
}
