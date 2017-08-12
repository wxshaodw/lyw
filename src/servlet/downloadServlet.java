package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class downloadServlet
 */
@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public downloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path =request.getParameter("path");
		String filename = request.getParameter("filename");
		if(path==null&&(!path.equals(""))) {
			response.getWriter().append("请求地址不能为空");
		}else if(filename==null&&(!filename.equals(""))){
			response.getWriter().append("文件名称不能为空");
		}else {
		    FileInputStream fis = null;  
		    File file = new File(path+"/"+filename);  
		    fis = new FileInputStream(file);  
		    response.setHeader("Content-Disposition", "attachment;filename="+filename); 
		    response.setContentType("application/force-download");//设置返回的文件类型     
		    IOUtils.copy(fis, response.getOutputStream());   
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
