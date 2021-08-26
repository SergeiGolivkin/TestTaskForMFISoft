package com.task.multithreading.repository;

import com.task.multithreading.dto.ArticleDto;
import com.task.multithreading.entity.AbstractEntity;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T extends AbstractEntity> {

    T create(T entity);

    List<T> getAll(int page, int size);

    Optional<T> findById(String id);

    Optional<T> findByField(String columnName, Object value);

    T update(T entity);

    void deleteById(long id);
}
