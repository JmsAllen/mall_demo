package com.jms.dao;

import com.jms.bean.Category;
import com.jms.bean.Product;

import java.util.List;

public interface ProductDAO {
    int getTotal(int cid);

    void add(Product bean);

    void update(Product bean);

    void delete(int id);

    Product get(int id);

    List<Product> list(int cid);

    List<Product> list(int cid, int start, int count);

    List<Product> list();

    List<Product> list(int start, int count);

    void fill(List<Category> cs);

    void fill(Category c);

    void fillByRow(List<Category> cs);

    void setFirstProductImage(Product p);

    void setSaleAndReviewNumber(Product p);

    void setSaleAndReviewNumber(List<Product> products);

    List<Product> search(String keyword, int start, int count);
}
