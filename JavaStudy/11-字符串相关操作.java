package StringUse;

/*
* String字符串：字符串的内容永不可变的，所以字符串是可以共享是用的，字符串效果上相当于字符数组，但是底层原理是字节数组
* 常见四种创建字符串的方法：三种构造方法，一种直接创建方法
* public String(),创建一个空白字符串，不含任何内容
* public String(char[] array),根据字符数组的内容，来创建对应的字符串
* public String(byte[] array),根据字节数组的内容，来创建对应的字符串
*  一种直接创建：String str = "字符串";
*
*  字符串常量池：直接使用双引号创建的字符串就在常量池中，
*  对于基本数据类型，进行的是数值的比较；
*  对于引用类型，进行比较的是地址值的比较；
*
* */
public class StrTest {
    public static void main(String[] args) {
        // String字符串经常创建的方法
        String str1 = new String();
        System.out.println("创建的第一个字符串是： " + str1);

        // 根据字符数组创建字符串
        char[] charArray = {'A', 'B', 'C'};
        String str2 = new String(charArray);
        System.out.println("创建的第二个字符串是： " + str2);

        // 根据字节数组来创建一个字符串
        byte[] byteArray = {97, 98, 99};
        String str3 = new String(byteArray);
        System.out.println("创建的第三个字符串是：" + str3);

        // 字符串比较常用方法
        // ==比较的是地址值，内容比较使用equals（）
        String str4 = "ABC";
        System.out.println(str2.equals(str4));

        // 忽略大小写进行比较：equalsIgnoreCase()
        String str5 = "abc";
        System.out.println(str5.equalsIgnoreCase(str4));

        // 获取姓关的常用方法;length(),concat(),charAt(),indexOf(),
        // length()获取字符串当中含有的字符个数，拿到字符串长度
        String str6 = "dfasjdfljalsjflajsdf";
        System.out.println("字符串长度是：" + str6.length());

        // concat(String str)将两个字符串拼接成一个新的字符串
        String str7 = str5.concat(str6);
        System.out.println("拼接后的字符串长度是: " + str7);

        // charAt()获取指定索引位置的单个字符，索引从0开始
        char ch = str7.charAt(5);
        System.out.println(ch);

        // indexOf()查找参数字符串当中首次出现的位置，如果没有找到，返回-1
        int local = str7.indexOf("sjj");
        System.out.println("首次出现的位置是：" + local);

        // 字符串的截取substring(begin)截取一直到结尾
        String str8 = str7.substring(3);
        System.out.println("截取到的字符串是".concat(str8));

        // substring（begin, end）截取指定区间的字符串，左闭右开
        String str9 = str7.substring(5, 8);
        System.out.println("指定区间的字符串是:".concat(str9));

        // string当中转换相关的常用方法:toCharArray（），getBytes(),replace()
        // toCharArray()将当前字符串拆分成字符数组作为返回值
        char[] chars = str7.toCharArray();
        System.out.println("转换后的字符数组是：" + chars);

        // getBytes()获取字节数组，在io流时特别常用
        byte[] bytes = str7.getBytes();
        System.out.println("获取到的字节数组是：");
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        // replace替换字符串
        String str10 = str7.replace("s", "*");
        System.out.println("替换后的字符串是:".concat(str10));

        // 字符串的分割方法split(),按照参数的规则，将字符串切分成若干部分
        // 其实参数是一个正则表达式:
        String[] strarray1 = str7.split("a");
        System.out.println("切后的字符串数组是：");
        for (int i = 0; i < strarray1.length; i++) {
            System.out.println(strarray1[i]);
        }
    }
}
