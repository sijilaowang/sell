package com.zx.sell.repository;

import com.zx.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> byId = repository.findById(1);
        System.out.println(byId);
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("test");
        productCategory.setCategoryType(10);
        System.out.println(productCategory);
        ProductCategory save = repository.save(productCategory);
        Assert.assertNotEquals(null,save);
    }
    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,10);
        List<ProductCategory> productCategories = repository.findByCategoryTypeIn(list);
        System.out.println(productCategories);
        Assert.assertNotEquals(0,productCategories);
    }
}