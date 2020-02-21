public class MethDemo {
    public static void main(String[] args) {
        // 数学中常用的一些方法：Math,绝对值abs，向上取整ceil,向下取整floor,四舍五入round;
        System.out.println(Math.abs(-2.5));

        // 向上取整ceil,只会取更大的整数值，
        System.out.println(Math.ceil(-10.7));
        System.out.println(Math.ceil(10.2));

        // 向下取整floor,只会取更小的整数值
        System.out.println(Math.floor(9.9));
        System.out.println(Math.floor(-8.6));

        // 四舍五入round取整数
        System.out.println(Math.round(8.4));
        System.out.println(Math.round(8.8));
    }
}
