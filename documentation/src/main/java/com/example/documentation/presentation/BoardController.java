package com.example.documentation.presentation;

import com.example.documentation.presentation.dto.BoardCreateRequest;
import com.example.documentation.presentation.dto.BoardCreateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @PostMapping("/board")
    public ResponseEntity create(@RequestBody BoardCreateRequest boardCreateRequest) {
        return ResponseEntity.ok()
                .body(new BoardCreateResponse(1L, boardCreateRequest.getTitle(), boardCreateRequest.getContent()));
    }
}
