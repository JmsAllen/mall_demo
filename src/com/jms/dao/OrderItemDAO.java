package com.jms.dao;

import com.jms.bean.Order;
import com.jms.bean.OrderItem;

import java.util.List;

public interface OrderItemDAO {

    int getTotal();

    void add(OrderItem bean);

    void update(OrderItem bean);

    void delete(int id);

    OrderItem get(int id);

    List<OrderItem> listByUser(int uid);

    List<OrderItem> listByUser(int uid, int start, int count);

    List<OrderItem> listByOrder(int oid);

    List<OrderItem> listByOrder(int oid, int start, int count);

    void fill(List<Order> os);

    void fill(Order o);

    List<OrderItem> listByProduct(int pid);

    List<OrderItem> listByProduct(int pid, int start, int count);

    int getSaleCount(int pid);
}
