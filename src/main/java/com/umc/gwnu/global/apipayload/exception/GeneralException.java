package com.umc.gwnu.global.apipayload.exception;

import com.umc.gwnu.global.apipayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GeneralException extends RuntimeException {
    private final BaseErrorCode code;
}
