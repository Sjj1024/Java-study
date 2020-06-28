1.先创建一个application.yml，在里面配置相关server和mysql配置：
server:
  port: 8088

spring:
  datasource:
    #    url: jdbc:mysql://10.151.40.233:3306/tool_management?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
    url: jdbc:mysql://localhost:3306/travel?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai
    username: root
    password: '521.huawei'
    driverClassName: com.mysql.jdbc.Driver
  jpa:
    # show-sql: true
    hibernate:
      ddl-auto: update
    database-platform: org.hibernate.dialect.MySQLDialect
  #设置返回的时间字符串转化方式
#  jackson:
#    date-format: yyyy-MM-dd HH:mm:ss
#    time-zone: GMT+8
  application:
    name: travel
    


2.引入相关jar包：
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.11</version>
            <!--<scope>runtime</scope>-->
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

    </dependencies>
