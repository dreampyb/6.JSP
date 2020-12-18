package p110;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sumsum")
public class SumsumTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SumsumTest() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1=Integer.parseInt(request.getParameter("start"));
		int num2=Integer.parseInt(request.getParameter("end"));
		System.out.println(num1+num2);
		
		response.getWriter().append(Integer.toString(num1+num2));
	}
}