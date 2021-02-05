package com.jms.bean;

public class ProductImage {

    private String type;
    private Product product;
    private int id;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ProductImage{");
        sb.append("type='").append(type).append('\'');
        sb.append(", product=").append(product);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}