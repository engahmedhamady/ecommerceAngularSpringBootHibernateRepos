package com.store.dal.repos;

import com.store.dal.entities.Orders;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
@Repository("ordersDAO")
public class OrdersDAO extends BaseDAO implements commonDAO<Orders> {

 @Override
    public Orders add(Orders t) {
         //To change body of generated methods, choose Tools | Templates.
          getCurrentSession().save(t);
        return t;
    }
 public List <Orders> addList(List<Orders> t) {
         //To change body of generated methods, choose Tools | Templates.
         if (t==null)
         {
             return null;
         }
         for (Orders orders : t) {
             
              getCurrentSession().persist(orders); 
          }
         
        return t;
    }
    @Override
    public Orders update(Orders t) {
       
        //To change body of generated methods, choose Tools | Templates.\
         getCurrentSession().update(t);
        return t;
    }

    @Override
    public void remove(Object id) {
       //To change body of generated methods, choose Tools | Templates.
         getCurrentSession().delete(id);
    }

    @Override
    public Orders findById(Object id) {
        //To change body of generated methods, choose Tools | Templates.
          return getCurrentSession().get(Orders.class, (int) id);
    }

    @Override
    public List<Orders> findList() {
         //To change body of generated methods, choose Tools | Templates.
          Session session = getCurrentSession().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Orders> adminCriteriaQuery = builder.createQuery(Orders.class);
        Root<Orders> from0 = adminCriteriaQuery.from(Orders.class);
        adminCriteriaQuery.select(from0);
        Query<Orders> adminQuery = session.createQuery(adminCriteriaQuery);
        return adminQuery.getResultList();
    }

    @Override
    public Orders find(Orders admin) {
         //To change body of generated methods, choose Tools | Templates.
          return getCurrentSession().find(Orders.class, admin.getOrderId());
    }
    }


