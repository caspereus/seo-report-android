package studio.tay.reporting.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.adapter.NotificationAdapter;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.helper.PrefManager;
import studio.tay.reporting.model.Notification;
import studio.tay.reporting.presenter.NotificationPresenter;
import studio.tay.reporting.view.NotificationView;

public class NotificationActivity extends BaseActivity implements NotificationView {

    @BindView(R.id.notif_recycler)
    RecyclerView recyclerView;

    @BindView(R.id.swipe_notif)
    SwipeRefreshLayout swipeRefreshLayout;

    NotificationAdapter adapter;
    NotificationPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbars);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        presenter = new NotificationPresenter(this);
        adapter = new NotificationAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final PrefManager prefManager = new PrefManager(this);

        presenter.load_notif(String.valueOf(prefManager.getUserId()));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.load_notif(String.valueOf(prefManager.getUserId()));
            }
        });

    }

    @Override
    public void onSuccessLoadNotification(List<Notification> notifications) {
        adapter.replace_data(notifications);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onShow() {
        super.showLoading();
    }

    @Override
    public void onHide() {
        super.dismissLoading();
    }

    @Override
    public void onError(String error) {
        super.showError(error);
    }

    @Override
    public void getHttp(String http) {
        super.showHttp(http);
    }
}
