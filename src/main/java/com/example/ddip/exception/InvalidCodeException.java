package com.example.ddip.exception;

import com.example.ddip.error.exception.ErrorCode;
import com.example.ddip.error.exception.ServerException;

public class InvalidCodeException extends ServerException {

    public InvalidCodeException() {
        super(ErrorCode.INVALID_CODE);
    }
}
