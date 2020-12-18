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
			//서비스 사용을 위해 객체 생성
			BoardWriteProService bwps = new BoardWriteProService();
			// 서비스 메소드의 인수(argument)값을 넣어주기 위해 BoardBean 객체생성

			BoardBean bb = new BoardBean();
			//BoardBean 객체에 폼태그에서 넘어온 값 셋팅
			bb.setBoard_name(request.getParameter("board_name"));
			bb.setBoard_pass(request.getParameter("board_pass"));
			bb.setBoard_subject(request.getParameter("board_subject"));
			bb.setBoard_content(request.getParameter("board_content"));
			bb.setBoard_file(request.getParameter("board_file"));
			System.out.println(bb.toString());
				// 글쓰기 서비스 실헹
			bwps.registArticle(bb);
				
				// 페이지 세팅
			ActionForward afw =new ActionForward();
//			afw.setPath("qna_board_view.jsp"); //포워드할 페이지 주소 셋팅
			afw.setPath("boardList.board"); //포워드할 페이지 주소 셋팅
			return afw;
		}
}