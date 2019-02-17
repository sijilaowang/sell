package com.zx.sell.dataobject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zx.sell.enums.OrderStatusEnum;
import com.zx.sell.enums.PayStatusEnum;
import com.zx.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@DynamicUpdate
@Data
@Proxy(lazy = false)
public class OrderMaster {

    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /**支付状态,默认0 未支付*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /**创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /**修改时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private  Date updateTime;

}
