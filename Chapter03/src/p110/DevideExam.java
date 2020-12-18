package p110;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/devide_exam")    //  html 주소 주의
public class DevideExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DevideExam() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		int num3 = num1 % num2; 
		Integer.toString(num3);
		
		System.out.println(num1+"을" +num2+"으로 나눈 나머지 값은 = :" + num3 );
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(num1+"을" +num2+"으로 나눈 나머지 값은 :" + num3);
		// append는 숫자밖에 못읽는다.
		// 브라우져에 나타내는 것은 이곳
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}