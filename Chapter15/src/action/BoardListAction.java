package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �Խ��� �ۺ��� ���� ȣ��
		BoardListService bls =new BoardListService();
		ArrayList<BoardBean> aclL = bls.getArticleList();//�Խñ� �޾ƿͼ�
		
		
		
		//������ ����
		request.setAttribute("articleList", aclL);
		//request������ �Խñ� ��Ƽ� ����, ���?aclL��� ����21�࿡�� ����
		// articleList�� �ҷ������ϱ� ��� �Ҿ�Գ�? �ٷ� "getArticleList();" �̰����� 
		
		ActionForward afw = new ActionForward();
		afw.setPath("qna_board_list.jsp");
		afw.setRedirect(false);// ������ ������� �����ڴ�.
		
		
		
		
		return afw;
	}

}
