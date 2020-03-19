package HanShu;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ManyJiekou {
    public static void main(String[] args) {
        System.out.println("常用的函数式接口介绍和使用");
        // 第一个：supplier接口，称为生产型接口，指定接口的泛型是什么类型，那么接口中的get方法就会生产什么类型的数据
        String res = use_supplier(()->"我是你大爷");
        System.out.println(res);

        // 使用例子：返回数组中原色的最大值
        System.out.println("--------------------------------");
        int[] array = {3, 2, 333, 88, 299};
        int max = get_Max(()->{
            // 定义一个初始最大值变量
            int num = array[0];
            // 遍历数组，找到最大值，将初始最大值替换掉，最后返回这个最大值
            for (int i : array) {
                if (i > num) {
                    num = i;
                }
            }
            return num;
        });
        System.out.println("找到的最大值是:" + max);

        // consumer接口是一个消费型接口，就是使用型接口，也可以理解成使用
        System.out.println("--------------------------");
        String xingming = "王思聪";
        use_consumer(xingming, (String name)->{
            // 可以直接使用打印出来，也可以将字符串翻转后使用
            System.out.println(name);

            // 或者将其翻转后输出，字符串翻转可以使用StringBuffer
            System.out.println(new StringBuffer(name).reverse().toString());
        });

        // consumer接口中的andThen方法可以将两个consumer接口连接起来挨个使用
        System.out.println("------------------------------");
        String str = "woshishui";
        use_andthen(str, (String name)->{
            System.out.println(name.toUpperCase() + "111111111111");
        }, (String name)->{
            System.out.println(name.toLowerCase() + "222222222222");
        });

        // 使用andThen的一个例子，将一个字符串数组按照特定格式输出，
        String[] list = {"迪丽热巴，女，12", "古力娜扎，女，16", "赵丽颖，女，18"};
        demo_andthen(list, (String name)->{
            String[] split = name.split("，");
            System.out.println("姓名:" + split[0]);
        }, (String name)->{
            String[] split = name.split("，");
            System.out.println("年龄:" + split[1]);
        });

        // Predicate接口主要用来对数据进行判断,返回真或者假
        System.out.println("--------------------------------");
        String lower = "x";
        boolean b = use_predicate(lower, (String low) -> {
            boolean empty = low.isEmpty();
            boolean s = low.endsWith("s");
            return empty;
        });
        System.out.println("use_predicate返回的结果是:" + b);
    }

    private static boolean use_predicate(String str, Predicate<String> pre) {
        return pre.test(str);
    }

    private static void demo_andthen(String[] array, Consumer<String> con1, Consumer<String> con2) {
        for (String s : array) {
            con1.andThen(con2).accept(s);
        }
    }

    private static void use_andthen(String name, Consumer<String> con1, Consumer<String> con2) {
        // 使用andthen方法将两个consumer接口挨个使用，哪个在前，先使用哪个
        con1.andThen(con2).andThen(con1).accept(name);
    }

    private static void use_consumer(String name, Consumer<String> con) {
        // consumer接口种有一个accept方法，传递一个指定类型的数据，然后进行使用,具体怎么使用，就可以使用lambda表达式指定
        con.accept(name);
    }

    private static Integer get_Max(Supplier<Integer> sup) {
        return sup.get();
    }

    private static String use_supplier(Supplier<String> sup) {
        // 这个接口中有一个get方法，会返回指定的泛型数据String
        return sup.get();
    }
}
