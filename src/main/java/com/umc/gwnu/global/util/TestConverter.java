package com.umc.gwnu.global.util;

import com.umc.gwnu.test.application.dto.TestDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestConverter {

    public static TestDto.Testing toTestingDTO(
            String testing
    ) {
        return TestDto.Testing.builder()
                .testing(testing)
                .build();
    }

    public static TestDto.Exception toExceptionDTO(
            String testing
    ){
        return TestDto.Exception.builder()
                .testString(testing)
                .build();
    }
}
