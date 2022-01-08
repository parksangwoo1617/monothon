package com.example.ddip.entity.notification;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class NotificationId implements Serializable {
    @Column(name = "user_id")
    private String user_id;

    @Column(name = "notification_id")
    private Integer notification_id;
}
