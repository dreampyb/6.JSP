package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardDetailService {

	// �� �󼼺���(���� Ŭ������ ��)
	public BoardBean getArticle(int board_num) {
		//�����Ͻ� ����(��)
		//1.db����
		Connection conn = JdbcUtil.getConnection();
		//2. �ش� DAOȣ��
		boolean isWriteSucess=false;
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(conn);
		//����1-��ȸ��1-��ȸ�� ������Ʈ
		int updateCount=boardDAO.updateRedCount(board_num);
		//����2-�󼼱� ��������
		BoardBean article=boardDAO.selectArticle(board_num);
		
		if(updateCount>0) {
			JdbcUtil.commit(conn);
		}else {
			JdbcUtil.rollback(conn);
		}
		//3.DB���� �ݱ�
		JdbcUtil.close(conn);
		//4.�����(�ۻ󼼺��⳻��-�� �ϳ��� Ʃ��) ����
		return article;
	}
	
}
