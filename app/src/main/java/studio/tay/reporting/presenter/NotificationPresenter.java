package studio.tay.reporting.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studio.tay.reporting.base.BasePresenter;
import studio.tay.reporting.response.NotificationResponse;
import studio.tay.reporting.view.NotificationView;

public class NotificationPresenter<notification extends NotificationView> extends BasePresenter {

    notification notifView;

    public NotificationPresenter(notification notifView) {
        this.notifView = notifView;
    }

    public void load_notif(String client_id)
    {
        notifView.onShow();
        apiClass.load_notif(client_id).enqueue(new Callback<NotificationResponse>() {
            @Override
            public void onResponse(Call<NotificationResponse> call, Response<NotificationResponse> response) {
                notifView.getHttp(Integer.toString(response.code()));
                if (response.isSuccessful())
                {
                    notifView.onSuccessLoadNotification(response.body().getNotifications());
                    notifView.onHide();
                }
            }

            @Override
            public void onFailure(Call<NotificationResponse> call, Throwable t) {
                notifView.onError(t.getMessage());
                notifView.onHide();
            }
        });
    }
}
