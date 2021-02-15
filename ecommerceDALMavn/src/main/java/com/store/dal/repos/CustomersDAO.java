package com.store.dal.repos;


import com.store.dal.entities.Customers;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;




@Repository("customersDAO")

public class CustomersDAO  extends BaseDAO implements commonDAO<Customers>{

 @Override
    public Customers add(Customers t) {
         //To change body of generated methods, choose Tools | Templates.
          getCurrentSession().save(t);
        return t;
    }

    @Override
    public Customers update(Customers t) {
       
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
    public Customers findById(Object id) {
        //To change body of generated methods, choose Tools | Templates.
          return getCurrentSession().get(Customers.class, (int) id);
    }

    @Override
    public List<Customers> findList() {
         //To change body of generated methods, choose Tools | Templates.
          Session session = getCurrentSession().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Customers> adminCriteriaQuery = builder.createQuery(Customers.class);
        Root<Customers> from0 = adminCriteriaQuery.from(Customers.class);
        adminCriteriaQuery.select(from0);
        Query<Customers> adminQuery = session.createQuery(adminCriteriaQuery);
        return adminQuery.getResultList();
    }

    @Override
    public Customers find(Customers admin) {
        //To change body of generated methods, choose Tools | Templates.
         return getCurrentSession().find(Customers.class, admin.getCustomerId());
    }
    
}


