package com.jms.dao;

import com.jms.bean.Category;
import com.jms.dao.impl.CategoryDAOImpl;
import org.junit.Test;

public class CategoryDAOTest {
    private CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Test
    public void getTotal() {
        System.out.println(categoryDAO.getTotal());
    }

    @Test
    public void add() {
        Category category = new Category();
        category.setName("haha3");
        categoryDAO.add(category);
    }

    @Test
    public void update() {
        Category category = new Category();
        category.setName("hahaha");
        category.setId(4);

        categoryDAO.update(category);

    }

    @Test
    public void delete() {
        categoryDAO.delete(3);
    }

    @Test
    public void get() {
        System.out.println(categoryDAO.get(1));
    }

    @Test
    public void list() {
        categoryDAO.list(0, 3).forEach(System.out::println);
    }
}