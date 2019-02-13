import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidCodeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//创建图片
		BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();
		
		//设置画笔
		graphics.setColor(Color.WHITE);
		//从设定坐标开始填充
		graphics.fillRect(0, 0, 200, 100);
		//生成随机四位数字
		List<Integer> list=new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			list.add(random.nextInt(10));
		} 
		//修改画笔颜色
		graphics.setColor(Color.BLACK);
		//设置字体
		graphics.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 40));
		Color[] colors=new Color[]{Color.blue, Color.cyan, Color.pink, Color.yellow, Color.orange, Color.lightGray};
		//划线
		for (int i = 0; i < 2; i++) {
			graphics.setColor(colors[random.nextInt(colors.length)]);
			graphics.drawLine(0, random.nextInt(201), 200, random.nextInt(101));
		}
		//添加String
		for (int i = 0; i < list.size(); i++) {
			graphics.setColor(colors[random.nextInt(colors.length)]);
			graphics.drawString(list.get(i)+"", i*40, 50+(random.nextInt(21)-10));
		}
		
		
		
		//响应输出流对象
		ServletOutputStream outputStream = resp.getOutputStream();
		//将image写入响应输出流
		ImageIO.write(image, "jpg", outputStream);
		//把验证码放入到session中
		HttpSession session=req.getSession();
		session.setAttribute("code", ""+list.get(0)+list.get(1)+list.get(2)+list.get(3));
	}
}
