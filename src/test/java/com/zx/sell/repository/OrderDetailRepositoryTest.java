package com.zx.sell.repository;

import com.zx.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456780");
        orderDetail.setOrderId("11122");
        orderDetail.setProductIcon("http://baidu.com");
        orderDetail.setProductId("112233");
        orderDetail.setProductName("人参果");
        orderDetail.setProductPrice(BigDecimal.valueOf(66000));
        orderDetail.setProductQuantity(78);
        OrderDetail save = repository.save(orderDetail);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("11122");
        System.out.println(orderDetailList);
        Assert.assertNotEquals(0,orderDetailList);
    }

}