package com.example.test.presentation;

import com.example.test.application.dto.BoardCreateRequest;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @PostMapping("/board")
    public ResponseEntity createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
        return ResponseEntity.created(URI.create("/board/1")).build();
    }
}
