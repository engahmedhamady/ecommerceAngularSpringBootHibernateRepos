package com.store.bll.transformers;

import com.store.beans.CategoryBean;
import com.store.beans.OrderitemsBean;
import com.store.beans.ProductsBean;

import com.store.dal.entities.Category;
import com.store.dal.entities.Orderitems;

import com.store.dal.entities.Products;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component(value = "productsTransformer")
public class ProductsTransformer {
 //@Autowired (required = true) 
 private CategoryTransformer categoryTransformer = new CategoryTransformer() ;
 //@Autowired (required = true) 
 //private SuppliersTransformer SuppliersTransformer1 = new SuppliersTransformer();
// @Autowired (required = true) 
// private OrderdetailsTransformer orderdetailsTransformer = new OrderdetailsTransformer();
    public ProductsBean transformEntityToBean(Products entity) {
        if (entity == null) {
            return null;
        }
        ProductsBean bean = new ProductsBean();
        // transform
        bean.setActive(entity.getActive());
        bean.setCreateDate(entity.getCreateDate());
        bean.setDescription(entity.getDescription());
     
        bean.setName(entity.getName());
        bean.setProductId(entity.getProductId());
        bean.setSku(entity.getSku());
        bean.setUnitInStock(entity.getUnitInStock());
        bean.setUnitPrice(entity.getUnitPrice());
        bean.setImageUrl(entity.getImageUrl());
   //  CategoryBean categoryBean = categoryTransformer.transformEntityToBean(entity.getCategory());
        CategoryBean categoryBean = new CategoryBean();
        categoryBean.setCategoryId(entity.getCategory().getId());
//       
   bean.setCategory(categoryBean);
        
       Set<OrderitemsBean> set = new HashSet<>();

        for (Orderitems orderitems : entity.getOrderitemses()) {
            OrderitemsBean orderitemsBean = new OrderitemsBean();
         //   ProductsBean productsBean = productsTransformer.transformEntityToBean(product);
           orderitemsBean.setOrderItemId(orderitems.getOrderItemId());
            set.add(orderitemsBean);
        }
        bean.setOrderitemses(set);
      
        return bean;
    }

    public Products transformBeanToEntity(ProductsBean bean) {
        if (bean == null) {
            return null;
        }
        Products entity = new Products();
        // transform
        entity.setActive(bean.getActive());
        entity.setCreateDate(bean.getCreateDate());
        entity.setDescription(bean.getDescription());
       
        entity.setName(bean.getName());
        entity.setProductId(bean.getProductId());
        entity.setSku(bean.getSku());
        entity.setUnitInStock(bean.getUnitInStock());
    
           entity.setUnitPrice(bean.getUnitPrice());
      entity.setImageUrl(bean.getImageUrl());
       

   //  Category category = categoryTransformer.transformBeanToEntity(bean.getCategory());
      
        Category category = new Category();
        category.setId(bean.getCategory().getCategoryId());
        entity.setCategory(category);
         Set<Orderitems> set = new HashSet<>();

        for (OrderitemsBean orderitemsBean : bean.getOrderitemses()) {
            Orderitems orderitems= new Orderitems();
         //   ProductsBean productsBean = productsTransformer.transformEntityToBean(product);
           orderitems.setOrderItemId(orderitemsBean.getOrderItemId());
            set.add(orderitems);
        }
       entity.setOrderitemses(set);
       
        return entity;
    }

//    public CategoryTransformer getCategoryTransformer() {
//        return CategoryTransformer1;
//    }
//
//    public void setCategoryTransformer(CategoryTransformer CategoryTransformer) {
//        this.CategoryTransformer1 = CategoryTransformer;
//    }
//
//    public SuppliersTransformer getSuppliersTransformer() {
//        return SuppliersTransformer1;
//    }
//
//    public void setSuppliersTransformer(SuppliersTransformer SuppliersTransformer) {
//        this.SuppliersTransformer1 = SuppliersTransformer;
//    }
//
//    public OrderdetailsTransformer getOrderdetailsTransformer() {
//        return orderdetailsTransformer;
//    }
//
//    public void setProductsTransformer(OrderdetailsTransformer orderdetailsTransformer) {
//        this.orderdetailsTransformer = orderdetailsTransformer;
//    }
}
