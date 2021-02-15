
package com.store.dal.repos;



import com.store.dal.entities.Country;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("countryDAO")
public class CountryDAO extends BaseDAO implements commonDAO<Country>{
    // insert 
    @Override
    public Country add(Country admin) {
        getCurrentSession().save(admin);
        return admin;

    }

    @Override
    public Country update(Country admin) {
        getCurrentSession().update(admin);
        return admin;

    }
// delete

    @Override
    public void remove(Object name) {
        getCurrentSession().delete(name);

    }
// find by name

    public Country findById(Object name) {
        return getCurrentSession().get(Country.class, (int) name);

    }

    public Country find(Country admin) {
        return getCurrentSession().find(Country.class, admin.getId());

    }

    @Override
    public List <Country> findList() {
        Session session = getCurrentSession().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Country> adminCriteriaQuery = builder.createQuery(Country.class);
        Root<Country> from0 = adminCriteriaQuery.from(Country.class);
        adminCriteriaQuery.select(from0);
        Query<Country> adminQuery = session.createQuery(adminCriteriaQuery);
        return adminQuery.getResultList();
    }

    public void patchRemove(List<Country> admins) {
        if (admins == null) {

            return;
        }
        for (Country admin : admins) {
            remove(admin.getId());
        }

    }
}
