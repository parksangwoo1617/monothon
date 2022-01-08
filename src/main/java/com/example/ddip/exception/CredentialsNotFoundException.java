package com.example.ddip.exception;

import com.example.ddip.error.exception.ErrorCode;
import com.example.ddip.error.exception.ServerException;

public class CredentialsNotFoundException extends ServerException {
    public CredentialsNotFoundException() {
        super(ErrorCode.CREDENTIALS_NOT_FOUND);
    }
}
