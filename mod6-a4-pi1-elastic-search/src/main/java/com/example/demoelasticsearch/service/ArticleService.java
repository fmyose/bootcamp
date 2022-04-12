package com.example.demoelasticsearch.service;

import com.example.demoelasticsearch.domain.Article;
import com.example.demoelasticsearch.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public Article save(Article article) {
        articleRepository.save(article);
        return article;
    }

    public Article findByTitle(String title) {
        return articleRepository.findArticleByTitle(title);
    }
}

