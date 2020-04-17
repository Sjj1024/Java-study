前端html页面:
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图片验证码</title>
    <script>
        window.onload = function (ev) {
            var elementById = document.getElementById("imagechange");
            var imagecode = document.getElementById("codeid");
            elementById.onclick = function (ev1) {
                // alert("111111111111111");
                // 之所以没有变化，是因为浏览器加载了内存中的图片，所以需要改变请求地址，随便带上一个参数，就不会加载这个了
                var number = Math.random();
                imagecode.src = "/cao/Servlet7?" + number;
            }
        }
    </script>
</head>
<body>
<div>使用js实现图片验证码点击切换的效果</div>
<div id="imagechange">
    <img src="/cao/Servlet7" alt="图片验证码" id="codeid">
    <a href="javasript:void(0)">点击切换验证码</a>
</div>
</body>
</html>


后端代码：
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 指定图片的宽和高
        int wight = 70;
        int height = 35;
        Random random = new Random();
        // 指定背景色
        Color bgColor = new Color(255, 255, 255);

        // 指定可选字符
        String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";

        // 创建一个图片对象
        BufferedImage image = new BufferedImage(wight, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(bgColor);
        g2.fillRect(0, 0, wight, height);
        StringBuilder sb = new StringBuilder();// 用来装载生成的验证码文本
        // 向图片中画4个字符
        for (int i = 0; i < 4; i++) {
            // 循环四次，每次生成一个字符
            int index = random.nextInt(codes.length());
            String s = codes.charAt(index) + "";// 随机生成一个字母
            sb.append(s); // 把字母添加到sb中
            float x = i * 1.0F * wight / 4; // 设置当前字符的x轴坐标
            g2.setColor(Color.red); // 字体颜色是红色
            g2.drawString(s, x, height - 5); // 画图
        }

        // 打印一下生成的字符是啥
        System.out.println(sb);
        // 获取响应输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 将图片输出到这个相应流返回给浏览器
        ImageIO.write(image, "png", outputStream); // 输出图片流

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
