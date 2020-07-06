server:
  port: 8071
#  port: 8080
spring:
  debug: true
  datasource:
#    url: jdbc:mysql://10.151.233:3306/tool_management?characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
    url: jdbc:mysql://10.184.6.102:3306/ue_test?characterEncoding=utf-8&useLocalSessionState=true&serverTimezone=Asia/Shanghai&useSSL=false
    username: rot
    password: '!M123'
    driverClassName: com.mysql.jdbc.Driver
  jpa:
    # show-sql: true
    hibernate:
      ddl-auto: update
    database-platform: org.hibernate.dialect.MySQLDialect
  #设置返回的时间字符串转化方式
  jackson:
    date-format: yyyy-MM-dd HH:mm:ss
    time-zone: GMT+8
  application:
    name: tool-management

  # 配置mongodb
  data:
    mongodb:
      pool:
        hosts:
        #          - 10.118.176.110
        #          - 100.104.217.190
        #          - 10.184.161.44
        - 100.104.170.102
        - 100.104.202.197
        - 10.184.159.60
        ports:
        - 20000
        - 20000
        - 20000
        database: ue_testdata
        username: root
        password: root
        authentication-database: admin
        connections-per-host: 20000
        min-connections-per-host: 3

  # 配置redis
  redis:
    database: 0
    password: root
    # 连接超时时间（毫秒）
    timeout: 60000
    # 集群方式
    cluster:
      nodes: 10.162.241.181:7001,10.162.241.181:7002,10.162.241.181:7003
    pool:
      # 连接池最大连接数
      max-active: 500
      # 连接池最大阻塞等待时间（负数表示没有限制）
      max-wait: -1
      # 连接池最大空闲连接
      max-idle: 100
      # 连接池最小空闲连接
      min-idle: 20

eureka:
  client:
    service-url:
      # defaultZone: http://10.184.161.44:8761/eureka/
      defaultZone: http://10.184.157.136:8762/eureka/
    fetch-registry: true
    register-with-eureka: true
  instance:
    instance-id: ${spring.cloud.client.ipAddress}:${server.port}
    prefer-ip-address: true

#ftp服务器配置
ftp:
  ciftpUserName: gwx560741
  ciftpPassword: '@GK123456'
  ciftpHost: 10.130.34.239
  #ftp根目录
  ciftpRootPath: D:\ftp
  #非Python文件安装目录
  ciftpPath: install
  #Python文件安装目录
  ciftpPipPath: pip
  ciftpExePath: exe
  #Python源文件目录
  ciftpSourcePath: source-example-qy
  ciftpPort: 21


# 测试环境
#ftp:
#  ciftpUserName: qwx713044
#  ciftpPassword: QY199311172757@
#  ciftpHost: 10.151.40.233
#  #ftp根目录
#  ciftpRootPath: D:\ftp
#  #非Python文件安装目录
#  ciftpPath: install
#  #Python文件安装目录
#  ciftpPipPath: pip
#  #Python源文件目录
#  ciftpSourcePath: source-example-qy
#  ciftpPort: 21

#pypi服务设置
# 测试环境
#pypi:
#  #私有仓服务器
#  host: 10.130.34.239
#  #私有仓端口
#  port: 2808
#  #RPC服务器
#  pythonServerHost: 10.151.40.233
#  #RPC服务器端口
#  pythonServerPort: 9999
#  objectId: rpc-server

pypi:
  #私有仓服务器
  host: 10.162.241.181
  #私有仓端口
  port: 2808
  #RPC服务器
#  pythonServerHost: 10.151.40.233
  pythonServerHost: 10.130.34.239
#  pythonServerHost: 10.142.253.100
  #RPC服务器端口
  pythonServerPort: 9999
  objectId: rpc-server
git:
  #userName: gwx560741
  #password: QEdLMTIzNDU2
  userName: 0049
  password: RGVsdGjQu
  rootDir: D:\gitApp
  breezeIsource: https://isource-sh.huai.com/h00450679/breeze-app-startup.git
  breezeDir: D:\Breeze
  organization: 15637
  isourceUrl: http://rnd-ice.hi.com/api/v3/
  client_id: df496cb26cbfcb69beae6ed6bda90bd3b0696f0ac2fc7ee0693d2f2f0318d
  client_secret: 3d1bd1db6cce30238b749c349f6c3446f879283a49f6a6bd690849b64d98c
  redirect_uri: http://10.151.14.239:8093/AccessToken

