package com.jms.dao.impl;

import com.jms.bean.Product;
import com.jms.bean.Property;
import com.jms.bean.PropertyValue;
import com.jms.dao.PropertyValueDAO;
import com.jms.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class PropertyValueDAOImpl implements PropertyValueDAO {

    @Override
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from tmall.PropertyValue";

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
    public void add(PropertyValue bean) {
        String sql = "insert into tmall.PropertyValue values(null,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setInt(1, bean.getProduct().getId());
            ps.setInt(2, bean.getProperty().getId());
            ps.setString(3, bean.getValue());
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
    public void update(PropertyValue bean) {

        String sql = "update tmall.PropertyValue set pid= ?, ptid=?, value=?  where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, bean.getProduct().getId());
            ps.setInt(2, bean.getProperty().getId());
            ps.setString(3, bean.getValue());
            ps.setInt(4, bean.getId());
            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from tmall.PropertyValue where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public PropertyValue get(int id) {
        PropertyValue bean = new PropertyValue();

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from tmall.PropertyValue where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                int pid = rs.getInt("pid");
                int ptid = rs.getInt("ptid");
                String value = rs.getString("value");

                Product product = new ProductDAOImpl().get(pid);
                Property property = new PropertyDAOImpl().get(ptid);
                bean.setProduct(product);
                bean.setProperty(property);
                bean.setValue(value);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    @Override
    public PropertyValue get(int ptid, int pid) {
        PropertyValue bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from tmall.PropertyValue where ptid = " + ptid + " and pid = " + pid;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new PropertyValue();
                int id = rs.getInt("id");

                String value = rs.getString("value");

                // ******** 属性值 可以反映 属性 和对应的 产品 **************
                Product product = new ProductDAOImpl().get(pid);
                Property property = new PropertyDAOImpl().get(ptid);
                // *******------------------------------********

                bean.setProduct(product);
                bean.setProperty(property);
                bean.setValue(value);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    @Override
    public List<PropertyValue> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<PropertyValue> list(int start, int count) {
        List<PropertyValue> beans = new ArrayList<>();

        String sql = "select * from tmall.PropertyValue order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PropertyValue bean = new PropertyValue();
                int id = rs.getInt(1);

                int pid = rs.getInt("pid");
                int ptid = rs.getInt("ptid");
                String value = rs.getString("value");

                Product product = new ProductDAOImpl().get(pid);
                Property property = new PropertyDAOImpl().get(ptid);
                bean.setProduct(product);
                bean.setProperty(property);
                bean.setValue(value);
                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

    /**
     * 传入一个产品，得到该产品所有的 property ，然后初始化每一个 property 的
     * propertyValue ， 如果某个 property 还没有 propertyValue ，
     * 则创建一个实例
     * @param p
     */
    @Override
    public void init(Product p) {
        List<Property> pts = new PropertyDAOImpl().list(p.getCategory().getId());

        for (Property pt : pts) {
            PropertyValue pv = get(pt.getId(), p.getId());
            if (null == pv) {
                pv = new PropertyValue();
                pv.setProduct(p);
                pv.setProperty(pt);
                this.add(pv);
            }
        }
    }

    @Override
    public List<PropertyValue> list(int pid) {
        List<PropertyValue> beans = new ArrayList<>();

        String sql = "select * from tmall.PropertyValue where pid = ? order by ptid desc";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, pid);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PropertyValue bean = new PropertyValue();
                int id = rs.getInt(1);

                int ptid = rs.getInt("ptid");
                String value = rs.getString("value");

                Product product = new ProductDAOImpl().get(pid);
                Property property = new PropertyDAOImpl().get(ptid);
                bean.setProduct(product);
                bean.setProperty(property);
                bean.setValue(value);
                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
}
