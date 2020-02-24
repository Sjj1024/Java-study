package DemoNw;

public class Body {
    private String name = "身体";
    int num = 40;

    public class Heart{
        public void tiao(){
            int num = 30;
            System.out.println("心脏在跳动");
            System.out.println(num);
            System.out.println("内部类的成员属性" + num);
            // 外部类名称.this.外部类属性
            System.out.println("外部类的成员属性" + Body.this.num);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
