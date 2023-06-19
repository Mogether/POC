package com.example.documentation.docs;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.documentationConfiguration;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.restdocs.RestDocumentationContextProvider;

public class DocumentationTest {
    protected RequestSpecification spec;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentationContextProvider) {
        this.spec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(restDocumentationContextProvider))
                .build();
    }

    protected RequestSpecification given(final String identifier) {
        return RestAssured.given(this.spec)
                .accept("application/json")
                .filter(document(identifier,
                        preprocessRequest(),
                        preprocessResponse()));
    }
}
