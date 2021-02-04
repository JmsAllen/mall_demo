package com.jms.dao;

import com.jms.bean.Category;
import com.jms.bean.Property;
import com.jms.dao.impl.PropertyDAOImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyDAOTest {
    private PropertyDAO propertyDAO = new PropertyDAOImpl();

    @Test
    public void getTotal() {
        // 测试用例中 1 表示 男装 分类
        //          2 表示 女装 分类
        System.out.println(propertyDAO.getTotal(1)); // 2
        System.out.println(propertyDAO.getTotal(2)); // 1
    }

    @Test
    public void add() {
        Property property = new Property();
        property.setName("风格");

        Category category = new Category();
        category.setName("男装");
        category.setId(1);
        property.setCategory(category);

        propertyDAO.add(property);
    }

    @Test
    public void update() {
        Property property = new Property();
        property.setId(3);
        property.setName("风格");
        Category category = new Category();
        category.setId(2);
        property.setCategory(category);
        propertyDAO.update(property);
    }

    @Test
    public void delete() {
        propertyDAO.delete(6);
    }

    @Test
    public void get() {
        System.out.println(propertyDAO.get(1));
    }

    @Test
    public void list() {
        propertyDAO.list(2).forEach(System.out::println);
    }

    @Test
    public void testList() {
        propertyDAO.list(1, 0, 2).forEach(System.out::println);
    }
}