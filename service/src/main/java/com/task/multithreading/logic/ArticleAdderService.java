package com.task.multithreading.logic;

import com.task.multithreading.dto.ArticleDto;
import com.task.multithreading.entity.Buffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class ArticleAdderService {

    //Лимит буфера
    @Value("${buffer.limit}")
    private final int bufferLimit = 2;

    private final ReentrantLock lock = new ReentrantLock();

    private final NewsDownloadService newsDownloadService;

    @Autowired
    public ArticleAdderService(NewsDownloadService newsDownloadService) {
        this.newsDownloadService = newsDownloadService;
    }

    @Transactional
    public void addArticleToBuffer(ArticleDto articleDto){
        lock.lock();
        List<ArticleDto> list = Buffer.getInstance().getArticles().get(articleDto.getNewsSite());
        int bufferSize = 0;
        if(list != null){
            bufferSize = list.size();
        }
        if (bufferSize>= bufferLimit){
            newsDownloadService.downloadNews(Buffer.getInstance().getArticles().get(articleDto.getNewsSite()));
            Buffer.getInstance().clearCurrentArticlesList(articleDto.getNewsSite());
        }
        Buffer.getInstance().addArticle(articleDto);
        lock.unlock();
    }
}
