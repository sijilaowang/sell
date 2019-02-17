package com.zx.sell.repository;

import com.zx.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("22223");
        productInfo.setProductName("大保健");
        productInfo.setCategoryType(1);
        productInfo.setProductDescription("舒服");
        productInfo.setProductIcon("http://baidu.com");
        productInfo.setProductPrice(new BigDecimal(480));
        productInfo.setProductStatus(1);
        productInfo.setProductStock(100);
        ProductInfo productInfo1 = repository.save(productInfo);
        Assert.assertNotNull(productInfo1);
    }
    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = repository.findByProductStatus(1);
        Assert.assertNotEquals(0,productInfos);
    }
}