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
        List<Seller> all = sellerDao.findAll();
        
    }
}
