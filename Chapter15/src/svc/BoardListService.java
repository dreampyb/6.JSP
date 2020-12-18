package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardListService {
	public ArrayList<BoardBean> getArticleList(){
		System.out.println("�Խñ� �ҷ�����");
		Connection conn =JdbcUtil.getConnection(); // DB���� conn ����
		BoardDAO boardDAO = BoardDAO.getInstance(); // DAO��ü ����
		boardDAO.setConnection(conn);				// ������ conn DAO �Ѱ��ֱ�
		ArrayList<BoardBean> articleList=boardDAO.selectArticleList();
		//
		JdbcUtil.close(conn);						// db ���� �ݱ�
		
		return articleList;							// ��� ����
		
	}
}
