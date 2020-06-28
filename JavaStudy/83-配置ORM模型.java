package it.com.heima.bean;


import javax.persistence.*;

//Entity声明此类是一个实体类，table声明此类和tab_seller表建立关系
@Entity
@Table(name = "tab_seller")
public class Seller {
    // ORM对象关系映射,@Id声明此属性为主键，@GeneratedValue声明生成策略，strategy声明策略是自动增长，@Columen声明和数据库中的sid字段相对应
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sid")
    private Integer id;

    @Column(name = "sname")
    private String name;

    @Column(name = "consphone")
    private String phone;

    @Column(name = "address")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
