package com.example.ddip.controller;

import com.example.ddip.dto.request.LoginRequest;
import com.example.ddip.dto.request.RegisterGoodsRequest;
import com.example.ddip.dto.request.SignUpRequest;
import com.example.ddip.dto.response.TokenResponse;
import com.example.ddip.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid SignUpRequest request) {
        userService.signUp(request);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginRequest request) {
        return userService.login(request);
    }

    @PostMapping("/goods")
    public void registerGoods(@ModelAttribute RegisterGoodsRequest request) {
        userService.registerGoods(request);
    }

}
