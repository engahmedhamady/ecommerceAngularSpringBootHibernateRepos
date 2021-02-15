/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.transformers;

import com.store.beans.BillingaddressBean;
import com.store.beans.OrdersBean;
import com.store.dal.entities.Billingaddress;
import com.store.dal.entities.Orders;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component(value = "billingaddressTransformer")
public class BillingaddressTransformer {

    public BillingaddressBean transformEntityToBean(Billingaddress entity) {
        if (entity == null) {
            return null;
        }
        BillingaddressBean bean = new BillingaddressBean();
        // transform
        bean.setBillingId(entity.getBillingId());
        bean.setCity(entity.getCity());
        bean.setCountry(entity.getCountry());
        bean.setState(entity.getState());
        bean.setStreet(entity.getStreet());
        bean.setZipCode(entity.getZipCode());
        Set<OrdersBean> set = new HashSet<>();

        for (Orders orders : entity.getOrderses()) {
            OrdersBean ordersBean = new OrdersBean();
            //   ProductsBean productsBean = productsTransformer.transformEntityToBean(product);
            ordersBean.setOrderId(orders.getOrderId());
            set.add(ordersBean);
        }
        bean.setOrderses(set);
        return bean;
    }

    public Billingaddress transformBeanToEntity(BillingaddressBean bean) {
        if (bean == null) {
            return null;
        }
        Billingaddress entity = new Billingaddress();
        // transform
        entity.setBillingId(bean.getBillingId());
        entity.setCity(bean.getCity());
        entity.setCountry(bean.getCountry());
        entity.setState(bean.getState());
        entity.setStreet(bean.getStreet());
        entity.setZipCode(bean.getZipCode());
        Set<Orders> set = new HashSet<>();

        for (OrdersBean ordersBean : bean.getOrderses()) {
            Orders orders = new Orders();
            //   ProductsBean productsBean = productsTransformer.transformEntityToBean(product);
            orders.setOrderId(ordersBean.getOrderId());
            set.add(orders);
        }
        entity.setOrderses(set);
        return entity;
    }
}
