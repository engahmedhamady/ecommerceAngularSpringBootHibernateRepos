
package com.store.dal.repos;


import com.store.dal.entities.Category;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class CategoryDAO extends BaseDAO implements commonDAO<Category>{
    // insert 
    @Override
    public Category add(Category admin) {
        getCurrentSession().save(admin);
        return admin;

    }

    @Override
    public Category update(Category admin) {
        getCurrentSession().update(admin);
        return admin;

    }
// delete

    @Override
    public void remove(Object name) {
        getCurrentSession().delete(name);

    }
// find by name

    public Category findById(Object name) {
        return getCurrentSession().get(Category.class, (int) name);

    }

    public Category find(Category admin) {
        return getCurrentSession().find(Category.class, admin.getId());

    }

    @Override
    public List <Category> findList() {
        Session session = getCurrentSession().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Category> adminCriteriaQuery = builder.createQuery(Category.class);
        Root<Category> from0 = adminCriteriaQuery.from(Category.class);
        adminCriteriaQuery.select(from0);
        Query<Category> adminQuery = session.createQuery(adminCriteriaQuery);
        return adminQuery.getResultList();
    }

    public void patchRemove(List<Category> admins) {
        if (admins == null) {

            return;
        }
        for (Category admin : admins) {
            remove(admin.getId());
        }

    }
}
