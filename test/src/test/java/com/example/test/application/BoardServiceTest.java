package com.example.test.application;

import com.example.test.application.dto.BoardCreateRequest;
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
        Assertions.assertThat(id).isEqualTo(1L);
    }
}
