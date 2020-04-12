/*
类型转换：数据范围从小到大隐式转换，例如long转成float

显式转换，需要手动转换数据类型。例如int转成float
*/

public class Demo6{
	public static void main(String[] args){
		System.out.println(1024);
		System.out.println(3.14);
		// 隐式类型转换
		float num1 = 100;
		System.out.println(num1);
		
		// 强制类型转换:特点，代码需要进行特殊的个数处理，
		// 格式：范围小的类型 范围小的变量名 = （范围小的类型）原本范围的数据
		int num2 = (int) 100L;
		// 如果右侧数据本来就很大，超过了int范围，就会精度益处
		// 强制类型转换一般不推荐使用，
		System.out.println(num2);
		// 如果强制转化， 就会出错
		int num3 = (int) 6000000000L;
		System.out.println(num3);  // 1705032704 int最大表示17亿
		
		// 精度损失
		int num4 = (int) 3.8;
		System.out.println(num4);  // 输出3，所有小数位都会被舍弃
		
		// byte/short/char都可以使用数学运算，例如加法+，
		// 再进行运算的时候，会被首先提升成为int类型，然后再计算
		char zifu = 'A';
		System.out.println(zifu + 1);  // 输出66，因为将A变成int类型了
		
		byte num5 = 40;
		byte num6 = 50;
		// byte + byte ---> int + int ---> int
		int res = num5 + num6; 
		System.out.println(res);
		// short类型转换成int
		short num7 = 60;
		short res2 = (short) (num7 + num6);
		System.out.println(res2);
		// 字符0 使用48表示，字母A 使用65表示，字母a 使用97表示
		char zifu3 = '0';
		System.out.println(zifu3 + 0);  // 输出48，A表示65，a表示97
	}
}
