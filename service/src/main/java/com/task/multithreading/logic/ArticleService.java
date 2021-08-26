package com.task.multithreading.logic;

import com.task.multithreading.dto.ArticleDto;
import com.task.multithreading.entity.Article;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    Map<String, List<ArticleDto>> downloadArticles(int count, int eachThreadNewsCount) throws Exception;

    List<Article> getAllArticles ();



}
