package com.jms.dao;

import com.jms.bean.Order;
import com.jms.bean.OrderItem;
import com.jms.bean.Product;
import com.jms.bean.User;
import com.jms.dao.impl.OrderItemDAOImpl;
import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class OrderItemDAOTest {
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Test
    public void getTotal() {
        System.out.println(orderItemDAO.getTotal());
    }

    @Test
    public void add() {
        OrderItem orderItem = new OrderItem();

        Product product = new Product();
        product.setId(2);

        User user = new User();
        user.setId(3);
        orderItem.setUser(user);

        orderItem.setNumber(2435425);

        orderItem.setProduct(product);

        orderItemDAO.add(orderItem);
    }

    @Test
    public void update() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(3);

        Product product = new Product();
        product.setId(2);

        orderItem.setProduct(product);

        Order order = new Order();
        order.setId(2);

        orderItem.setOrder(order);

        User user = new User();
        user.setId(3);

        orderItem.setUser(user);

        orderItem.setNumber(99999);

        orderItemDAO.update(orderItem);
    }

    @Test
    public void delete() {

        orderItemDAO.delete(3);
    }

    @Test
    public void get() {
        System.out.println(orderItemDAO.get(1));
    }

    @Test
    public void listByUser() {

        orderItemDAO.listByUser(3).forEach(System.out::println);
    }

    @Test
    public void testListByUser() {
        orderItemDAO.listByUser(3, 0, 10).forEach(System.out::println);
    }

    @Test
    public void listByOrder() {
        orderItemDAO.listByOrder(-1).forEach(System.out::println);
    }

    @Test
    public void testListByOrder() {
    }

    @Test
    public void fill() {
    }

    @Test
    public void testFill() {
    }

    @Test
    public void listByProduct() {
    }

    @Test
    public void testListByProduct() {
    }

    @Test
    public void getSaleCount() {

        System.out.println(orderItemDAO.getSaleCount(1));
    }
}