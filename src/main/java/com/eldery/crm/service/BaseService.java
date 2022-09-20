package com.eldery.crm.service;

import com.eldery.crm.model.BaseEntity;

import java.util.Collection;

public abstract class BaseService {

    public abstract <T> void save(T entity);

    public abstract <E> void save(Collection<E> entityCollection);
}
