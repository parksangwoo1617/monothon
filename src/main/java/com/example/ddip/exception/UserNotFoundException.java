package com.example.ddip.exception;

import com.example.ddip.error.exception.ErrorCode;
import com.example.ddip.error.exception.ServerException;

public class UserNotFoundException extends ServerException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
