package com.example.documentation.presentation.dto;

import lombok.Getter;

@Getter
public class BoardCreateRequest {

    private String title;
    private String content;

    public BoardCreateRequest(final String title, final String content) {
        this.title = title;
        this.content = content;
    }
}
