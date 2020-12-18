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
		//해당서비스 호출
		BoardDetailService bds = new BoardDetailService();
		String str_num = request.getParameter("board_num");
		// str_num으로한 이유는 board_num을 불러와서 저장할 것이므로 보기 쉽게 만든다.
		
		int num = Integer.parseInt(str_num);
		BoardBean boardBean = bds.getArticle(num);
				
		//가야할 페이지 세팅
		request.setAttribute("abc", boardBean);// 'abc'는 "name" boardBean는 겂
		// 값을 request영역에 담아서
		ActionForward afw =new ActionForward(); // 주소세팅을 위하여 객체 생성
		afw.setPath("qna_board_view.jsp"); 		// 이동할 주소
		afw.setRedirect(false);// 값을 실어 보내야 하므로 디스패쳐 방식으로 보내겠다.
		
		return afw;
	}



}
