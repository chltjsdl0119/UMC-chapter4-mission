package com.umc.gwnu.global.apipayload.exception;

import com.umc.gwnu.global.apipayload.code.BaseErrorCode;

public class TestException extends GeneralException {
    public TestException(BaseErrorCode code) {
        super(code);
    }
}
