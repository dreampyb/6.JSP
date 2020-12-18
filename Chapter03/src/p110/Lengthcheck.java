package p110;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/length")
public class Lengthcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Lengthcheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.전송된 값을 읽어라
		String str= request.getParameter("str");
		System.out.println(str);
		
		// 2. 글자개수를 알아낸다,
		int num =str.length();
		String snum = Integer.toString(num);
		
		// 3. 응답한다.
		response.getWriter().append(snum );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}