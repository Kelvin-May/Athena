# AthenaServer

## 功能描述
    基于spring+springMVC+myBatis+druid的后台Server工程，主要通过JSON格式提供前端接口

## 数据库配置
    1.本项目使用的是mysql数据库
    2.新建数据库命名 'athena'
    3.导入sql文件夹下的 athena.sql 文件
    4.因数据库账户密码比较隐私就没有上传我的配置了，需要自己在src-resources下新建jdbc.properties，配置如下(注：所有的中文名都需要替换成自定义的)
        
        jdbc.driver=com.mysql.jdbc.Driver
        jdbc.url=jdbc:mysql://你的数据库地址:端口/athena?useUnicode=true&characterEncoding=utf8&useSSL=false
        jdbc.username=账户
        jdbc.password=密码
        
## 环境
    1.建议使用Java8和tomcat8
    2.本工程采用IntelliJ IDEA + Maven搭建