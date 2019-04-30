package studio.tay.reporting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.SubscriptionEventListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.adapter.SectionsPagerAdapter;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.fragment.AWSFragment;
import studio.tay.reporting.fragment.HistoryFragment;
import studio.tay.reporting.fragment.MORFragment;
import studio.tay.reporting.fragment.ReportFragment;
import studio.tay.reporting.fragment.SEOFragment;
import studio.tay.reporting.fragment.SMOFragment;
import studio.tay.reporting.helper.PrefManager;
import studio.tay.reporting.model.AwsDay;
import studio.tay.reporting.model.Mor;
import studio.tay.reporting.model.Report;
import studio.tay.reporting.model.SMOAds;
import studio.tay.reporting.model.SMOFacebook;
import studio.tay.reporting.model.SMOInstagram;
import studio.tay.reporting.model.Seo;
import studio.tay.reporting.presenter.MainPresenter;
import studio.tay.reporting.view.MainView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,MainView {

    SectionsPagerAdapter mSectionsPagerAdapter;
    @BindView(R.id.container)
    ViewPager mViewPager;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.container_fragment)
    FrameLayout frameLayout;

    MainPresenter mainPresenter;
    PrefManager prefManager;

    Fragment[] fragments;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        mainPresenter = new MainPresenter(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        frameLayout.setVisibility(View.GONE);
        prefManager = new PrefManager(this);
        loadData();
        FirebaseMessaging.getInstance().subscribeToTopic("all");

        PusherOptions options = new PusherOptions();
        options.setCluster("ap1");
        Pusher pusher = new Pusher("61c1e1ab1529c29341b6", options);

        Channel channel = pusher.subscribe("my-channel");

        channel.bind("my-event", new SubscriptionEventListener() {
            @Override
            public void onEvent(String channelName, String eventName, final String data) {
                loadData();
            }
        });

        pusher.connect();

    }

    public void loadData()
    {
        mainPresenter.load(Integer.toString(prefManager.getUserId()));
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {


            if (doubleBackToExitPressedOnce) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return;
            }

            doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            mainPresenter.load(Integer.toString(prefManager.getUserId()));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        PrefManager prefManager = new PrefManager(this);
        switch (id){
            case R.id.nav_logout:
                prefManager.resetCurrentUser();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
            case R.id.nav_home:
                tabLayout.setVisibility(View.VISIBLE);
                frameLayout.setVisibility(View.GONE);
                mViewPager.setVisibility(View.VISIBLE);
                mainPresenter.load(Integer.toString(prefManager.getUserId()));
                break;
            case R.id.nav_report:
                fragmentChange(new HistoryFragment());
                break;
            case R.id.nav_bill:
                startActivity(new Intent(getApplicationContext(),BillActivity.class));
                break;
            case R.id.nav_offer:
                startActivity(new Intent(getApplicationContext(),OfferActivity.class));
                break;
            case R.id.nav_notifications:
                startActivity(new Intent(getApplicationContext(),NotificationActivity.class));
                break;
            case R.id.nav_support:
                startActivity(new Intent(getApplicationContext(),SupportActivity.class));
                break;
            case R.id.nav_profile:
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                break;
            case R.id.nav_contact:
                startActivity(new Intent(getApplicationContext(),ContactActivity.class));
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onSuccessLoad(SMOFacebook smoFacebook, SMOInstagram smoInstagram, SMOAds smoAds, Seo seo, List<AwsDay> awsDays, Mor mor, Report report) {
        if (report.getSeo_type().equals("google")) {
            fragments = new Fragment[]{
                    new SEOFragment(seo), new SMOFragment(smoFacebook,smoInstagram,smoAds), new MORFragment(mor),new ReportFragment(report),
            };
        }else{
            fragments = new Fragment[]{
                    new AWSFragment(), new SMOFragment(smoFacebook,smoInstagram,smoAds), new MORFragment(mor),new ReportFragment(report),
            };
        }

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        this.setAllValue(report);

    }

    private void fragmentChange(Fragment fragment)
    {
        tabLayout.setVisibility(View.GONE);
        frameLayout.setVisibility(View.VISIBLE);
        mViewPager.setVisibility(View.GONE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_fragment,fragment).commit();
    }


    private void setAllValue(Report report)
    {

        if (report.getSeo_type().equals("google"))
        {

        }else if (report.getSeo_type().equals("aws")){
            AWSFragment.setValue();
        }else{

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
