package com.store.dal.repos;


import com.store.dal.entities.Shipperaddress;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
@Repository("shipperaddressDAO")
public class ShipperaddressDAO extends BaseDAO implements commonDAO<Shipperaddress> {


     @Override
    public Shipperaddress add(Shipperaddress t) {
         //To change body of generated methods, choose Tools | Templates.
          getCurrentSession().save(t);
        return t;
    }

    @Override
    public Shipperaddress update(Shipperaddress t) {
       
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
    public Shipperaddress findById(Object id) {
        //To change body of generated methods, choose Tools | Templates.
          return getCurrentSession().get(Shipperaddress.class, (int) id);
    }

    @Override
    public List<Shipperaddress> findList() {
         //To change body of generated methods, choose Tools | Templates.
          Session session = getCurrentSession().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Shipperaddress> adminCriteriaQuery = builder.createQuery(Shipperaddress.class);
        Root<Shipperaddress> from0 = adminCriteriaQuery.from(Shipperaddress.class);
        adminCriteriaQuery.select(from0);
        Query<Shipperaddress> adminQuery = session.createQuery(adminCriteriaQuery);
        return adminQuery.getResultList();
    }

    @Override
    public Shipperaddress find(Shipperaddress admin) {
        //To change body of generated methods, choose Tools | Templates.
         return getCurrentSession().find(Shipperaddress.class, admin.getShipperId());
    }


}


