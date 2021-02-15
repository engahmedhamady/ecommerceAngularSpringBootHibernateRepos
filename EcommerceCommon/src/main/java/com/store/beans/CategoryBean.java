package com.store.beans;
// Generated Dec 26, 2020 6:12:32 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;


public class CategoryBean  {
   

     private Integer categoryId;
     private String categoryName;
     private String description;
     private String pictureUrl;
     private Boolean active;
     private Set<ProductsBean> productses = new HashSet<ProductsBean>(0);

    public CategoryBean() {
    }

	
    public CategoryBean(String categoryName) {
        this.categoryName = categoryName;
    }
    public CategoryBean(String categoryName, String description, String pictureUrl, Boolean active, Set<ProductsBean> productses) {
       this.categoryName = categoryName;
       this.description = description;
       this.pictureUrl = pictureUrl;
       this.active = active;
       this.productses = productses;
    }
   
  

    
  
    public Integer getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    
  
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    
  
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
   
    public String getPictureUrl() {
        return this.pictureUrl;
    }
    
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    
   
    public Boolean getActive() {
        return this.active;
    }
    
    public void setActive(Boolean active) {
        this.active = active;
    }


    public Set<ProductsBean> getProductses() {
        return this.productses;
    }
    
    public void setProductses(Set<ProductsBean> productses) {
        this.productses = productses;
    }




}


