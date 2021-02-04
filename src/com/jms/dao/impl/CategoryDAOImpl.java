package com.jms.dao.impl;

import com.jms.bean.Category;
import com.jms.dao.CategoryDAO;
import com.jms.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public int getTotal() {
        String sql = "select count(*) from tmall.category";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void add(Category bean) {
        String sql = "insert into tmall.category values (null, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            statement.setString(1, bean.getName());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category bean) {
        String sql = "update tmall.category set name = ? where id = ?";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, bean.getName());
            statement.setInt(2, bean.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from tmall.category where id = " + id;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category get(int id) {
        String sql = "select * from tmall.category where id = " + id;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Category category = new Category();
                String name = resultSet.getString(2);

                category.setName(name);
                category.setId(id);
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> list(int start, int count) {
        String sql = "select * from tmall.category order by id desc limit ?,?";
        ArrayList<Category> categories = new ArrayList<>();

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, start);
            statement.setInt(2, count);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Category category = new Category();
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                category.setName(name);
                category.setId(id);

                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Category> list() {
        return list(0, Short.MAX_VALUE);
    }
}