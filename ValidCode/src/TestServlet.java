import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletOutputStream os=resp.getOutputStream();
		InputStream is=new FileInputStream(new File(getServletContext().getRealPath("image/shoes.jpg")));
		int index=-1;
		while((index=is.read())!=-1){
			os.write(index);
		}
		//req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
