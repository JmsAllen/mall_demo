package com.jms.bean;

import java.util.Date;

public class Review {
    private String content;
    private Date createDate;
    private User user;
    private Product product;
    private int id;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Review{");
        sb.append("content='").append(content).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", user=").append(user);
        sb.append(", product=").append(product);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    public Review() {
    }

    public Review(String content, Date createDate, User user, Product product, int id) {
        this.content = content;
        this.createDate = createDate;
        this.user = user;
        this.product = product;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}