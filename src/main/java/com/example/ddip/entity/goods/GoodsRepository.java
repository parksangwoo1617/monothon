package com.example.ddip.entity.goods;

import com.example.ddip.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    public List<Goods> findAllByGoodsStatus(@Param("status") String status);
    public Optional<Goods> findByVerifyCode(String verifyCode);
    @Query("select g from Goods g where g.status <> :status and g.seller = :seller")
    public List<Goods> findAllBySeller(@Param("status") String status, @Param("seller") User seller);
    @Query("select g from Goods g where g.status = :status and g.consumer = :consumer")
    public List<Goods> findAllByConsumer(@Param("status") String status, @Param("consumer") User consumer);
}
