package com.example.demoelasticsearch.domain.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ArticleDTO {
    private String title;
    private AuthorDTO author;
}
