package com.jms.dao;

import com.jms.bean.Product;
import com.jms.bean.ProductImage;
import com.jms.dao.impl.ProductImageDAOImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductImageDAOTest {
    private ProductImageDAO productImageDAO = new ProductImageDAOImpl();

    @Test
    public void getTotal() {
        System.out.println(productImageDAO.getTotal());
    }

    @Test
    public void add() {
        ProductImage productImage = new ProductImage();

        Product product = new Product();
        product.setId(1);
        productImage.setProduct(product);
        productImage.setType("type_detail");

        productImageDAO.add(productImage);
    }

    @Test
    public void update() {
        ProductImage productImage = new ProductImage();
        Product product = new Product();
        product.setId(3);
        productImage.setProduct(product);
        productImage.setType("type_detail");


        productImageDAO.update(productImage);
    }

    @Test
    public void delete() {

        productImageDAO.delete(3);
    }

    @Test
    public void get() {
        System.out.println(productImageDAO.get(1));
    }

    @Test
    public void list() {

        Product product = new Product();
        product.setId(1);

        System.out.println(productImageDAO.list(product, "type_detail"));
    }

    @Test
    public void testList() {
        Product product = new Product();
        product.setId(1);

        productImageDAO.list(product, "type_single", 0, 2).forEach(System.out::println);
    }
}