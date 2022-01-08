package com.example.ddip.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    USER_NOT_FOUND(404, "user not found"),
    INVALID_TOKEN(401, "Invalid token"),
    EXPIRED_ACCESS_TOKEN(401, "Expired access token"),
    MISMATCHED_PASSWORD(400, "Mismatched password"),
    CREDENTIALS_NOT_FOUND(401, "Credentials not found"),
    ALREADY_EXIST_ID(409, "Already Exist Id"),
    ALREADY_EXIST_NAME(409, "Already Exist Name"),
    UNEXPECTED_ERROR(500, "Unexpected Error"),
    INVALID_CODE(400, "Invalid Code"),
    ALREADY_EXIST_NUMBER(409, "Already Exist Phone Number");

    private final int status;
    private final String message;
}
