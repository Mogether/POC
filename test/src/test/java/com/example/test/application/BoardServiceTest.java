package com.example.test.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.test.application.dto.BoardCreateRequest;
import com.example.test.domain.Board;
import com.example.test.domain.BoardRepository;
import com.example.test.util.DatabaseCleanup;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class BoardServiceTest {
    @Autowired
    private DatabaseCleanup databaseCleanup;
    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        databaseCleanup.execute();
    }

    @Test
    void 게시물_작성() {
        // given
        String title = UUID.randomUUID().toString();
        String content = UUID.randomUUID().toString();
        BoardCreateRequest boardCreateRequest = new BoardCreateRequest(
                title,
                content
        );

        // when
        long id = boardService.create(boardCreateRequest);

        // then
        assertThat(id).isEqualTo(1L);
    }

    @Test
    void 게시물_ID로_조회() {
        // given
        String title = UUID.randomUUID().toString();
        String content = UUID.randomUUID().toString();
        Board board = new Board(
                title,
                content
        );
        Board saveBoard = boardRepository.save(board);

        // when
        BoardResponse boardResponse = boardService.findById(saveBoard.getId());

        // then
        assertAll(
                () -> assertThat(boardResponse.getId()).isEqualTo(1L),
                () -> assertThat(boardResponse.getTitle()).isEqualTo(title),
                () -> assertThat(boardResponse.getContent()).isEqualTo(content)
        );
    }
}
