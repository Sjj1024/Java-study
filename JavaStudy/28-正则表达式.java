package ReDemo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {
    public static void main(String[] args) {
        // 使用正则表达式
        String html = "<a href=\"13183087364http://q.cnblogs.com\" class=\"menu\">博问15670339118</a> ::";
        // 创建正则表达式内容
        Pattern p = Pattern.compile("http://.*?\\.com");
        // 创建匹配对象
        Matcher m = p.matcher(html);
        // m.find查看是否匹配到，返回true或false
        // m.group()返回匹配到的内容
        while (m.find()){
            System.out.println(m.group());
        }
        //只有当m.find为true时，后面的start，end和group才可以使用
        // start()返回匹配到的字符串开始位置索引
//        System.out.println(m.start());
        // end()返回匹配到字符串结束位置索引
//        System.out.println(m.end());

    }
}
