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
		//��ȡ�����е�code
		String code = req.getParameter("code");
		//��ȡsession�е�code
		String codeSession = req.getSession().getAttribute("code").toString();
		if (codeSession.equals(code)) {
			//��ȡ��½��Ϣ
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			//�����û�����
			Users users=new Users();
			users.setUsername(username);
			users.setPassword(password);
			//���ò�ѯ���������Ƿ��ж�Ӧ��
			Users user=userService.login(users);
			if (user!=null) {
				resp.sendRedirect("main.jsp");
			} else {
				req.setAttribute("error", "�û������벻��ȷ");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("error", "��֤�벻��ȷ");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
}
