package com.zx.sell.service.impl;

import com.zx.sell.dataobject.OrderDetail;
import com.zx.sell.dataobject.OrderMaster;
import com.zx.sell.dto.OrderDTO;
import com.zx.sell.enums.OrderStatusEnum;
import com.zx.sell.enums.PayStatusEnum;
import com.zx.sell.enums.ResultEnum;
import com.zx.sell.service.OrderService;
import com.zx.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
   @Autowired
    private OrderServiceImpl orderService;
    String openId = "123456789";
   @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("六先生");
        orderDTO.setBuyerAddress("杭州市");
        //orderDTO.setBuyerAmount(BigDecimal.valueOf(99));
        orderDTO.setBuyerOpenid(openId);
        orderDTO.setBuyerPhone("18712344321");

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        OrderDetail orderDetail1 = new OrderDetail();

        orderDetail.setProductId("6654");
        orderDetail.setProductQuantity(1);

        orderDetail1.setProductId("4323");
        orderDetail1.setProductQuantity(2);
        orderDetailList.add(orderDetail);
        orderDetailList.add(orderDetail1);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO dto = orderService.create(orderDTO);
        log.info("result: {}",dto);
        Assert.assertNotNull(dto);
   }

   @Test
    public void getOne() {
       OrderDTO one = orderService.findOne("1545467717515203524");
       log.info("找到的结果是{}",one);
       Assert.assertNotNull(one);
   }

   @Test
    public void getOrderMaster() {
       OrderMaster orderMaster = orderService.getOrderMaster("1545467717515203524");
       System.out.println(orderMaster);
   }

   @Test
    public void findListTest() {
       PageRequest request = PageRequest.of(0,2);
       Page<OrderDTO> list = orderService.findList("123456789", request);
       list.forEach(e -> System.out.println(e.toString()));
       Assert.assertNotEquals(0,list.getContent().size());
   }

   @Test
    public void cancelTest() {
       OrderDTO orderDTO = orderService.findOne("1545468970665735872");
       OrderDTO result = orderService.cancel(orderDTO);
       Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
   }
   @Test
    public void finishedTest() {
       OrderDTO orderDTO = orderService.findOne("1545468970665735872");
       OrderDTO result = orderService.finish(orderDTO);
       Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
   }

   @Test
    public void paidTest() {
       OrderDTO orderDTO = orderService.findOne("1545468970665735872");
       OrderDTO result = orderService.paid(orderDTO);
       Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
   }
}