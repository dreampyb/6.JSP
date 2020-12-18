package p110;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MaxNoFind")
public class MaxNoFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MaxNoFind() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int[] num = new int[5] ;
		num[0]=Integer.parseInt((request.getParameter("n1")));
		num[1]=Integer.parseInt((request.getParameter("n2")));
		num[2]=Integer.parseInt((request.getParameter("n3")));
		num[3]=Integer.parseInt((request.getParameter("n4")));
		num[4]=Integer.parseInt((request.getParameter("n5")));
		int max = num[0];
		
		for(int i=1; i<num.length; i++) {
			if(num[i]>max) {
				max = num[i];
			}
		}
		System.out.println("가장큰 수는 = " + max);
		response.getWriter().append(Integer.toString(max));
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
