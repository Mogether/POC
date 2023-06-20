package com.example.documentation.presentation.dto;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class BoardCreateResponse {

    private long id;
    private String title;
    private String content;

    public BoardCreateResponse(final long id, final String title, final String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
