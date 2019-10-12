/*
注意事项：
对于byte、short/char三种类型，如果右侧赋值的数据没有超过范围
那么java编译器会自动隐含地为我们补上一个（byte）（short）（char）
如果右侧直接超过了右侧范围，编译器直接报错;

在右侧全都是常量参与运算，没有任何变量参与运算，那编译的时候直接运算赋值了
如果有变量参与，就不进行这种优化了
*/
public class Demo9{
	public static void main(String[] args){
		byte num1 = 30;
		System.out.println(num1);
		char zifu = 65;
		System.out.println(zifu);
	}
}
