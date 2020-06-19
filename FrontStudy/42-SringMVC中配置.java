package it.com.heima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// 相当于控制器，MVC中的c，只有写上这个注解，框架才会识别到，其实底层还是servlet
// RequestMapping可以写到类上，也可以写到方法上，写到类上，表示一级路径，
@Controller
@RequestMapping("/app")
public class FirstController {

    // RequestMapping写到方法上表示二级路径，访问二级路径的话，就需要/app/first这种形式了
    // value 就是路径，RequestMapping中只有一个参数，可以省略value，method表示请求方式
    @RequestMapping(value = "/first", method = {RequestMethod.GET})
    @ResponseBody
    public String first() {
        // 而且spring会自动将请求参数映射到方法的参数中，get请求的话，会将?后面的参数通过String 传递过来，
        // POST请求的话，也可以通过javabean对象映射，其内部使用的就是映射
        return "first hello world";
    }
}
