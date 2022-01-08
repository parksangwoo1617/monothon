package com.example.ddip.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class GoodsInfoListResponse {
    private final List<GoodsInfo> goods_list;

    @Getter
    @Builder
    public static class GoodsInfo {
        private final Integer goods_id;
        private final String image_url;
        private final String category;
        private final String nickname;
        private final String goods_name;
        private final String time;
        private final String price;
    }

    public static GoodsInfo of(
            Integer goods_id,
            String image_url,
            String category,
            String nickname,
            String goods_name,
            String time,
            String price
    ) {
        return new GoodsInfo(goods_id, image_url, category, nickname, goods_name, time, price);
    }
}
