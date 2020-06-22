package it.com.heima.controller;

import it.com.heima.bean.Accent;
import it.com.heima.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

// 相当于控制器，MVC中的c，只有写上这个注解，框架才会识别到，其实底层还是servlet
// RequestMapping可以写到类上，也可以写到方法上，写到类上，表示一级路径，
@Controller
@RequestMapping("/app")
public class FirstController {

    // RequestMapping写到方法上表示二级路径，访问二级路径的话，就需要/app/first这种形式了
    // value 就是路径，RequestMapping中只有一个参数，可以省略value，method表示请求方式
    @RequestMapping(value = "/first", method = {RequestMethod.GET})
    @ResponseBody
    public String first(String name) {
        // 而且spring会自动将请求参数映射到方法的参数中，get请求的话，会将?后面的参数通过String 传递过来，
        // POST请求的话，也可以通过javabean对象映射，其内部使用的就是映射
        System.out.println("接收到的name是:" + name);
        return "first hello world";
    }

    // 当封装成JAVABean的例子
    @RequestMapping("/adduser")
    @ResponseBody
    public String beanTest(User user) {
        // 会自动将传递过来的form表单中name对应的属性和user中的属性匹配，并生成user对象传递进来
        System.out.println(user);
        Map<String, Accent> maps = user.getMaps();
        return "nihao javabean";
    }

    // 前端传递过来的属性和参数名称对不上的时候，可以使用
    @RequestMapping("/requestParam")
    @ResponseBody
    // 前端传递过来是username，而我们接收是用name，所以需要使用RequestParam指定传递过来的名字
    public String requestParam(@RequestParam(name = "username") String name) {
        System.out.println(name);
        return "can shumingzi duibushagn";
    }
}
