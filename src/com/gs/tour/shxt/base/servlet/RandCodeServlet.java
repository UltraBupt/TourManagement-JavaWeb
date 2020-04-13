package com.gs.tour.shxt.base.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
<servlet>
		<servlet-name>RandCheckCode</servlet-name>
		<servlet-class>com.shxt.servlet.RandCheckCode</servlet-class>
		<init-param>
			<param-name>width</param-name>
			<param-value>90</param-value>
		</init-param>
		<init-param>
			<param-name>height</param-name>
			<param-value>25</param-value>
		</init-param>
		<init-param>
			<param-name>length</param-name>
			<param-value>4</param-value>
		</init-param>
		<init-param>
			<param-name>flag</param-name>
			<param-value>0</param-value>
		</init-param>
		<init-param>
			<param-name>fontName</param-name>
			<param-value>微软雅黑</param-value>
		</init-param>
		<init-param>
			<param-name>fontStyle</param-name>
			<param-value>5</param-value>
		</init-param>
		<init-param>
			<param-name>fontSize</param-name>
			<param-value>20</param-value>
		</init-param>
		<init-param>
			<param-name>rotate</param-name>
			<param-value>1</param-value>
		</init-param>
	</servlet>
	<servlet-mapping>
		<servlet-name>RandCheckCode</servlet-name>
		<url-pattern>/RandCheckCode</url-pattern>
	</servlet-mapping>

	//通过
	session.getAttribute("rand")获取验证码的值，进行比计较
	//例如
	String code = request.getParameter("表单控件中的name对应的值")
	if(!code.equalsIgnoreCase(session.getAttribute("rand").toString())){
					request.setAttribute("message","验证码输入不正确,请重新输入!");
					request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
				}
	前台显示验证码图片编码为:
	<img id="image" alt="验证码未加载成功" title="看不清楚，请换一下" src="<%=path %>/RandCheckCode" onclick="changImage()" style="width: 100px; height: 20px;">
	js方法为:
	function changImage(){
		var image = document.getElementById("image");
		//欺骗浏览器，因为这个时候image标签读取的是缓存
		//alert(image.src);
		image.src = "<%=path %>/RandCheckCode?time="+(new Date()).getTime();
	}

*/

public class RandCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random random = new Random();
	private int width;
	private int height;
	private int flag;// 验证码分类标志：0、数字，1、字母，2、汉字，3、数字+字母，4、数字+字母+汉字
	private int length;// 验证码字数
	private String fontName;
	private int fontStyle;
	private int fontSize;
	private int rotate;

	public RandCodeServlet() {
		super();
	}

	public void init() throws ServletException {
		width = Integer.parseInt(this.getInitParameter("width"));
		height = Integer.parseInt(this.getInitParameter("height"));
		length = Integer.parseInt(this.getInitParameter("length"));
		flag = Integer.parseInt(this.getInitParameter("flag"));
		fontName = this.getInitParameter("fontName");
		fontStyle = Integer.parseInt(this.getInitParameter("fontStyle"));
		fontSize = Integer.parseInt(this.getInitParameter("fontSize"));
		rotate = Integer.parseInt(this.getInitParameter("rotate"));

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		// 设置不缓存图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);// 禁止服务器端缓存
		// 指定生成的相应图片
		response.setContentType("image/jpeg"); // 默认是text/html(输出文档的MIMI类型)
		
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_BGR);
		Graphics2D g = image.createGraphics();
		g.setColor(getRandomColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < 10; i++) {
			int k = random.nextInt(width-1);
			int j = random.nextInt(height-1);
			g.drawLine(k, j, k + 1, j + 1);
			g.drawLine(k, j, k + 1, j);
			g.drawLine(k, j, k, j);
		}
		g.setColor(Color.red);
		for (int i = 0; i < 10; i++) {
			int k = random.nextInt(width-1);
			int j = random.nextInt(height-1);
			g.drawLine(k, j, k + 1, j + 1);
			g.drawLine(k, j, k + 1, j);
			g.drawLine(k, j, k, j);
		}
		g.setColor(Color.green);
		for (int i = 0; i < 10; i++) {
			int k = random.nextInt(width-1);
			int j = random.nextInt(height-1);
			g.drawLine(k, j, k + 1, j + 1);
			g.drawLine(k, j, k + 1, j);
			g.drawLine(k, j, k, j);
		}
		g.setColor(getRandomColor(10,200));
		// 定义字体样式
		Font myFont = new Font(fontName, fontStyle, fontSize);
		// 设置字体
		g.setFont(myFont);
		String sessionstr = drawRandomString(length, g, flag);
		session.setAttribute("rand", sessionstr);
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
		
	}

	/**
	 * 生成随即颜色
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private Color getRandomColor(int i, int j) {
		Random random = new Random();
		if (i > 255)
			i = 200;
		if (j > 255)
			j = 255;
		int r = i + random.nextInt(j - i);
		int g = i + random.nextInt(j - i);
		int b = i + random.nextInt(j - i);
		return new Color(r, g, b);
	}

	private String drawRandomString(int length, Graphics2D g, int flag) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		String temp = "";
		AffineTransform atf = new AffineTransform();
		if (flag == 0) {
			for (int i = 0; i < length; i++) {
				temp = drawRandomDigital();
				sb.append(temp);
				if(rotate==1){
					atf.rotate(-(random.nextInt(5)*3.14/180), i * (width / length) + 5,
							(height + fontSize) / 2);
					g.setTransform(atf);
				}
				g.drawString(temp, i * (width / length) + 5,
						(height + fontSize) / 2);
			}
		} else if (flag == 1) {
			for (int i = 0; i < length; i++) {
				temp = drawRandomLetter();
				sb.append(temp);
				if(rotate==1){
					atf.rotate(-(random.nextInt(5)*3.14/180), i * (width / length) + 5,
							(height + fontSize) / 2);
					g.setTransform(atf);
				}
				g.drawString(temp, i * (width / length) + 5,
						(height + fontSize) / 2);
			}
		} else if (flag == 2) {
			for (int i = 0; i < length; i++) {
				temp = drawRandomChineseChar();
				sb.append(temp);
				if(rotate==1){
					atf.rotate(-(random.nextInt(5)*3.14/180), i * (width / length) + 5,
							(height + fontSize) / 2);
					g.setTransform(atf);
				}
				g.drawString(temp, i * (width / length) + 5,
						(height + fontSize) / 2);
			}
		} else if (flag == 3) {
			for (int i = 0; i < length; i++) {
				switch (random.nextInt(2)) {
				case 0:
					temp = drawRandomDigital();
					break;
				case 1:
					temp = drawRandomLetter();
					break;

				}
				sb.append(temp);
				if(rotate==1){
					atf.rotate(-(random.nextInt(5)*3.14/180), i * (width / length) + 5,
							(height + fontSize) / 2);
					g.setTransform(atf);
				}
				g.drawString(temp, i * (width / length) + 5,
						(height + fontSize) / 2);
			}
		} else {
			for (int i = 0; i < length; i++) {
				switch (random.nextInt(3)) {
				case 0:
					temp = drawRandomDigital();
					break;
				case 1:
					temp = drawRandomLetter();
					break;
				case 2:
					temp = drawRandomChineseChar();
					break;

				}
				sb.append(temp);
				if(rotate==1){
					atf.rotate(-(random.nextInt(5)*3.14/180), i * (width / length) + 5,
							(height + fontSize) / 2);
					g.setTransform(atf);
				}
				g.drawString(temp, i * (width / length) + 5,
						(height + fontSize) / 2);
			}
		}
		g.dispose();
		return sb.toString();
	}

	private String drawRandomDigital() {
		
		String[] arr = new String[]{"2","3","4","5","6","7","8"};
		
		return arr[random.nextInt(arr.length)];
		
		/*StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(random.nextInt(10)));
		return sb.toString();*/
	}

	private String drawRandomLetter() {
		String[] arr = new String[]{"a","b","c","d","e","f","h","i","j","k","m","n","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","H","I","J","K","M","N","P","Q","R","S","T","U","V","W","X","Y","Z"};
		return arr[random.nextInt(arr.length)];
		
		/*StringBuffer sb = new StringBuffer();
		int tempInt = 0;
		switch (random.nextInt(2)) {
		case 0:
			tempInt = random.nextInt(26) + 65;
			break;
		case 1:
			tempInt = random.nextInt(26) + 97;
			break;

		}
		sb.append(String.valueOf((char) tempInt));
		return sb.toString();*/
	}

	// 汉字"啊"在汉字16区01位码位置，内码：0xb0,0xa1。汉字符集在94*94区中间，
	// 前15区是符号,常用汉字区码在16-87中间，位码01-94
	private String drawRandomChineseChar() throws UnsupportedEncodingException {
		
		// 准备常用汉字集
        String base = "\u7684\u4e00\u4e86\u662f\u6211\u4e0d\u5728\u4eba\u4eec\u6709\u6765\u4ed6\u8fd9\u4e0a\u7740\u4e2a\u5730\u5230\u5927\u91cc\u8bf4\u5c31\u53bb\u5b50\u5f97\u4e5f\u548c\u90a3\u8981\u4e0b\u770b\u5929\u65f6\u8fc7\u51fa\u5c0f\u4e48\u8d77\u4f60\u90fd\u628a\u597d\u8fd8\u591a\u6ca1\u4e3a\u53c8\u53ef\u5bb6\u5b66\u53ea\u4ee5\u4e3b\u4f1a\u6837\u5e74\u60f3\u751f\u540c\u8001\u4e2d\u5341\u4ece\u81ea\u9762\u524d\u5934\u9053\u5b83\u540e\u7136\u8d70\u5f88\u50cf\u89c1\u4e24\u7528\u5979\u56fd\u52a8\u8fdb\u6210\u56de\u4ec0\u8fb9\u4f5c\u5bf9\u5f00\u800c\u5df1\u4e9b\u73b0\u5c71\u6c11\u5019\u7ecf\u53d1\u5de5\u5411\u4e8b\u547d\u7ed9\u957f\u6c34\u51e0\u4e49\u4e09\u58f0\u4e8e\u9ad8\u624b\u77e5\u7406\u773c\u5fd7\u70b9\u5fc3\u6218\u4e8c\u95ee\u4f46\u8eab\u65b9\u5b9e\u5403\u505a\u53eb\u5f53\u4f4f\u542c\u9769\u6253\u5462\u771f\u5168\u624d\u56db\u5df2\u6240\u654c\u4e4b\u6700\u5149\u4ea7\u60c5\u8def\u5206\u603b\u6761\u767d\u8bdd\u4e1c\u5e2d\u6b21\u4eb2\u5982\u88ab\u82b1\u53e3\u653e\u513f\u5e38\u6c14\u4e94\u7b2c\u4f7f\u5199\u519b\u5427\u6587\u8fd0\u518d\u679c\u600e\u5b9a\u8bb8\u5feb\u660e\u884c\u56e0\u522b\u98de\u5916\u6811\u7269\u6d3b\u90e8\u95e8\u65e0\u5f80\u8239\u671b\u65b0\u5e26\u961f\u5148\u529b\u5b8c\u5374\u7ad9\u4ee3\u5458\u673a\u66f4\u4e5d\u60a8\u6bcf\u98ce\u7ea7\u8ddf\u7b11\u554a\u5b69\u4e07\u5c11\u76f4\u610f\u591c\u6bd4\u9636\u8fde\u8f66\u91cd\u4fbf\u6597\u9a6c\u54ea\u5316\u592a\u6307\u53d8\u793e\u4f3c\u58eb\u8005\u5e72\u77f3\u6ee1\u65e5\u51b3\u767e\u539f\u62ff\u7fa4\u7a76\u5404\u516d\u672c\u601d\u89e3\u7acb\u6cb3\u6751\u516b\u96be\u65e9\u8bba\u5417\u6839\u5171\u8ba9\u76f8\u7814\u4eca\u5176\u4e66\u5750\u63a5\u5e94\u5173\u4fe1\u89c9\u6b65\u53cd\u5904\u8bb0\u5c06\u5343\u627e\u4e89\u9886\u6216\u5e08\u7ed3\u5757\u8dd1\u8c01\u8349\u8d8a\u5b57\u52a0\u811a\u7d27\u7231\u7b49\u4e60\u9635\u6015\u6708\u9752\u534a\u706b\u6cd5\u9898\u5efa\u8d76\u4f4d\u5531\u6d77\u4e03\u5973\u4efb\u4ef6\u611f\u51c6\u5f20\u56e2\u5c4b\u79bb\u8272\u8138\u7247\u79d1\u5012\u775b\u5229\u4e16\u521a\u4e14\u7531\u9001\u5207\u661f\u5bfc\u665a\u8868\u591f\u6574\u8ba4\u54cd\u96ea\u6d41\u672a\u573a\u8be5\u5e76\u5e95\u6df1\u523b\u5e73\u4f1f\u5fd9\u63d0\u786e\u8fd1\u4eae\u8f7b\u8bb2\u519c\u53e4\u9ed1\u544a\u754c\u62c9\u540d\u5440\u571f\u6e05\u9633\u7167\u529e\u53f2\u6539\u5386\u8f6c\u753b\u9020\u5634\u6b64\u6cbb\u5317\u5fc5\u670d\u96e8\u7a7f\u5185\u8bc6\u9a8c\u4f20\u4e1a\u83dc\u722c\u7761\u5174\u5f62\u91cf\u54b1\u89c2\u82e6\u4f53\u4f17\u901a\u51b2\u5408\u7834\u53cb\u5ea6\u672f\u996d\u516c\u65c1\u623f\u6781\u5357\u67aa\u8bfb\u6c99\u5c81\u7ebf\u91ce\u575a\u7a7a\u6536\u7b97\u81f3\u653f\u57ce\u52b3\u843d\u94b1\u7279\u56f4\u5f1f\u80dc\u6559\u70ed\u5c55\u5305\u6b4c\u7c7b\u6e10\u5f3a\u6570\u4e61\u547c\u6027\u97f3\u7b54\u54e5\u9645\u65e7\u795e\u5ea7\u7ae0\u5e2e\u5566\u53d7\u7cfb\u4ee4\u8df3\u975e\u4f55\u725b\u53d6\u5165\u5cb8\u6562\u6389\u5ffd\u79cd\u88c5\u9876\u6025\u6797\u505c\u606f\u53e5\u533a\u8863\u822c\u62a5\u53f6\u538b\u6162\u53d4\u80cc\u7ec6";
        String ch = base.charAt(new Random().nextInt(base.length()))+"";
        
        /*StringBuffer sb = new StringBuffer();
         String temp = "";
		 String[] rBase = {"0" , "1" , "2" , "3" , "4" , "5" , "6" , "7" ,   
                 "8" , "9" , "a" , "b" , "c" , "d" , "e" , "f" };  
         int r1 = random.nextInt(5)+11 ;     //生成第1位的区码  
        String strR1 = rBase[r1] ;      //生成11～15的随机数  
        int r2 ;        //生成第2位的区码  
        if(r1 == 15)  
           r2 = random.nextInt(7) ;    //生成0～7的随机数  
         else  
            r2 = random.nextInt(16) ;   //生成0～16的随机数  
         String strR2 = rBase[r2] ;  
        int r3 = random.nextInt(6) + 10 ;   //生成第1位的位码  
        String strR3 = rBase[r3] ;  
         int r4 ;        //生成第2位的位码  
        if(r3 == 10)  
           r4 = random.nextInt(15) + 1;    //生成1～16的随机数  
         else if(r3 == 15)  
            r4 = random.nextInt(15) ;       //生成0～15的随机数  
       else  
             r4 = random.nextInt(16) ;       //生成0～16的随机数  
        String strR4 = rBase[r4] ;  
         //将生成的机内码转换成数字  
       byte[] bytes = new byte[2]   ;        
         String strR12 = strR1 + strR2 ;     //将生成的区码保存到字节数组的第1个元素中  
         int tempLow = Integer.parseInt(strR12, 16) ;  
        bytes[0] = (byte)tempLow;  
         String strR34 = strR3 + strR4 ;     //将生成的区码保存到字节数组的第2个元素中  
        int tempHigh = Integer.parseInt(strR34, 16) ;  
         bytes[1] = (byte)tempHigh;  
        temp = new String(bytes,"GBK");           //根据字节数组生成汉字    
        sb.append(temp);*/
		return ch;
	}
	
}
