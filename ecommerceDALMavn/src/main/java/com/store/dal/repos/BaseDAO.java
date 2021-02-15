package com.store.dal.repos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component(value = "baseDAO")
public class BaseDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory = null;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Session getCurrentSession() {
        // return getSessionFactory().getCurrentSession();
        return getEntityManagerFactory().unwrap(SessionFactory.class).openSession();
    }

}
