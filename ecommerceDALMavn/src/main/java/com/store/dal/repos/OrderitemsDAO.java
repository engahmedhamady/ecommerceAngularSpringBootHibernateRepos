package com.store.dal.repos;


import com.store.dal.entities.Orderitems;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
@Repository("orderitemsDAO")
public class OrderitemsDAO  extends BaseDAO implements commonDAO<Orderitems> {


     @Override
    public Orderitems add(Orderitems t) {
         //To change body of generated methods, choose Tools | Templates.
          getCurrentSession().save(t);
        return t;
    }

    @Override
    public Orderitems  update(Orderitems  t) {
       
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
    public Orderitems  findById(Object id) {
        //To change body of generated methods, choose Tools | Templates.
          return getCurrentSession().get(Orderitems .class, (int) id);
    }

    @Override
    public List<Orderitems > findList() {
         //To change body of generated methods, choose Tools | Templates.
          Session session = getCurrentSession().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Orderitems > adminCriteriaQuery = builder.createQuery(Orderitems .class);
        Root<Orderitems > from0 = adminCriteriaQuery.from(Orderitems .class);
        adminCriteriaQuery.select(from0);
        Query<Orderitems > adminQuery = session.createQuery(adminCriteriaQuery);
        return adminQuery.getResultList();
    }

    @Override
    public Orderitems find(Orderitems admin) {
        //To change body of generated methods, choose Tools | Templates.
         return getCurrentSession().find(Orderitems.class, admin.getOrderItemId());
    }

}


