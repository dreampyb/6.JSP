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
		// 게시판 글보기 서비스 호출
		BoardListService bls =new BoardListService();
		ArrayList<BoardBean> aclL = bls.getArticleList();//게시글 받아와서
		
		
		
		//페이지 세팅
		request.setAttribute("articleList", aclL);
		//request영역에 게시글 담아서 전달, 어떻게?aclL라는 변수21행에서 만들어서
		// articleList를 불렀왔으니깐 어떻게 불어왔나? 바로 "getArticleList();" 이것으로 
		
		ActionForward afw = new ActionForward();
		afw.setPath("qna_board_list.jsp");
		afw.setRedirect(false);// 디스패쳐 방식으로 보내겠다.
		
		
		
		
		return afw;
	}

}
