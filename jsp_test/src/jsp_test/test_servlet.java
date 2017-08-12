package jsp_test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class test_servlet
 */
@WebServlet("/test_servlet")
public class test_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("num_1");
		int num_1=Integer.parseInt(a);
		String b=request.getParameter("num_2");
		int num_2=Integer.parseInt(b);
		String c=request.getParameter("select");
		HttpSession d=request.getSession();
		if(c.equals("+"))d.setAttribute("resutl", num_1+num_2);
		if(c.equals("-"))d.setAttribute("resutl", num_1-num_2);
		if(c.equals("*"))d.setAttribute("resutl", num_1*num_2);
		if(c.equals("/"))d.setAttribute("resutl", num_1/num_2);
		response.sendRedirect("r.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
