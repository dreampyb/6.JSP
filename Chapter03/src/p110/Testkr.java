package p110;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Testkr")
public class Testkr extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Testkr() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str= request.getParameter("krstr");

		System.out.println(str);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("입력한 글자는 :" + str +"입니다");
	}
}