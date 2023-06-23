package com.example.documentation.presentation;

import com.example.documentation.presentation.dto.SampleRequest;
import com.example.documentation.presentation.dto.SampleResponse;
import com.example.documentation.presentation.exception.AgeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public SampleResponse returnNameAndAge(@RequestBody SampleRequest request) {
        if (request.age() >= 100) {
            throw new AgeException();
        }
        return new SampleResponse(request.name(), request.age());
    }
}
