package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ش缭�� ȣ��
		BoardDetailService bds = new BoardDetailService();
		String str_num = request.getParameter("board_num");
		// str_num������ ������ board_num�� �ҷ��ͼ� ������ ���̹Ƿ� ���� ���� �����.
		
		int num = Integer.parseInt(str_num);
		BoardBean boardBean = bds.getArticle(num);
				
		//������ ������ ����
		request.setAttribute("abc", boardBean);// 'abc'�� "name" boardBean�� ��
		// ���� request������ ��Ƽ�
		ActionForward afw =new ActionForward(); // �ּҼ����� ���Ͽ� ��ü ����
		afw.setPath("qna_board_view.jsp"); 		// �̵��� �ּ�
		afw.setRedirect(false);// ���� �Ǿ� ������ �ϹǷ� ������ ������� �����ڴ�.
		
		return afw;
	}



}
