package com.umc.gwnu.test.presentation;

import com.umc.gwnu.global.apipayload.CommonResponse;
import com.umc.gwnu.test.application.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {

    @GetMapping("/test")
    public CommonResponse<TestDto.Testing> test() throws Exception {
        return null;
    }

    @GetMapping("/exception")
    public CommonResponse<TestDto.Exception> exception(@RequestParam Long flag) {
        return null;
    }
}
