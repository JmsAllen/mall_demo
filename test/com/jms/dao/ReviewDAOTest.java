package com.jms.dao;

import com.jms.bean.Category;
import com.jms.bean.Product;
import com.jms.bean.Review;
import com.jms.bean.User;
import com.jms.dao.impl.ReviewDAOImpl;
import com.jms.utils.DateUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ReviewDAOTest {
    private ReviewDAO reviewDAO = new ReviewDAOImpl();

    @Test
    public void add() {
        Review review = new Review();
        review.setContent("Nike 短袖真是棒");

        review.setCreateDate(new Date());

        Product product = new Product();
        product.setOriginalPrice(555);
        product.setName("Nike 长袖");
        product.setSubTitle("super 长袖");
        product.setPromotePrice(333);
        product.setStock(2000);

        Category category = new Category();
        category.setId(1);
        category.setName("男装");

        product.setCategory(category);
        product.setCreateDate(new Date());
        review.setProduct(product);

        User user = new User();
        user.setId(1);

        review.setUser(user);

        reviewDAO.add(review);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1);

        Product product = new Product();
        product.setId(1);

        Review review = new Review("update this review", new Date(), user, product, 1);
        reviewDAO.update(review);
    }

    @Test
    public void delete() {
        reviewDAO.delete(5);
    }

    @Test
    public void get() {
        System.out.println(reviewDAO.get(1));
    }

    @Test
    public void list() {
        reviewDAO.list(1).forEach(System.out::println);
    }

    @Test
    public void getCount() {
        System.out.println(reviewDAO.getCount(8));
    }

    @Test
    public void testList() {
        reviewDAO.list(2,0,3).forEach(System.out::println);
    }


    @Test
    public void isExist() {
        System.out.println(reviewDAO.isExist("衣服可以哦", 2));
    }
}