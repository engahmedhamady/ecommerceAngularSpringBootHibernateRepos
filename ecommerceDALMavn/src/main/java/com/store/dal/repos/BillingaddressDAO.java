package com.store.dal.repos;

import com.store.dal.entities.Billingaddress;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
@Repository("billingaddressDAO")
public class BillingaddressDAO  extends BaseDAO implements commonDAO<Billingaddress>{

    @Override
    public Billingaddress add(Billingaddress t) {
         //To change body of generated methods, choose Tools | Templates.
          getCurrentSession().save(t);
        return t;
    }

    @Override
    public Billingaddress update(Billingaddress t) {
       
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
    public Billingaddress findById(Object id) {
        //To change body of generated methods, choose Tools | Templates.
          return getCurrentSession().get(Billingaddress.class, (int) id);
    }

    @Override
    public List<Billingaddress> findList() {
         //To change body of generated methods, choose Tools | Templates.
          Session session = getCurrentSession().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Billingaddress> adminCriteriaQuery = builder.createQuery(Billingaddress.class);
        Root<Billingaddress> from0 = adminCriteriaQuery.from(Billingaddress.class);
        adminCriteriaQuery.select(from0);
        Query<Billingaddress> adminQuery = session.createQuery(adminCriteriaQuery);
        return adminQuery.getResultList();
    }

    @Override
    public Billingaddress find(Billingaddress admin) {
  //To change body of generated methods, choose Tools | Templates.
   return getCurrentSession().find(Billingaddress.class, admin.getBillingId());
    }


    
}


