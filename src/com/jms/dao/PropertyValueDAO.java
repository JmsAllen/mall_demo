package com.jms.dao;

import com.jms.bean.Product;
import com.jms.bean.PropertyValue;

import java.util.List;

public interface PropertyValueDAO {
    int getTotal();

    void add(PropertyValue bean);

    void update(PropertyValue bean);

    void delete(int id);

    PropertyValue get(int id);

    PropertyValue get(int ptid, int pid);

    List<PropertyValue> list();

    List<PropertyValue> list(int start, int count);

    void init(Product p);

    List<PropertyValue> list(int pid);
}
