package com.jms.dao;

import com.jms.bean.User;
import com.jms.dao.impl.UserDAOImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOTest {
    private UserDAO userDAO = new UserDAOImpl();


    @Test
    public void get() {
        System.out.println(userDAO.get("jms", "1234"));
    }

    @Test
    public void isExist() {
        System.out.println(userDAO.isExist("jm1s"));
    }

    @Test
    public void testGetTotal() {
        System.out.println(userDAO.getTotal());
    }

    @Test
    public void add() {
        User user = new User();
        user.setName("insert");
        user.setPassword("123");
        userDAO.add(user);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setName("update");
        userDAO.update(user);
    }

    @Test
    public void delete() {
        userDAO.delete(1);
    }

    @Test
    public void list() {
        userDAO.list().forEach(System.out::println);
    }

    @Test
    public void testList() {
        userDAO.list(0, 2).forEach(System.out::println);
    }
}