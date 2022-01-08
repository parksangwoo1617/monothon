package com.example.ddip.exception;

import com.example.ddip.error.exception.ErrorCode;
import com.example.ddip.error.exception.ServerException;

public class MismatchedPasswordException extends ServerException {
    public MismatchedPasswordException() {
        super(ErrorCode.MISMATCHED_PASSWORD);
    }
}
