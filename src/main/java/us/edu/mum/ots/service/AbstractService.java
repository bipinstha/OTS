package us.edu.mum.ots.service;

import java.util.List;

/**
 *
 * @author bipin
 * @param <T>
 * @param <PK>
 */
public interface AbstractService<T, PK> {

    public void add(T t);

    public void update(T t);

    public List<T> findAll();

    public T findOne(PK obj);

    public void delete(T t);

}
