package com.zx.sell.repository;

import com.zx.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerAddress("杭州市余杭区市民之家1楼101");
        orderMaster.setBuyerAmount(BigDecimal.valueOf(123.22));
        orderMaster.setBuyerName("周黑鸭");
        orderMaster.setBuyerOpenid("weixin123");
        orderMaster.setBuyerPhone("18922213333");
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    public void findOne() {

    }
    @Test
    public void findByOpenId() {
       PageRequest request = PageRequest.of(0,1);
        Page<OrderMaster> result = repository.findByBuyerOpenid("weixin123",request);
        System.out.println(result.getTotalElements());
    }
}