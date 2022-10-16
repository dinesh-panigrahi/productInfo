package com.app.Product.dto;

public class ProductDto {

    private long id;
    private String productName;
    private String productTitle;

    public ProductDto() {
    }

    public ProductDto(long id, String productName, String productTitle) {
        this.id = id;
        this.productName = productName;
        this.productTitle = productTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productTitle='" + productTitle + '\'' +
                '}';
    }
}
