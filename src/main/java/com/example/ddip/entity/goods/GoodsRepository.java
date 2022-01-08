package com.example.ddip.entity.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    public List<Goods> findAllByGoodsStatus(@Param("status") String status);
}
