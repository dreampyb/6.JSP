package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardWriteProAction implements Action{

	@Override
	public ActionForward execute (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {  
			//���� ����� ���� ��ü ����
			BoardWriteProService bwps = new BoardWriteProService();
			// ���� �޼ҵ��� �μ�(argument)���� �־��ֱ� ���� BoardBean ��ü����

			BoardBean bb = new BoardBean();
			//BoardBean ��ü�� ���±׿��� �Ѿ�� �� ����
			bb.setBoard_name(request.getParameter("board_name"));
			bb.setBoard_pass(request.getParameter("board_pass"));
			bb.setBoard_subject(request.getParameter("board_subject"));
			bb.setBoard_content(request.getParameter("board_content"));
			bb.setBoard_file(request.getParameter("board_file"));
			System.out.println(bb.toString());
				// �۾��� ���� ����
			bwps.registArticle(bb);
				
				// ������ ����
			ActionForward afw =new ActionForward();
//			afw.setPath("qna_board_view.jsp"); //�������� ������ �ּ� ����
			afw.setPath("boardList.board"); //�������� ������ �ּ� ����
			return afw;
		}
}