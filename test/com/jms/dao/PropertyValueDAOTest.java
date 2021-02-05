package com.jms.dao;

import com.jms.bean.Product;
import com.jms.bean.Property;
import com.jms.bean.PropertyValue;
import com.jms.dao.impl.ProductDAOImpl;
import com.jms.dao.impl.PropertyValueDAOImpl;
import org.junit.Test;

public class PropertyValueDAOTest {
    private PropertyValueDAO propertyValueDAO = new PropertyValueDAOImpl();

    @Test
    public void getTotal() {
        System.out.println(propertyValueDAO.getTotal());
    }

    @Test
    public void add() {
        PropertyValue value = new PropertyValue();

        // pid = 3
        Product product = new Product();
        product.setId(3);
        value.setProduct(product);

        Property property = new Property();
        property.setId(4);

        value.setProperty(property);


        value.setValue("超级小床");

        propertyValueDAO.add(value);
    }

    @Test
    public void update() {
        PropertyValue value = new PropertyValue();
        value.setId(9);
        Product product = new Product();
        product.setId(3);
        value.setProduct(product);

        Property property = new Property();
        property.setId(4);
        value.setProperty(property);

        value.setValue("update超级小床");

        propertyValueDAO.update(value);
    }

    @Test
    public void delete() {
        propertyValueDAO.delete(9);
    }

    @Test
    public void get() {
        System.out.println(propertyValueDAO.get(8));
    }

    @Test
    public void list() {
        propertyValueDAO.list().forEach(System.out::println);
    }

    @Test
    public void testList() {
        propertyValueDAO.list(1).forEach(System.out::println);
    }

    @Test
    public void init() {
        ProductDAO productDAO = new ProductDAOImpl();

        Product product = productDAO.get(3);

        propertyValueDAO.init(product);

        System.out.println(propertyValueDAO.getTotal());
    }

    @Test
    public void testList1() {
        propertyValueDAO.list(0, 3).forEach(System.out::println);
    }
}