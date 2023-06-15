package com.example.test.acceptance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class BoardAcceptanceSteps {
    protected static void 게시물_생성_요청_검증(final String title, final String content,
                                       final ExtractableResponse<Response> response) {
        String location = response.headers().get(HttpHeaders.LOCATION).getValue();

        var createBoardJsonPath = RestAssured.given().log().all()
                .get(location)
                .then().log().all()
                .extract()
                .jsonPath();

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value()),
                () -> assertThat(location).isEqualTo("/board/1"),
                () -> assertThat(createBoardJsonPath.getLong("id")).isEqualTo(1L),
                () -> assertThat(createBoardJsonPath.getString("title")).isEqualTo(title),
                () -> assertThat(createBoardJsonPath.getString("content")).isEqualTo(content)
        );
    }

    protected static ExtractableResponse<Response> 게시물_생성_요청(final String title, String content) {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(Map.of(
                        "title", title,
                        "content", content
                ))
                .post("/board")
                .then().log().all()
                .extract();
    }
}
