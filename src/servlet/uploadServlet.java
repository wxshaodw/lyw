package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class uploadServlet
 */
@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "upload";
	
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40 ;
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!ServletFileUpload.isMultipartContent(request)) {
		    // 如果不是则停止
			response.getWriter().append("请求类型有误");
		    return;
		}
		
		DiskFileItemFactory factory =  new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setFileSizeMax(MAX_FILE_SIZE);
		
		upload.setFileSizeMax(MAX_REQUEST_SIZE);;
		
		upload.setHeaderEncoding("UTF-8");
		
		 String uploadPath = this.getServletContext().getRealPath("/WEB-INF/upload");
       
	        // 如果目录不存在则创建
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	       
	            // 解析请求的内容提取文件数据
	            List<FileItem> formItems;
				try {
					formItems = upload.parseRequest(request);
		        	if(formItems !=null&& formItems.size()>0) {
		        		String fileName =null ;
		        		for (FileItem item : formItems) {
		        			if(item.getFieldName().equals("")||item.getFieldName().equals("")) {
		        				System.out.println("文件名不能为空");
		        			}else if(item.isFormField()) {
			        			fileName = item.getFieldName();
			        		}else {
			        			fileName = item.getName();
			        		}
		        			String filePath = uploadPath + File.separator + fileName;
		        			File StoreFile  = new File(filePath);
		        			item.write(StoreFile);
		        			System.out.println(filePath);
		        			response.getWriter().append("success");
		        		}
		        		
		        	}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
