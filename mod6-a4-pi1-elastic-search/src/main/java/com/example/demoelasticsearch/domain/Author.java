package com.example.demoelasticsearch.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class Author {

    @Id
    private String id;
    private String name;

}
