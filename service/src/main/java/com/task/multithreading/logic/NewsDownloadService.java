package com.task.multithreading.logic;

import com.task.multithreading.dto.ArticleDto;
import com.task.multithreading.entity.Article;
import com.task.multithreading.mapper.ArticleDtoMapper;
import com.task.multithreading.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class NewsDownloadService {

    private final ArticleRepository articleRepository;

    @Autowired
    public NewsDownloadService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    public void downloadNews(List<ArticleDto> articleDtos){
        for (ArticleDto a:articleDtos) {
            String currentUri = a.getUrl();
            WebClient webClient = WebClient.create(currentUri);
            Mono<String> response = webClient.get()
                    .retrieve()
                    .bodyToMono(String.class).log();
            String content = response.block();
            Article article = ArticleDtoMapper.mapDto(a, content);
            articleRepository.create(article);
        }
    }
}
