package it.com.heima.service.impl;

import it.com.heima.bean.Seller;
import it.com.heima.dao.SellerDao;
import it.com.heima.service.impl.SellerServiceimpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

// 要加上这两个注解，声明此类是spring的测试类， 才会将Autowired自动注入到容器中
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceimplTest {

    @Autowired
    private SellerServiceimpl sellerServiceimpl;

    @Autowired
    private SellerDao sellerDao;

    @Test
    public void findAll() {
        System.out.println("开始单元测试");
        List<Seller> all = sellerServiceimpl.findAll();
        // List<Seller> all = sellerDao.findAll();
        for (Seller seller : all) {
            System.out.println(seller.getName());
        }
    }

    @Test
    public void findOne() {
        System.out.println("开始单元测试");
        // List<Seller> all = sellerServiceimpl.findAll();
        // List<Seller> all = sellerDao.findAll();
        Optional<Seller> byId = sellerDao.findById(1);
        if (byId.isPresent()) {
            Seller seller = (Seller) byId.get();
            System.out.println(byId.toString());
            System.out.println(seller);
            String name = seller.getName();
            System.out.println(name);
        }

    }

    @Test
    public void saveOne() {
        System.out.println("开始单元测试");
        Optional<Seller> byId = sellerDao.findById(1);
        // 查询出来的是Optional是防止NPE异常，查询出来之后，先检查一下isPresent，然后使用get方法获取到其中的值
        if (byId.isPresent()) {
            Seller seller = byId.get();
            seller.setName("我是修改过的名臣");
            sellerDao.save(seller);
            System.out.println("修改完成");
        }

    }
}
