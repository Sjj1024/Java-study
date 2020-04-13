package WebDemo;

/*
* bs架构的web技术，服务器上有动态资源和静态资源区分
* 动态资源：每个用户访问看到的效果都不一样
* 静态资源：例如css，html可以直接被浏览器解析的资源
* 动态资源需要先解析成静态资源，才能返回给浏览器识别，
* 端口号0- 65536之间
* 传输协议：HTTPS 和 HTTP
* Javase 是java基础版本
* JavaEE 是java企业级版本，
* Tomcat是Apach基金组织，是一个中小型的JavaEE服务器，是开源的免费的，很多中小型企业都会使用这个作为web服务器软件，
*
* tomcat目录结构：
* 启动bin目录下的startup.bat双击运行该文件即可，在浏览器输入localhost：8080即可访问到tomcat
*
* 将项目配置到tomcat中的几种方法：
* 1.将项目直接复制到webapps目录中，访问的时候，带上目录名称，例如：localhost：8080/目录/文件
* (将项目打成war包，将war包直接放到webapps中，将会自动解压)
*
* 2.通过修改配置文件conf/serval.xml中的配置，添加
* <Context docBase="目录" path="虚拟目录" />，虚拟目录就相当于路由
*
* 3.在conf中\catalina\localhost\创建任意名称的xml文件，在文件中编写
* <Context docBase="目录" />
*
*
* */
public class JingDong {
    public static void main(String[] args) {
        System.out.println("静态资源和动态资源");
    }
}
