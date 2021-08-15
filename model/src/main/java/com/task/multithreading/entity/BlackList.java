package com.task.multithreading.entity;

import java.util.ArrayList;
import java.util.List;

public class BlackList {

    private static volatile BlackList instance;

    private final List<String> blackList;

    private BlackList(){
        blackList = new ArrayList<>();
    }

    public static BlackList getInstance(){
        if (instance == null){
            synchronized (BlackList.class){
                if (instance == null)
                    instance = new BlackList();
            }
        }
        return instance;
    }

    public void addWord(String word){
        blackList.add(word);
    }

    public List<String> getBlackList(){
        return new ArrayList<>(blackList);
    }

}
