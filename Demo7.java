/*
运算符：加减乘除
表达式：+ - * / 
除法：整数除整数，得到的还是整数，不看余数
取余运算符：% 
一旦运算当中有不同类型的数据，那么结果将会是数据类型范围大的那种.
*/

public class Demo7{
	public static void main(String[] args){
		System.out.println(20 + 100);
		int a = 20;
		int b = 30;
		System.out.println(a + b);
		System.out.println(a / 2.5);
		System.out.println(a % 2.5);
	}
}
