package com.example.ddip.exception;

import com.example.ddip.error.exception.ErrorCode;
import com.example.ddip.error.exception.ServerException;

public class UnexpectedException extends ServerException {
    public UnexpectedException() {
        super(ErrorCode.UNEXPECTED_ERROR);
    }
}
