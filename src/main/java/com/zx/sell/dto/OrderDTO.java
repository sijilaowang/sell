package com.zx.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zx.sell.dataobject.OrderDetail;
import com.zx.sell.enums.OrderStatusEnum;
import com.zx.sell.enums.PayStatusEnum;
import com.zx.sell.utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /**主键*/
    private String orderId;
    /**买家名字*/
    private String buyerName;
    /**买家电话*/
    private String buyerPhone;
    /**买家地址*/
    private String buyerAddress;
    /**买家微信openid*/
    private String buyerOpenid;
    /**订单总金额*/
    private BigDecimal buyerAmount;
    /**订单状态,默认0 新下单*/
    private Integer orderStatus;
    /**支付状态,默认0 未支付*/
    private Integer payStatus;
    /**创建时间*/
    private Date createTime;
    /**修改时间*/
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

    //加上这个注解数据转成json格式时会自动忽略这个字段
    @JsonInclude
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonInclude
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
