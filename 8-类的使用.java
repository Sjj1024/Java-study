/*
方法的使用：
public static void 方法名称() {
	方法体，可以包含任一条语句；
}
调用一个方法：
	方法名称();
*/
public class Demo8{
	public static void main(String[] args){
		// 这是农民
		farmer();
		// 这是商贩
		shoop();
		// 这是厨子
		cooker();
		// 这是客人
		me();
	}
	// 农民的方法
	public static void farmer(){
		System.out.println("播种");
		System.out.println("浇水");
		System.out.println("施肥");
		System.out.println("收割");
		System.out.println("卖给商贩");
	}
	// 商贩的方法
	public static void shoop(){
		System.out.println("运输到市场");
		System.out.println("抬高价格");
		System.out.println("吆喝叫卖");
		System.out.println("卖给厨子");
	}
	// 厨子的方法
	public static void cooker(){
		System.out.println("洗菜");
		System.out.println("切菜");
		System.out.println("炒菜");
		System.out.println("装盘");
	}
	// 客人的方法
	public static void me(){
		System.out.println("客人吃菜");
	}
}
