package com.example.ddip.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotNull(message = "id는 null일 수 없습니다.")
    private String id;

    @NotNull(message = "password는 null일 수 없습니다.")
    private String password;

    @NotNull(message = "nickname은 null일 수 없습니다.")
    private String nickname;

    @NotNull(message = "phone_number은 null일 수 없습니다.")
    private String phone_number;
}
