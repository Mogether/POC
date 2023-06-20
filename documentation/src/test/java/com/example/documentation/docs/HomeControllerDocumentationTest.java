package com.example.documentation.docs;

import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document;

import com.example.documentation.presentation.dto.BoardCreateRequest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

class HomeControllerDocumentationTest extends DocumentationTest {

    @Test
    void home() {
        given("home")
                .when()
                .get("/home")
                .then().log().all();
    }

    @Test
    void createHome() {
        given("게시글 생성")
                .filter(document("게시글 생성", preprocessRequest(), preprocessResponse(), responseFields(
                        fieldWithPath("id").description("게시글 아이디"),
                        fieldWithPath("title").description("게시글 제목"),
                        fieldWithPath("content").description("게시글 내용")
                )))
                .body(new BoardCreateRequest("이것은 제목입니다.", "이것은 내용입니다."))
                .contentType(ContentType.JSON)
                .when()
                .post("/board")
                .then().log().all()
                .assertThat()
                .statusCode(is(200));
    }
}
