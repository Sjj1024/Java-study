import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/ServletDownFile")
public class ServletDownFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中判断获取数据的参数是啥
        String parameter = request.getParameter("filename");
        System.out.println(parameter);
        if (parameter.endsWith("jpg")) {
            System.out.println("下载的是图片数据类型");
        } else if (parameter.endsWith("mp4")) {
            System.out.println("下载的是视频数据类型");
        }
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/image/" + parameter);
        String mimeType = servletContext.getMimeType(parameter);

        // 设置响应体数据类型为附件形式的
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(parameter.getBytes()));
        response.setHeader("content-type", mimeType);
        // 获取资源的绝对路径和mime类型
        FileInputStream fis = new FileInputStream(realPath);
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedInputStream bufferinput = new BufferedInputStream(fis);
        // 读取资源数据，并将数据返回给浏览器下载
        byte[] by = new byte[1204];
        int read = bufferinput.read(by);
        while (read != -1) {
            outputStream.write(by);
            read = bufferinput.read(by);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
