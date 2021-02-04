package com.jms.dao;

import com.jms.bean.Product;
import com.jms.bean.ProductImage;

import java.util.List;

public interface ProductImageDAO {
    int getTotal();

    void add(ProductImage bean);

    void update(ProductImage bean);

    void delete(int id);

    ProductImage get(int id);

    List<ProductImage> list(Product p, String type);

    List<ProductImage> list(Product p, String type, int start, int count);
}
