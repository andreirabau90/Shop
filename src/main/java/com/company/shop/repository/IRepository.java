package com.company.shop.repository;


import java.util.List;

public interface IRepository<T> {
    T getById(Class<T> type, long id);

    List<T> getAll(String string);

    default void saveOrUpdate(T t) {

    }

    default void delete(T t) {

    }
    default T getByField(Class type,String table, String field, String value){
        return null;
    }


}
