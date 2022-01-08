package com.example.ddip.exception;

import com.example.ddip.error.exception.ErrorCode;
import com.example.ddip.error.exception.ServerException;

public class InvalidTokenException extends ServerException {

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
