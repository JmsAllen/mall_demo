package com.jms.dao;

import com.jms.bean.Category;

import java.util.List;

public interface CategoryDAO {
    int getTotal();

    void add(Category bean);

    void update(Category bean);

    void delete(int id);

    Category get(int id);

    List<Category> list(int start, int count);

    List<Category> list();
}
