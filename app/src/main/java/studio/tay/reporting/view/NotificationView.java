package studio.tay.reporting.view;

import java.util.List;

import studio.tay.reporting.base.BaseView;
import studio.tay.reporting.model.Notification;

public interface NotificationView extends BaseView{
    void onSuccessLoadNotification(List<Notification> notifications);
}
