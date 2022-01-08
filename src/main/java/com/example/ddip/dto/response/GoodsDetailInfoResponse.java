package com.example.ddip.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class GoodsDetailInfoResponse {
    private final Integer goods_id;
    private final String image_url;
    private final String nickname;
    private final String category;
    private final String goods_name;
    private final LocalDateTime time;
    private final String price;
    private final String description;
}
