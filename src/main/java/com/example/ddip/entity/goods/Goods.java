package com.example.ddip.entity.goods;

import com.example.ddip.entity.attachment.Attachment;
import com.example.ddip.entity.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@NamedQuery(
        name = "Goods.findAllByGoodsStatus",
        query = "select g from Goods g where g.status = :status order by g.id DESC"
)
public class Goods {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 30, nullable = false)
    private String price;

    @Column(length = 255, nullable = false)
    private String description;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String category;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String location;

    @Setter
    @Column(length = 100, nullable = false)
    private String status;

    @Setter
    private String verifyCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "consumer_id")
    private User consumer;

    @Setter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image")
    private Attachment image;
}
