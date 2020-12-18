package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDeleteProService;
import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�н����� ��������, �۹�ȣ ��������
		String num = request.getParameter("num");// �۹�ȣ �б�
		String user_pass=request.getParameter("input_pass");
		// ����� �Է� �н����� => �̰͵� ���� �����?
		
		// �Է��� �н������ �۹�ȣ�� �н����� Ȯ��
		BoardDetailService bds = new BoardDetailService();
		BoardBean vo = bds.getArticle(Integer.parseInt(num));
		if(vo.getBoard_pass().equals(user_pass)) { 
			// ������ ���� ó��
			// �ش� ���� ȣ��
			BoardDeleteProService bdps =new BoardDeleteProService();
			boolean b = bdps.removeArticle(Integer.parseInt(request.getParameter("num")));
//			boolean b = bdps.removeArticle(Integer.parseInt(request.getParameter("board_num")));	
// 			board_num ��� num?
				
			// ������ ������ ����
			if(b!=true) {
			System.out.println("�ۻ��� ����"); 
			}else {
				System.out.println("�ۻ��� ����");
			}
		}else {
			System.out.println("�н����� �ٸ�");
			  }
		
		//������ ������ ����(���� �� �۸������ ����)
		ActionForward afw =new ActionForward(); // �ּҼ����� ���Ͽ� ��ü ����
		afw.setPath("boardList.board"); 		// �̵��� �ּ�
		return afw;
	}
}