package com.example.ddip.exception;

import com.example.ddip.error.exception.ErrorCode;
import com.example.ddip.error.exception.ServerException;

public class AlreadyExistNumberException extends ServerException {
    public AlreadyExistNumberException() {
        super(ErrorCode.ALREADY_EXIST_NUMBER);
    }
}
