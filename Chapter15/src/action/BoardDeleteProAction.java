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
		//패스워드 가져오기, 글번호 가져오기
		String num = request.getParameter("num");// 글번호 읽기
		String user_pass=request.getParameter("input_pass");
		// 사용자 입력 패스워드 => 이것도 지금 만든거?
		
		// 입력한 패스워드와 글번호의 패스워드 확인
		BoardDetailService bds = new BoardDetailService();
		BoardBean vo = bds.getArticle(Integer.parseInt(num));
		if(vo.getBoard_pass().equals(user_pass)) { 
			// 맞은편 삭제 처리
			// 해당 서비스 호툴
			BoardDeleteProService bdps =new BoardDeleteProService();
			boolean b = bdps.removeArticle(Integer.parseInt(request.getParameter("num")));
//			boolean b = bdps.removeArticle(Integer.parseInt(request.getParameter("board_num")));	
// 			board_num 대신 num?
				
			// 가야할 페이지 셋팅
			if(b!=true) {
			System.out.println("글삭제 오류"); 
			}else {
				System.out.println("글삭제 성공");
			}
		}else {
			System.out.println("패스워드 다름");
			  }
		
		//가야할 페이지 세팅(삭제 후 글목록으로 가기)
		ActionForward afw =new ActionForward(); // 주소세팅을 위하여 객체 생성
		afw.setPath("boardList.board"); 		// 이동할 주소
		return afw;
	}
}