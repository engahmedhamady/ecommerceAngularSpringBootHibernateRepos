package com.store.dal.repos;


import com.store.dal.entities.Country;
import com.store.dal.entities.State;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("stateDAO")
public class StateDAO extends BaseDAO implements commonDAO<State> {

    // insert 
    @Override
    public State add(State admin) {
        getCurrentSession().save(admin);
        return admin;

    }

    @Override
    public State update(State admin) {
        getCurrentSession().update(admin);
        return admin;

    }
// delete

    @Override
    public void remove(Object name) {
        getCurrentSession().delete(name);

    }
// find by name

    @Override
    public State findById(Object Id) {
        return getCurrentSession().get(State.class, (int) Id);

    }

    public State find(State admin) {
        return getCurrentSession().find(State.class, admin.getId());

    }

    @Override
    public List<State> findList() {
        Session session = getCurrentSession().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<State> adminCriteriaQuery = builder.createQuery(State.class);
        Root<State> from0 = adminCriteriaQuery.from(State.class);
        adminCriteriaQuery.select(from0);
        Query<State> adminQuery = session.createQuery(adminCriteriaQuery);
        return adminQuery.getResultList();
    }

    public List<State> findListStateByCountryId(Integer CountryID) {

        Session session = getCurrentSession().getSession();
        List<State> list = null;

        String querySql = "SELECT * FROM `state` WHERE  country_id =?";
        Query query = session.createNativeQuery(querySql)
                .addScalar("id")
                .addScalar("name")
               .addScalar("country_id")
                ;
        
        query.setParameter(1, CountryID);
        // List list1 = query.list();
        List<Object[]> list1 = query.list();
        if (list1.size() > 0) {
            list = new ArrayList<>();
            for (Object[] p : list1) {
                State d = new State();  
                 d.setId((Integer) p[0]);
                d.setName((String) p[1]);
                Country c= new Country();
                c.setId((Integer) p[2]);
                 d.setCountry(c);
                
              list.add(d);
            }
            return list;
        } else {
            return null;
        }
      
    }

      public List<State> findListByContainingName(String name) {

        Session session = getCurrentSession().getSession();
        List<State> list = null;

      //  String querySql = "SELECT * FROM `products` WHERE  name LIKE '%?%'";
       String querySql = "SELECT * FROM `state` WHERE  name LIKE '%"+name+"%'";
        Query query = session.createNativeQuery(querySql).setMaxResults(3).setFirstResult(0)
                .addScalar("id")
                
                .addScalar("name")
                .addScalar("country_id");
       // query.setParameter(1, name);
   
        List<Object[]> list1 = query.list();
        if (list1.size() > 0) {
            list = new ArrayList<>();
            for (Object[] p : list1) {
                State d = new State();
                d.setId((int) p[0]);
                Country category = new Country();
                category.setId((Integer) p[2]);
                d.setCountry(category);
                
                d.setName((String) p[1]);
                
              list.add(d);

            }
            return list;
        } else {
            return null;
        }
      
    }

    public void patchRemove(List<State> admins) {
        if (admins == null) {

            return;
        }
        for (State admin : admins) {
            remove(admin.getId());
        }

    }
}
