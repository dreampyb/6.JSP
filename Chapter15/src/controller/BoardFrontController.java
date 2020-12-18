package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardDeleteProAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardWriteProAction;
import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

@WebServlet("*.board")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardFrontController() {
        super();
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		// get,post 상관없이 처리하기 위한 공통 실행 메소드
		//1. 어떤 오쳥인지 확인
		request.setCharacterEncoding("UTF-8");
		String requestURI= request.getRequestURI();
		System.out.println(requestURI);
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String command = requestURI.substring(contextPath.length());
		System.out.println(command);
		
		Action action=null;
		ActionForward afw=null; 
		
		if(command.equals("/boardWriteForm.board")) {
			//QnA_board_writer를 얄어주자!
			afw =new ActionForward();
			afw.setPath("QnA_board_write.jsp");
			
//	response.sendRedirect("QnA_board_write.jsp");//리다이렉트
//			디스패쳐
//			RequestDispatcher dispatcher =request.getRequestDispatcher("QnA_board_write.jsp");
//			dispatcher.forward(request, response);
		}
			
//		BoardWriteProService bwps =new BoardWriteProService();
//		BoardBean bb = new BoardBean();
//		bb.setBoard_name(request.getParameter("board_name"));
//		bb.setBoard_pass(request.getParameter("board_pass"));
//		bb.setBoard_subject(request.getParameter("board_subject"));
//		bb.setBoard_content(request.getParameter("board_content"));
//		bb.setBoard_file(request.getParameter("board_file"));
//		System.out.println(bb.toString());    // 글쓰기 서비스 실헹
//		bwps.registArticle(bb);		
//		afw= new ActionForward();
//		afw.setPath("qna_board_view.jsp");// 포워드할 페이지 주소 셋팅
			
//   => 54~64행은 모두 새로 생성시킨 action클래스안의 execute라는 메소는에 담았기에 이 클래스에서는 없다.
		else if(command.equals("/boardWritePro.board")) {
			// 글등록
				action = new BoardWriteProAction();
				afw= action.execute(request, response);
				
			}else if(command.equals("/boardList.board")){
				//게시글 목록 보기
				action = new BoardListAction();
				afw=action.execute(request, response);
			}else if(command.equals("/boardDetail.board")) {
				// 게시글 보기 (한개의)
				action = new BoardDetailAction();
				afw = action.execute(request, response);
			}else if(command.equals("/boardDeletePro.board")) {
				// 글삭제 처리(한개만)
				action = new BoardDeleteProAction();
				afw = action.execute(request, response);
			}else if(command.equals("/boardDeleteForm.board")) {
				//글삭제를 위한 비밀번호 입력 화면 이동
				String str_num=request.getParameter("delete_num");
				//qna_board_view의 23의 "delete_num"
				request.setAttribute("brddelnum", str_num);;
				afw= new ActionForward();
				afw.setPath("qna_board_delete.jsp");
				afw.setRedirect(false);//디스패치방식으로 
			}else if(command.equals("/searchPro.board")) {
				// 게시글 검색
			}
		
		else {// 그외의 명령어가 입력될 경우
			afw= new ActionForward();
			afw.setPath("inputerror.jsp");
			afw.setRedirect(true); 
			//ActionForward.java에서 Redirect 기본값을 true로 잡아놨으므로 
			// 어떤 명령도 없을 때는 Redirect형식으로 inputerror.jsp가 연결된다.		
			
			// response.sendRedirect("qna_board_view.jsp");//리다이렉트
		}	
		
		//위에서 처리가 끝나면 페이지로 이동
		if(afw.isRedirect()) {
			response.sendRedirect(afw.getPath());
		}else {
			RequestDispatcher dispatcher =request.getRequestDispatcher(afw.getPath());
   			dispatcher.forward(request, response);
		}		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		doProcess(request, response);
	}
}
