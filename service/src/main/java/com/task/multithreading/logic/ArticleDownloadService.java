package com.task.multithreading.logic;

import com.task.multithreading.dto.ArticleDto;
import com.task.multithreading.dto.ArticleRequestDto;
import com.task.multithreading.entity.BlackList;
import com.task.multithreading.entity.Buffer;
import com.task.multithreading.mapper.ArticleRequestDtoMapper;
import com.task.multithreading.util.ThreadCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ArticleDownloadService {

    private static final String URI = "https://spaceflightnewsapi.net/api/v2/articles";
    private static final String LIMIT = "_limit=";
    private static final String START = "_start=";

    private final ArticleRequestDtoMapper articleRequestDtoMapper;
    private final ArticleAdderService articleAdderService;

    @Autowired
    public ArticleDownloadService(ArticleRequestDtoMapper articleRequestDtoMapper,
                                  ArticleAdderService articleAdderService) {
        this.articleRequestDtoMapper = articleRequestDtoMapper;
        this.articleAdderService = articleAdderService;
    }

    @Async("taskExecutor")
    public void downloadArticles(int limit, int start, ArticleAdderService articleAdderService) throws Exception {
        long time1 = System.currentTimeMillis();
        String currentUri = URI + "?" + LIMIT + limit + "&" + START + start;
        WebClient webClient = WebClient.create(currentUri);
        Mono<ArticleRequestDto[]> response = webClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ArticleRequestDto[].class).log();
        ArticleRequestDto[] objects = response.block();
        for (String word : BlackList.getInstance().getBlackList()) {
            for (ArticleRequestDto articleRequestDto : objects) {
                if (!articleRequestDto.getTitle().contains(word)) {
                    ArticleDto articleDto = articleRequestDtoMapper.mapToDto(articleRequestDto);
                    articleAdderService.addArticleToBuffer(articleDto);
                }
            }
        }
        ThreadCounter.getInstance().incrementActualCount();
        long time2 = System.currentTimeMillis();
        System.out.println("Start " + time1 + " Finish " + time2);
    }

}
