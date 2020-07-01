# Java-study
Java学习笔记

# Java 真棒

jap学习连接：https://www.cnblogs.com/lone5wolf/p/10940827.html

VUE基础知识1：数组forEach：https://blog.csdn.net/qq_25354709/article/details/86548332

java强制类型转换：https://www.cnblogs.com/jpfss/p/10929160.html

Spring Data JPA+模糊查询：https://blog.csdn.net/czx1204/article/details/79131281

Vue.js中ref ($refs)用法举例总结：https://www.jianshu.com/p/3bd8a2b07d57

用java解压缩zip和rar的工具类：https://www.cnblogs.com/MrLiu2016/p/7205526.html

Element-Ui组件（十）Select 选择器：https://blog.csdn.net/sps900608/article/details/79445134


Element-Ui组件（二十七）Badge 标记:https://blog.csdn.net/sps900608/article/details/79456031

elementUI vue table status的状态列颜色变化和操作列状态显示(停用, 启用):https://www.cnblogs.com/yysbolg/p/9877763.html

Java四舍五入时保留指定小数位数：https://www.cnblogs.com/yysbolg/p/11095548.html

element-ui文件上传 做类型大小的限制： https://www.cnblogs.com/yysbolg/p/11095901.html

分页PageRequest、PageImpl:https://blog.csdn.net/Jae_Wang/article/details/80630776

Java 集合框架:https://www.runoob.com/java/java-collections.html

使用Navicat生成ER关系图并导出：https://blog.csdn.net/xu1227233860/article/details/78278393
https://blog.csdn.net/xunxue1523/article/details/104412442
https://blog.csdn.net/qq_36025814/article/details/84137314
https://blog.csdn.net/qq_37486501/article/details/79842653

MySQL创建数据表并建立主外键关系：https://www.cnblogs.com/Brambling/p/9263377.html

创建外键时候的语句
create table student
(
    sid int not null auto_increment,
    sname varchar(10) not null,
		sage int,
		sgender varchar(1),
		shome VARCHAR(255),
		swaijian int,
    primary key (sid),
		foreign key (swaijian) references teacher(tid) on DELETE CASCADE on UPDATE CASCADE
)
engine=innodb auto_increment=1 default charset=utf8 collate=utf8_general_ci;
