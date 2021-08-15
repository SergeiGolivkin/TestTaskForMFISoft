package com.task.multithreading.entity;

import com.task.multithreading.dto.ArticleDto;
import com.task.multithreading.util.ArticleDtoComparator;
import org.apache.tomcat.jni.Lock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {

    private static volatile Buffer instance;

    private final Map<String, List<ArticleDto>> articles;

    private Buffer() {
        articles = new ConcurrentHashMap<>();
    }

    public static Buffer getInstance(){
        if (instance == null){
            synchronized (Buffer.class){
                if (instance == null)
                    instance = new Buffer();
            }
        }
        return instance;
    }

    public void addArticle(ArticleDto articleDto){
        List<ArticleDto> list = articles.get(articleDto.getNewsSite());
        if (list == null){
            list = new CopyOnWriteArrayList<>();
        }
        list.add(articleDto);
        list.sort(new ArticleDtoComparator());
        articles.put(articleDto.getNewsSite(), list);
    }

    public void clearCurrentArticlesList(String key){
        articles.put(key, new ArrayList<>());
    }

    public Map<String, List<ArticleDto>> getArticles(){
        Map<String, List<ArticleDto>> newMap = new HashMap<>(articles);
        return newMap;
    }

}
