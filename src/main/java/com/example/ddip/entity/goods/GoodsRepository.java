package com.example.ddip.entity.goods;

import com.example.ddip.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    public List<Goods> findAllByGoodsStatus(@Param("status") String status);
    public Optional<Goods> findByVerifyCode(String verifyCode);
    public List<Goods> findAllBySeller(User user);
    public List<Goods> findAllByConsumer(User user);
}
