package com.jms.dao;

import com.jms.bean.Order;

import java.util.List;

public interface OrderDAO {
    int getTotal();

    void add(Order bean);

    void update(Order bean);

    void delete(int id);

    Order get(int id);

    List<Order> list();

    List<Order> list(int start, int count);

    List<Order> list(int uid,String excludedStatus);

    List<Order> list(int uid, String excludedStatus, int start, int count);
}
