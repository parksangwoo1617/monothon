package com.example.ddip.entity.goods;

import com.example.ddip.entity.attachment.Attachment;
import com.example.ddip.entity.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
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

    @Column(length = 100, nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image")
    private Attachment image;
}
