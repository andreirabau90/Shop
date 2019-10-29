package com.company.shop.repository.impl;

import com.company.shop.repository.IRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RepositoryImpl implements IRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Object getById(Class type, long id) {
        return sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public void saveOrUpdate(Object o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }
    

    @Override
    public List<Class> getAll(Class type, String str) {
        return sessionFactory.getCurrentSession().createQuery("FROM " + str).list();
    }
}
