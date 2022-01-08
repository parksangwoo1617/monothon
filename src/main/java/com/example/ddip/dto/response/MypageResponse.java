package com.example.ddip.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MypageResponse {
    private final String nickname;
    private final String user_id;

    private final List<MypageInfo> sale_list;
    private final List<MypageInfo> purchase_list;

    @Getter
    @Builder
    public static class MypageInfo {
        private final Integer goods_id;
        private final String nickname;
        private final String image_url;
        private final String goods_name;
        private final String location;
        private final String time;
        private final String price;
        private final String category;
    }

    public static MypageInfo of(
            Integer goods_id,
            String nickname,
            String image_url,
            String goods_name,
            String location,
            String time,
            String price,
            String category
    ) {
        return new MypageInfo(goods_id, nickname, image_url, goods_name, location, time, price, category);
    }
}
