package com.task.multithreading.logic.impl;

import com.task.multithreading.dto.ArticleDto;
import com.task.multithreading.entity.Article;
import com.task.multithreading.entity.Buffer;
import com.task.multithreading.logic.ArticleAdderService;
import com.task.multithreading.logic.ArticleService;
import com.task.multithreading.logic.ArticleDownloadService;
import com.task.multithreading.mapper.ArticleDtoMapper;
import com.task.multithreading.repository.ArticleRepository;
import com.task.multithreading.util.ThreadCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDownloadService articleDownloadService;
    private final ArticleAdderService articleAdderService;
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleDownloadService articleDownloadService, ArticleAdderService articleAdderService, ArticleRepository articleRepository) {
        this.articleDownloadService = articleDownloadService;
        this.articleAdderService = articleAdderService;
        this.articleRepository = articleRepository;
    }

    @Override
    public Map<String, List<ArticleDto>> downloadArticles(int threadCount, int eachThreadNewsCount) throws Exception {
        int index = 0;
        int start = 0;
        while(index < threadCount){
            articleDownloadService.downloadArticles(eachThreadNewsCount, start, articleAdderService);
            start+= eachThreadNewsCount;
            index ++;
        }
        while (threadCount != (ThreadCounter.getInstance().getActualCount().get())) {
        }
        return Buffer.getInstance().getArticles();
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.getAll(1,10);

    }
}
