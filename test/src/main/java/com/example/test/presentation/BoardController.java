package com.example.test.presentation;

import com.example.test.application.BoardService;
import com.example.test.application.dto.BoardCreateRequest;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity createBoard(@RequestBody BoardCreateRequest boardCreateRequest) {
        long id = boardService.create(boardCreateRequest);
        return ResponseEntity.created(URI.create("/board/" + id)).build();
    }

    @GetMapping("/board/{id}")
    public ResponseEntity findBoardById(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
