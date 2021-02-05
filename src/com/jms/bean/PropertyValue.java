package com.jms.bean;

public class PropertyValue {
    private String value;
    private Product product;
    private Property property;
    private int id;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PropertyValue{");
        sb.append("value='").append(value).append('\'');
        sb.append(", product=").append(product);
        sb.append(", property=").append(property);
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

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Property getProperty() {
        return property;
    }
    public void setProperty(Property property) {
        this.property = property;
    }
}