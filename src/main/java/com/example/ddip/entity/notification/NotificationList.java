package com.example.ddip.entity.notification;

import com.example.ddip.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NotificationList {
    @EmbeddedId
    private NotificationId notificationId;

    @MapsId("user_id")
    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id")
    private User user_id;

    @MapsId("notification_id")
    @ManyToOne
    @JoinColumn(referencedColumnName = "notification_id")
    private Notification notification_id;
}
