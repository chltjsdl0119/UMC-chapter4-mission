package com.umc.gwnu.test.application.dto;

import lombok.Builder;
import lombok.Getter;

public class TestDto {

    @Builder
    @Getter
    public static class Testing {
        private String testing;
    }

    @Builder
    @Getter
    public static class Exception {
        private String testString;
    }
}