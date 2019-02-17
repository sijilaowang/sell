package com.zx.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {

    @Id
    /**商品ID*/
    private String productId;
    /**商品名称*/
    private String productName;
    /**单价*/
    private BigDecimal productPrice;
    /**库存*/
    private Integer productStock;
    /**商品描述*/
    private String productDescription;
    /**商品状态，0正常1下架*/
    private Integer productStatus;
    /**小图*/
    private String  productIcon;
    /**类目编号*/
    private Integer categoryType;


}
