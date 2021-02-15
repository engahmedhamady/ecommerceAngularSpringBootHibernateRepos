/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.transformers;

import com.store.beans.CountryBean;
import com.store.beans.OrderitemsBean;
import com.store.beans.OrdersBean;
import com.store.beans.ProductsBean;
import com.store.dal.entities.Orderitems;
import com.store.dal.entities.Orders;
import com.store.dal.entities.Products;
import org.springframework.stereotype.Component;

@Component(value = "orderitemsTransformer")
public class OrderitemsTransformer {
     public OrderitemsBean transformEntityToBean(Orderitems entity) {
        if (entity == null) {
            return null;
        }
        OrderitemsBean bean = new OrderitemsBean();
        // transform
         bean.setOrderItemId(entity.getOrderItemId());
        bean.setQuantity(entity.getQuantity());
        bean.setUnitPrice(entity.getUnitPrice());
        bean.setImageUrl(entity.getImageUrl());
        ProductsBean productsBean = new ProductsBean();
        productsBean.setProductId(entity.getProducts().getProductId());
        bean.setProducts(productsBean);
        OrdersBean ordersBean = new OrdersBean();
        ordersBean.setOrderId(entity.getOrders().getOrderId());
        bean.setOrders(ordersBean);
        return bean;
    }

    public Orderitems transformBeanToEntity(OrderitemsBean bean) {
        if (bean == null) {
            return null;
        }
       Orderitems entity = new Orderitems();
        entity.setOrderItemId(bean.getOrderItemId());
        entity.setQuantity(bean.getQuantity());
        entity.setUnitPrice(bean.getUnitPrice());
        entity.setImageUrl(bean.getImageUrl());
        Products products = new Products();
        products.setProductId(bean.getProducts().getProductId());
        entity.setProducts(products);
        Orders orders = new Orders();
        orders.setOrderId(bean.getOrders().getOrderId());
        entity.setOrders(orders);
        return entity;
    } 
     
   
}
