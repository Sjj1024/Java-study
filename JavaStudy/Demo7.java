/*
运算符：加减乘除
表达式：+ - * / 
除法：整数除整数，得到的还是整数，不看余数
取余运算符：% 
一旦运算当中有不同类型的数据，那么结果将会是数据类型范围大的那种.
任何数据类型和字符串连接，都会变成str类型
优先级问题：str + int + int 最后都是str后再相加
自增自减运算符 ++ --
++a 单独使用的时候：先加一，再使用
a++ 先使用a，再加一
--也是同样的道理
常量不支持自增或自减;

赋值运算符:
基本赋值：
=

复合赋值：
+=  当相当于a = a + 1
-=	b 
*=
/=
%=

只有变量才能使用赋值运算：
比较运算符：
	==
	>
	<
	<=
	>=
	!=
逻辑运算符：
与 &&
或 ||
非 ！
	
一元运算符：只需要一个数据就可以进行操作的运算符，例如++，--，！
二元运算符：需要两个数据才可以操作的运算符，例如-，+，*，/
三元运算符：需要三个数据需要操作的，格式： 数据类型 变量名称 = 条件判断？表达式A，表达式B；

*/

public class Demo7{
	public static void main(String[] args){
		System.out.println(20 + 100);
		int a = 20;
		int b = 30;
		System.out.println(a + b);
		System.out.println(a / 2.5);
		System.out.println(a % 2.5);
		System.out.println("我爱你" + "中国");
		System.out.println("我爱你" + 20);
		// 使用自增运算符
		System.out.println(++a);
		System.out.println(a++);
		System.out.println(a);
		// 逻辑运算符：
		System.out.println(! true);
		int c = 20;
		System.out.println(c);
		// 三元运算符
		int max = a > b ? a : b;
		System.out.println(max);
	}
}
