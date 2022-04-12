package com.example.demoelasticsearch.repository;

import com.example.demoelasticsearch.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
    Article findArticleByTitle(String title);
}
