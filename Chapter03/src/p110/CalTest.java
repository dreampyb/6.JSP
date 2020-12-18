package p110;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalTest
 */
@WebServlet("/cal.test")
public class CalTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_num1=request.getParameter("num1");
		String s_num2=request.getParameter("num2");
		int num1 = Integer.parseInt(s_num1);
		int num2 = Integer.parseInt(s_num2);
		int num3 = num1 % num2; //나머지값
		String s_num3=Integer.toString(num3);
		
		String re=s_num1+"를"+s_num2+"로 나눈 나머지 값은"+s_num3;
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(re);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
