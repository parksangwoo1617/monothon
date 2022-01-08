package com.example.ddip.entity.goods;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    public List<Goods> findAllByOrderByIdDesc();
}
