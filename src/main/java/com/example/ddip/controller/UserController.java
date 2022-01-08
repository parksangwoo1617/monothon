package com.example.ddip.controller;

import com.example.ddip.dto.request.LoginRequest;
import com.example.ddip.dto.request.RegisterGoodsRequest;
import com.example.ddip.dto.request.SignUpRequest;
import com.example.ddip.dto.request.VerifyCodeRequest;
import com.example.ddip.dto.response.GoodsDetailInfoResponse;
import com.example.ddip.dto.response.GoodsInfoListResponse;
import com.example.ddip.dto.response.MypageResponse;
import com.example.ddip.dto.response.TokenResponse;
import com.example.ddip.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/goods")
    public GoodsInfoListResponse getGoodsList() {
        return userService.getGoodsInfoList();
    }

    @GetMapping("/goods/{goods_id}")
    public List<GoodsDetailInfoResponse> getGoodsDetailInfo(@PathVariable("goods_id") Integer goods_id) {
        return userService.getGoodsDetailInfo(goods_id);
    }

    @PutMapping("/goods/{goods_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String modifyStatus(@PathVariable("goods_id") Integer goods_id) {
        return userService.modifyStatus("판매 대기", goods_id);
    }

    @PutMapping("/goods")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void successPay(@RequestBody @Valid VerifyCodeRequest request) {
        userService.successPay(request);
    }

    @GetMapping("/users")
    public MypageResponse getMyInfo() {
        return userService.getMyInfo();
    }
}
