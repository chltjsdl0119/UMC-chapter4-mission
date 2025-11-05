package com.umc.gwnu.global.apipayload;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.umc.gwnu.global.apipayload.code.BaseErrorCode;

@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public record CommonResponse<T>(
        @JsonProperty("success")
        boolean success,

        @JsonProperty("code")
        String code,

        @JsonProperty("message")
        String message,

        @JsonProperty("result")
        T result
) {
    public static <T> CommonResponse<T> onSuccess(BaseErrorCode code, T result) {
        return new CommonResponse<>(true, code.getCode(), code.getMessage(), result);
    }

    public static <T> CommonResponse<T> onFailure(BaseErrorCode code, T result) {
        return new CommonResponse<>(false, code.getCode(), code.getMessage(), result);
    }
}
