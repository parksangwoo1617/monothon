package com.example.ddip.exception;

import com.example.ddip.error.exception.ErrorCode;
import com.example.ddip.error.exception.ServerException;

public class AlreadyExistNameException extends ServerException {
    public AlreadyExistNameException() {
        super(ErrorCode.ALREADY_EXIST_NAME);
    }
}
