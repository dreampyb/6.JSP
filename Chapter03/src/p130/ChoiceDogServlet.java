package p130;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChoiceDogServlet")
public class ChoiceDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChoiceDogServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[ ] dog =request.getParameterValues("dog");
		
		for(String str:dog) {
			System.out.println(str);
		}

	}

}
