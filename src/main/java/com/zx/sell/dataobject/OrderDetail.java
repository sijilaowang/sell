package com.zx.sell.dataobject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zx.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class OrderDetail {
    @Id
    /**主键*/
    private String detailId;
    /**订单id*/
    private String orderId;
    /**商品id*/
    private String productId;
    /**商品名字*/
    private String productName;
    /**单价*/
    private BigDecimal productPrice;
    /**商品数量*/
    private Integer productQuantity;
    /**小图*/
    private String productIcon;
    /**创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /**修改时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
}
