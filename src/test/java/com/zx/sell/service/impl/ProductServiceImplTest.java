package com.zx.sell.service.impl;

import com.zx.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private  ProductServiceImpl productService;
    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("22223");
        Assert.assertEquals("22223",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setCategoryType(2);
        productInfo.setProductId("33333");
        productInfo.setProductName("java开发");
        productInfo.setProductPrice(new BigDecimal(9.88));
        productInfo.setProductStock(99);
        productInfo.setProductDescription("java 面向对象");
        productInfo.setProductIcon("www.apple.com.cn");
        productInfo.setProductStatus(1);
        ProductInfo save = productService.save(productInfo);
        Assert.assertNotNull(save);

    }
}