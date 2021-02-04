package com.jms.dao.impl;

import com.jms.bean.Product;
import com.jms.bean.ProductImage;
import com.jms.dao.ProductImageDAO;
import com.jms.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductImageDAOImpl implements ProductImageDAO {

    public static final String type_single = "type_single";
    public static final String type_detail = "type_detail";

    @Override
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from tmall.ProductImage";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void add(ProductImage bean) {
        String sql = "insert into tmall.ProductImage values(null,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setInt(1, bean.getProduct().getId());
            ps.setString(2, bean.getType());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void update(ProductImage bean) {

    }

    @Override
    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from tmall.ProductImage where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public ProductImage get(int id) {
        ProductImage bean = new ProductImage();

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from tmall.ProductImage where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                int pid = rs.getInt("pid");
                String type = rs.getString("type");
                // 产品图片可以知道是什么产品
                Product product = new ProductDAOImpl().get(pid);
                bean.setProduct(product);
                bean.setType(type);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    @Override
    public List<ProductImage> list(Product p, String type) {
        return list(p, type, 0, Short.MAX_VALUE);
    }

    @Override
    public List<ProductImage> list(Product p, String type, int start, int count) {
        List<ProductImage> beans = new ArrayList<>();

        String sql = "select * from tmall.ProductImage where pid =? and type =? order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, p.getId());
            ps.setString(2, type);

            ps.setInt(3, start);
            ps.setInt(4, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                ProductImage bean = new ProductImage();
                int id = rs.getInt(1);

                bean.setProduct(p);
                bean.setType(type);
                bean.setId(id);

                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
}
