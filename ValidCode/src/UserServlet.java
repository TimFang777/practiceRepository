import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zim.pojo.Users;
import com.zim.service.UserService;
import com.zim.service.impl.UserServiceImpl;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
	
	private UserService userService;
	@Override
	public void init() throws ServletException {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		userService = ac.getBean("userService", UserServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//获取请求中的code
		String code = req.getParameter("code");
		//获取session中的code
		String codeSession = req.getSession().getAttribute("code").toString();
		if (codeSession.equals(code)) {
			//获取登陆信息
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			//创建用户对象
			Users users=new Users();
			users.setUsername(username);
			users.setPassword(password);
			//调用查询方法，看是否有对应的
			Users user=userService.login(users);
			if (user!=null) {
				resp.sendRedirect("main.jsp");
			} else {
				req.setAttribute("error", "用户名密码不正确");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("error", "验证码不正确");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
}
