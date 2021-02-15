
package com.store.bll.impl;
import com.store.bll.managers.OrdersManager;
import com.store.bll.transformers.OrdersTransformer;
import com.store.beans.OrdersBean;
import com.store.dal.entities.Orders;
import com.store.dal.repos.OrdersDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component(value ="ordersManagerImpl")
public class OrdersManagerImpl implements  OrdersManager{
 @Autowired(required = true)
     private OrdersDAO ordersDAO;
    @Autowired(required = true)
    private OrdersTransformer ordersTransformer;

    public OrdersDAO getOrdersDAO() {
        return ordersDAO;
    }

    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    public OrdersTransformer getOrdersTransformer() {
        return ordersTransformer;
    }

    public void setOrdersTransformer(OrdersTransformer ordersTransformer) {
        this.ordersTransformer = ordersTransformer;
    }
    
    @Transactional
    @Override
    public List<OrdersBean> listAllOrders() {
         
          List<OrdersBean> find = null;
        List<Orders> findList = ordersDAO.findList();
        if (findList != null) 
        {
            find = new ArrayList();
            for (Orders p : findList) 
            {
                System.out.println(p.getOrderId());
                find.add(ordersTransformer.transformEntityToBean(p));
            }
        }

        return find; 
    }

    @Override
    public OrdersBean findOrderById(int Id) {
  
   OrdersBean find = null;
        Orders findById = ordersDAO.findById(Id);
        if (findById != null) {

            find = ordersTransformer.transformEntityToBean(findById);
        }

        return find;
    }

    @Override
    public OrdersBean addPurchase(OrdersBean ordersBean) {
      //To change body of generated methods, choose Tools | Templates.
      if (ordersBean==null){
      return null;
      }
     Orders transformBeanToEntity = ordersTransformer.transformBeanToEntity(ordersBean);
     Orders add = ordersDAO.add(transformBeanToEntity);
        return ordersTransformer.transformEntityToBean(add);
    }
    
}
