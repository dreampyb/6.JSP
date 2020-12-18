package p135;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SetName")
public class SetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SetNameServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 주소창에 SetName이라고 입력하면 실행.
		// 세션만들기
		HttpSession session = request.getSession();
		session.setAttribute("name", "오정원");
		// 값은 "오정원" 같은 문자말고도 뭐든 올 수 있다.
		response.setContentType("text/html);charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>이름저장</h2>");
		
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
