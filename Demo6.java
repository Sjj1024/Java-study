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
		System.out.println(num2);
	}
}
