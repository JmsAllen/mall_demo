package com.jms.dao;

import com.jms.bean.Property;

import java.util.List;

public interface PropertyDAO {
    int getTotal(int cid);

    void add(Property bean);

    void update(Property bean);

    void delete(int id);

    Property get(int id);

    List<Property> list(int cid);

    List<Property> list(int cid, int start, int count);
}
