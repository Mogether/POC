package com.example.test.acceptance;

import static com.example.test.acceptance.BoardAcceptanceSteps.게시물_생성_요청;
import static com.example.test.acceptance.BoardAcceptanceSteps.게시물_생성_요청_검증;

import com.example.test.util.AcceptanceTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class BoardAcceptanceTest extends AcceptanceTest {
    /**
     * Given : 글의 제목과 이름으로
     * When : 게시글을 작성하면
     * Then : 게시글이 생성된다.
     */
    @Test
    void 게시글_작성() {
        // Given
        String title = UUID.randomUUID().toString();
        String content = UUID.randomUUID().toString();

        // When
        ExtractableResponse<Response> response = 게시물_생성_요청(title, content);

        // Then
        게시물_생성_요청_검증(title, content, response);
    }
}
