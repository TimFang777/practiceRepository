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
		//����ͼƬ
		BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();
		
		//���û���
		graphics.setColor(Color.WHITE);
		//���趨���꿪ʼ���
		graphics.fillRect(0, 0, 200, 100);
		//���������λ����
		List<Integer> list=new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			list.add(random.nextInt(10));
		} 
		//�޸Ļ�����ɫ
		graphics.setColor(Color.BLACK);
		//��������
		graphics.setFont(new Font("����", Font.BOLD|Font.ITALIC, 40));
		Color[] colors=new Color[]{Color.blue, Color.cyan, Color.pink, Color.yellow, Color.orange, Color.lightGray};
		//����
		for (int i = 0; i < 2; i++) {
			graphics.setColor(colors[random.nextInt(colors.length)]);
			graphics.drawLine(0, random.nextInt(201), 200, random.nextInt(101));
		}
		//���String
		for (int i = 0; i < list.size(); i++) {
			graphics.setColor(colors[random.nextInt(colors.length)]);
			graphics.drawString(list.get(i)+"", i*40, 50+(random.nextInt(21)-10));
		}
		
		
		
		//��Ӧ���������
		ServletOutputStream outputStream = resp.getOutputStream();
		//��imageд����Ӧ�����
		ImageIO.write(image, "jpg", outputStream);
		//����֤����뵽session��
		HttpSession session=req.getSession();
		session.setAttribute("code", ""+list.get(0)+list.get(1)+list.get(2)+list.get(3));
	}
}
