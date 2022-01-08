package com.example.ddip.exception;

import com.example.ddip.error.exception.ErrorCode;
import com.example.ddip.error.exception.ServerException;

public class AlreadyExistIdException extends ServerException {
    public AlreadyExistIdException() {
        super(ErrorCode.ALREADY_EXIST_ID);
    }
}
