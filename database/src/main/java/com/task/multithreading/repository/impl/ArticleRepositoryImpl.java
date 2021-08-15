package com.task.multithreading.repository.impl;

import com.task.multithreading.entity.Article;
import com.task.multithreading.repository.AbstractRepository;
import com.task.multithreading.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ArticleRepositoryImpl extends AbstractRepository<Article> implements ArticleRepository {

    @Autowired
    public ArticleRepositoryImpl(EntityManager entityManager) {
        super(entityManager, Article.class);
    }
}
