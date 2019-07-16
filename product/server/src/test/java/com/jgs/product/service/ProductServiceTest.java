package com.imooc.product.service;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests{
    @Autowired
    private ProductService productService;
    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findList() throws Exception {
        List<ProductInfo> result=productService.findList(Arrays.asList("1548310966167586212"));
        Assert.assertTrue(result.size()>0);
    }
}