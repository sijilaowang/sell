package com.zx.sell.service.impl;

import com.zx.sell.dto.OrderDTO;
import com.zx.sell.enums.ResultEnum;
import com.zx.sell.exception.SellException;
import com.zx.sell.service.BuyerService;
import com.zx.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO details(String openid, String orderId) {
        return checkOwnerOpenId(openid,orderId);
    }

    @Override
    public OrderDTO cancel(String openid, String orderId) {
        OrderDTO orderDTO = checkOwnerOpenId(openid,orderId);
        if(orderDTO == null) {
            log.error("【取消订单】订单不存在！orderDTO={}",orderDTO);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOwnerOpenId(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null) {
            return null;
        }
        if(!orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("【查询订单】当前openId不一致！openid={}，orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
