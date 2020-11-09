@SpringBootTest
class SpringsecurityOauthUaaApplicationTests {

    @Test
    void contextLoads() {
        // 写一个冒泡排序算法: 数组的长度是固定的，内容也不可以改变，类似于python的元祖
        int[] arra = {55, 42, 11, 88, 12};
        for (int i = 1; i < arra.length; i++) {
            for (int j = 0; j < arra.length - i; j++) {
                if (arra[j] > arra[j + 1]) {
                    int temp = arra[j];
                    arra[j] = arra[j + 1];
                    arra[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后的结果:");
        for (int i = 0; i < arra.length; i++) {
            System.out.println(arra[i]);
        }
    }


    @Test
    void paiXu() {
        System.out.println("开始排序操作:");
        List<Integer> arr = new ArrayList<Integer>();  // 列表的动态的，大小和内容都可以改变，比较灵活
        arr.add(52);
        arr.add(23);
        arr.add(11);
        arr.add(71);
        for (int i = 1; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        System.out.println("排序后的结果是：");
        System.out.println(arr.toString());
    }
}
