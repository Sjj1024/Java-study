数据库的操作:

1、数据库的增删改查crad:
create : 创建
create database 数据库名称;
create database 数据库名称 character utf8;
create database if not exists 数据库名称; # 如果不存在，就删除

alter : 更新或修改
alter database 数据库名字 character gbk;

show ：查询
show databases;
show create database 数据库名；

drop: 删除数据库
drop database 数据库名称;
drop database if exits 数据库名称; # 如果存在就删除


2、数据表的操作：CRUD
show :查询数据表
show tables;
desc 表名; # 查看表中数据结构

create:创建数据表，表中的数据类型大概有：整数int，小数double，时间日期datetime(包含年月日时分秒)，字符串varchar，时间戳timestap(包含年月日时分秒，如果没有赋值，会默认使用系统时间)
creat table 表明(
	id int,
	name varchar(32),
	score double(4,1),
	borthday datetime,
	insert_time timestamp
);

create table 表明 like 被复制的表明;

drop:删除表
drop table 表名;
drop table if exist 表明;

alter:修改表
修改表明：alter table 表明 rename to 新的表明;
改变字符集：alter table 表名 character set 字符集;
添加一列：alter table 表名 add 列名 数据类型;
修改列名称和数据类型：
alter table 表明 change 列名 新列名 新数据类型;
alter table 表明 modify 列名 varchar(10);

删除列：
alter table 表名 drop 列名;



3、增删改表中的数据
添加数据：insert
insert into 表名(列名，列名， 列名) value(值，值，值);

删除数据：delete 
delete from 表名 where id=1;
delete from 表名; 表示删除表中所有记录
truncate table 表名; 删除表，然后创建一个一模一样的空表


修改数据：update
update student set age = 19 where id=1;
update student set age = 20, score =100 where id =2;


查询数据:select
select * from 表明; 查询所有的列数据
完整的查询语句组成：SFWGHOL
select 字段列表 from 表名列表 where 条件列表 group by 分组字段 having 分组之后的条件 order by 排序 limit 分页限定;

去重查看结果:
select distinct name from student;

