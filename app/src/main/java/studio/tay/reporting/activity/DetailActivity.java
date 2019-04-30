package studio.tay.reporting.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.adapter.SectionsPagerAdapter;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.fragment.AWSFragment;
import studio.tay.reporting.fragment.MORFragment;
import studio.tay.reporting.fragment.ReportFragment;
import studio.tay.reporting.fragment.SEOFragment;
import studio.tay.reporting.fragment.SMOFragment;
import studio.tay.reporting.model.AwsDay;
import studio.tay.reporting.model.Mor;
import studio.tay.reporting.model.Report;
import studio.tay.reporting.model.SMOAds;
import studio.tay.reporting.model.SMOFacebook;
import studio.tay.reporting.model.SMOInstagram;
import studio.tay.reporting.model.Seo;
import studio.tay.reporting.presenter.DetailPresenter;
import studio.tay.reporting.view.DetailView;

public class DetailActivity extends BaseActivity implements DetailView {

    SectionsPagerAdapter mSectionsPagerAdapter;
    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    Fragment[] fragments;
    DetailPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(bundle.getString("title"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        presenter = new DetailPresenter(this);
        presenter.loadDetail(bundle.getString("id"));



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onSuccessLoadDetail(SMOFacebook smoFacebook, SMOInstagram smoInstagram, SMOAds smoAds, Seo seo, List<AwsDay> awsDays, Mor mor, Report report) {

        if (report.getSeo_type().equals("google")) {
            fragments = new Fragment[]{
                    new SEOFragment(seo), new SMOFragment(smoFacebook,smoInstagram,smoAds), new MORFragment(mor),new ReportFragment(report),
            };
        }else{
            fragments = new Fragment[]{
                    new AWSFragment(), new SMOFragment(smoFacebook,smoInstagram,smoAds), new MORFragment(mor),new ReportFragment(report)
            };
        }

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        this.setAllValue(report);
    }

    private void setAllValue(Report report)
    {
        if (report.getSeo_type().equals("google"))
        {

        }else{
            AWSFragment.setValue();
        }
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
