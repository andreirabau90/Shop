package com.company.shop.repository.impl;

import com.company.shop.entity.UserProperty;
import com.company.shop.repository.IRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class RepositoryImpl implements IRepository {

    private final
    SessionFactory sessionFactory;

    @Autowired
    public RepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Object getById(Class type, long id) {
        return sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public void saveOrUpdate(Object o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }


    @Override
    public List<Object> getAll(String str) {
        return sessionFactory.getCurrentSession().createQuery("FROM " + str).list();
    }

    @Override
    public Object getByField(Class type,String table, String field, String value) {
        return sessionFactory.getCurrentSession().createQuery(String.format("From %s  as D where D.%s = '%s' ", table, field, value)).uniqueResult();
    }
}
