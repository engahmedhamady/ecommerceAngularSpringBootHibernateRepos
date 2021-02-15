package com.store.beans;
// Generated Dec 26, 2020 6:12:32 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ProductsBean  {
   private Integer productId;
     private CategoryBean category;
     private String sku;
     private String name;
     private String description;
     private Integer unitPrice;
     private Boolean active;
     private Integer unitInStock;
     private Date createDate;
     private String imageUrl;
 private Set<OrderitemsBean> orderitemses = new HashSet<OrderitemsBean>(0);
 
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
     

    public ProductsBean(Integer productId, CategoryBean category, String sku, String name, String description, Integer unitPrice, Boolean active, Integer unitInStock, Date createDate,String imageUrl) {
        this.productId = productId;
        this.category = category;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.active = active;
        this.unitInStock = unitInStock;
        this.createDate = createDate;
        this.imageUrl=imageUrl;
    }

    public ProductsBean(Integer productId) {
        this.productId = productId;
    }

     
    public ProductsBean() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<OrderitemsBean> getOrderitemses() {
        return orderitemses;
    }

    public void setOrderitemses(Set<OrderitemsBean> orderitemses) {
        this.orderitemses = orderitemses;
    }

	
 
   

   
  





}


