package studio.tay.reporting.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.adapter.OfferAdapter;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.model.Offer;
import studio.tay.reporting.presenter.OfferPresenter;
import studio.tay.reporting.view.OfferView;

public class OfferActivity extends BaseActivity implements OfferView{

    @BindView(R.id.recyclerOffer)
    RecyclerView recyclerOffer;

    OfferAdapter offerAdapter;
    OfferPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbars);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        presenter    = new OfferPresenter(this);
        offerAdapter = new OfferAdapter(this);
        recyclerOffer.setAdapter(offerAdapter);
        recyclerOffer.setLayoutManager(new LinearLayoutManager(this));
        presenter.load_offer();

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onSuccessLoadOffer(List<Offer> offers) {
        offerAdapter.replace_data(offers);
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
