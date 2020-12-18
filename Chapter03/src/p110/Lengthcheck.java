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
		// 1.���۵� ���� �о��
		String str= request.getParameter("str");
		System.out.println(str);
		
		// 2. ���ڰ����� �˾Ƴ���,
		int num =str.length();
		String snum = Integer.toString(num);
		
		// 3. �����Ѵ�.
		response.getWriter().append(snum );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}