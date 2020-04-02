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


数据表的操作：CRUD
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
