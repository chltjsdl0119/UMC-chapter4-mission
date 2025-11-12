package com.umc.gwnu.global.apipayload.handler;

import com.umc.gwnu.global.apipayload.CommonResponse;
import com.umc.gwnu.global.apipayload.code.BaseErrorCode;
import com.umc.gwnu.global.apipayload.code.GeneralErrorCode;
import com.umc.gwnu.global.apipayload.exception.GeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    // 애플리케이션에서 발생하는 커스텀 예외를 처리
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<CommonResponse<Void>> handleException(GeneralException ex) {
        return ResponseEntity.status(ex.getCode().getStatus())
                .body(CommonResponse.onFailure(ex.getCode(), null));
    }

    // 그 외의 정의되지 않은 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse<String>> handleException(Exception ex) {

        BaseErrorCode code = GeneralErrorCode.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(code.getStatus())
                .body(CommonResponse.onFailure(code, ex.getMessage()));
    }
}
