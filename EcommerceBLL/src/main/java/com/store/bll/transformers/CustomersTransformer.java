
package com.store.bll.transformers;

import com.store.beans.CustomersBean;
import com.store.beans.OrdersBean;
import com.store.dal.entities.Customers;
import com.store.dal.entities.Orders;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component(value = "customersTransformer")
public class CustomersTransformer {
     public CustomersBean transformEntityToBean(Customers entity) {
        if (entity == null) {
            return null;
        }
        CustomersBean bean = new CustomersBean();
        // transform
        bean.setCustomerId(entity.getCustomerId());
         bean.setEmail(entity.getEmail());
       
           bean.setFname(entity.getFname());
            bean.setLname(entity.getLname());
             Set<OrdersBean> set = new HashSet<>();
         for (Orders orders : entity.getOrderses()) {
             OrdersBean ordersBean =  new OrdersBean();
             ordersBean.setOrderId(orders.getOrderId());
             set.add(ordersBean);
         }
         bean.setOrderses(set);
        return bean;
    }

    public Customers transformBeanToEntity(CustomersBean bean) {
        if (bean == null) {
            return null;
        }
        Customers entity = new Customers();
         entity.setCustomerId(bean.getCustomerId());
          entity.setEmail(bean.getEmail());
      
           entity.setFname(bean.getFname());
            entity.setLname(bean.getLname());
             Set<Orders> set = new HashSet<>();
         for (OrdersBean ordersBean : bean.getOrderses()) {
             Orders orders =  new Orders();
             orders.setOrderId(ordersBean.getOrderId());
             set.add(orders);
         }
          entity.setOrderses(set);
        return entity;
    } 
}
