package com.zx.sell.controller;

import com.google.common.collect.Maps;
import com.zx.sell.VO.ResultVO;
import com.zx.sell.converter.OrderForm2OrderDTOConverter;
import com.zx.sell.dataobject.OrderDetail;
import com.zx.sell.dataobject.OrderMaster;
import com.zx.sell.dto.OrderDTO;
import com.zx.sell.enums.ResultEnum;
import com.zx.sell.exception.SellException;
import com.zx.sell.form.OrderForm;
import com.zx.sell.repository.OrderMasterRepository;
import com.zx.sell.service.OrderService;
import com.zx.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderMasterRepository repository;

    @Autowired
    private OrderService orderService;
    //创建订单
    @RequestMapping("/create")
    public ResultVO<Map<Integer,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.error("【创建订单】创建订单参数错误,orderMaster={}",bindingResult);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        //将表单传的值转换成为DTO形式
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String,String> map = Maps.newHashMap();
        map.put("orderId",result.getOrderId());
        return ResultVOUtil.success(map);
    }
    //订单列表
    @RequestMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0") String page,
                                         @RequestParam(value = "size",defaultValue =  "10") String size) {
        //openid 不能为空
        if(StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid 为空！");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = PageRequest.of(new Integer(page),new Integer(size));
        Page<OrderDTO> list = orderService.findList(openid, pageRequest);
        return ResultVOUtil.success(list.getContent());
    }
    //订单详情
    @RequestMapping("/details")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        //TODO 不安全的做法，需要改进
        OrderDTO one = orderService.findOne(orderId);
        return ResultVOUtil.success(one);
    }
    //取消订单
}
