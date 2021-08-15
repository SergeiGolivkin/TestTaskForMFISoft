package com.task.multithreading.mapper;

import com.task.multithreading.dto.ArticleDto;
import com.task.multithreading.entity.Article;

public class ArticleDtoMapper {

    public static Article mapDto(ArticleDto articleDto, String content){
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setTitle(articleDto.getTitle());
        article.setNewsSite(articleDto.getNewsSite());
        article.setPublishedDate(articleDto.getPublishedAt());
        article.setArticle(content);
        return article;
    }
}
