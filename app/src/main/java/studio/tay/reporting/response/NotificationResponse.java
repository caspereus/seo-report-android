package studio.tay.reporting.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import studio.tay.reporting.model.Notification;

public class NotificationResponse {

    @SerializedName("data")
    List<Notification> notifications;

    public NotificationResponse(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}
