package com.jms.dao;

import com.jms.bean.User;

import java.util.List;

public interface UserDAO {
    User get(String name);

    User get(int id);

    boolean isExist(String name);

    User get(String name, String password);

    int getTotal();

    void add(User bean);

    void update(User bean);

    void delete(int id);

    List<User> list();

    List<User> list(int start, int count);
}
