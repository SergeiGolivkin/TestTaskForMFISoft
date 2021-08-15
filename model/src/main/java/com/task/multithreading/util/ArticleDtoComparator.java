package com.task.multithreading.util;

import com.task.multithreading.dto.ArticleDto;

import java.util.Comparator;

public class ArticleDtoComparator implements Comparator<ArticleDto> {

    @Override
    public int compare(ArticleDto o1, ArticleDto o2) {
        return o1.getPublishedAt().compareTo(o2.getPublishedAt());
    }
}
