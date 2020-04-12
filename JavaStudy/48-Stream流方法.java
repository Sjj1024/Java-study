package StreamLiu;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DemoStream {
    public static void main(String[] args) {
        System.out.println("使用stream流的方式操作集合和列表");
        // 使用filter方法对参数进行过滤
        System.out.println("---------------------");
        method_filter();

        // 使用终结方法foreach,是一个消费型接口，一旦使用后，流就关闭了，就不能再使用了
        System.out.println("--------------------");
        method_foreach();

        // 使用映射方法：map，里面传递一个Function接口，可以将一种类型转换为另一种类型
        System.out.println("-------------------");
        method_map();

        // count统计个数，这也是一个终结方法，返回long类型
        System.out.println("------------------");
        method_count();

        // limit方法：对流进行截取，只取前n个元素
        System.out.println("------------------");
        method_limit();

        // skip方法：跳过前n个元素
        System.out.println("-----------------");
        method_skip();

        // concat方法可以将两个流连接成一个流
        System.out.println("------------------");
        method_concat();
    }

    private static void method_concat() {
        // concat方法可以连接两个流
        Stream<String> liu2 = Stream.of("1", "2", "3");
        Stream<String> liu3 = Stream.of("4", "5", "6");
        Stream<String> concat = Stream.concat(liu2, liu3);
        concat.forEach(System.out::println);
    }

    private static void method_skip() {
        // 使用skip方法跳过前n个元素
        String[] liu = {"1", "2", "3", "2", "5", "6","7"};
        Stream<String> liu1 = Stream.of(liu);
        Stream<String> skip = liu1.skip(3);
        skip.forEach(System.out::println);
    }

    private static void method_limit() {
        Stream<String> liu = Stream.of("1", "2", "3", "4");
        Stream<String> limit = liu.limit(2);
        limit.forEach(System.out::println);
    }

    private static void method_count() {
        Stream<String> liu = Stream.of("1", "2", "3", "4");
        long count = liu.count();
        System.out.println("流的长度是:" + count);
    }

    private static void method_map() {
        Stream<String> liu = Stream.of("1", "2", "3");
        Stream<Integer> integerStream = liu.map(Integer::parseInt);
        integerStream.forEach(System.out::println);
    }

    private static void method_foreach() {
        // 使用静态方法将一串字符串转成集合列表
        Stream<String> liu = Stream.of("张无忌", "张三更", "张磊", "周润发", "周驰诺");
        liu.forEach(System.out::println);
        // 流中的数据只能被foreach一次，使用完就关闭了
//        liu.forEach(System.out::println);
    }

    private static void method_filter() {
        // stream关注的是做什么而不是怎么做，例如：
        String[] list = {"张无忌", "张三更", "张磊", "周润发", "周驰诺"};
        ArrayList<String> str_list = new ArrayList<>();
        str_list.add("张无忌");
        str_list.add("张三更");
        str_list.add("张磊");
        str_list.add("周润发");
        str_list.add("周驰诺");
        // jdk1.8之后，集合有一个新的方法stream可以将数组转成一个流，流中有一个方法filter，里面的参数就是函数式接口，
        // 所以可以通过lambda表达式来对元素进行过滤，最后有一个forEach方法，可以将元素一一遍历出来
        str_list.stream()
                .filter(name -> name.startsWith("张"))
                .filter(name -> name.length() == 3)
                .forEach(name -> System.out.println("最终结果是:" + name));
    }
}
