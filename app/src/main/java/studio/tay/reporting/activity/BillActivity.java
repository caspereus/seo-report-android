package studio.tay.reporting.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.adapter.BillAdapter;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.helper.PrefManager;
import studio.tay.reporting.model.Bill;
import studio.tay.reporting.presenter.BillPresenter;
import studio.tay.reporting.view.BillView;

public class BillActivity extends BaseActivity implements BillView {

    @BindView(R.id.bill_recycle)
    RecyclerView recyclerView;

    BillAdapter adapter;

    BillPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbars);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        presenter = new BillPresenter(this);

        adapter = new BillAdapter(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PrefManager prefManager = new PrefManager(this);

        presenter.load_bill(String.valueOf(prefManager.getUserId()));
    }

    @Override
    public void onSuccessLoadBill(List<Bill> bills) {
        adapter.replace_data(bills);
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
