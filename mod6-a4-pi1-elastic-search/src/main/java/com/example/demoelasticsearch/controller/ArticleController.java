package com.example.demoelasticsearch.controller;

import com.example.demoelasticsearch.domain.Article;
import com.example.demoelasticsearch.domain.dto.ArticleDTO;
import com.example.demoelasticsearch.service.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/article")
    public ResponseEntity<Article> save(@RequestBody ArticleDTO articleDTO) {
        System.out.println("endpoint /article");
        Article article = modelMapper.map(articleDTO, Article.class);

        articleService.save(article);

        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @GetMapping("/article")
    public ResponseEntity<Article> findByTitle(@RequestParam String title) {
        Article article = articleService.findByTitle(title);

        return ResponseEntity.ok(article);
    }

}
