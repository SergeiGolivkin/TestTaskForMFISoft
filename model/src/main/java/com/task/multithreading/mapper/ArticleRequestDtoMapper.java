package com.task.multithreading.mapper;

import com.task.multithreading.dto.ArticleDto;
import com.task.multithreading.dto.ArticleRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleRequestDtoMapper extends BaseMapper<ArticleDto, ArticleRequestDto> {
}
