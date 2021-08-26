package com.task.multithreading.controller;

import com.task.multithreading.dto.ArticleDto;
import com.task.multithreading.entity.Article;
import com.task.multithreading.entity.BlackList;
import com.task.multithreading.logic.ArticleService;
import com.task.multithreading.logic.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    private final ArticleService articleService;
    private final ArticleServiceImpl articleServiceImpl;

    @Autowired
    public ArticlesController(ArticleService articleService, ArticleServiceImpl articleServiceImpl) {
        this.articleService = articleService;
        this.articleServiceImpl = articleServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, List<ArticleDto>> getNews() throws Exception {
        BlackList.getInstance().addWord("Word");
        return articleService.downloadArticles(5, 5);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Article> getAllNews() {
        return articleServiceImpl.getAllArticles();
    }
}

