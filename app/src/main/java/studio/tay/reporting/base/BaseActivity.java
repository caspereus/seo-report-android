package studio.tay.reporting.base;

import android.app.ProgressDialog;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import studio.tay.reporting.R;
import studio.tay.reporting.model.AwsDay;
import studio.tay.reporting.model.Mor;
import studio.tay.reporting.model.Report;
import studio.tay.reporting.model.SMOAds;
import studio.tay.reporting.model.SMOFacebook;
import studio.tay.reporting.model.SMOInstagram;
import studio.tay.reporting.model.Seo;


public class BaseActivity extends AppCompatActivity {

    public static SMOFacebook smoFacebook;
    public static SMOInstagram smoInstagram;
    public static SMOAds smoAds;
    public static Seo seo;
    public static List<AwsDay> awsDay;
    public static Mor mor;
    public static Report report;

    ProgressDialog progressDialog;
    public RecyclerView recyclerView;


    public void setUpActionBar(String title)
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    public void setHideActionBar()
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void showError(String error)
    {
        Log.e("HTTP ERROR : ",error);
    }

    public void showMessage(String message)
    {
        Log.d("MESSAGE : ",message);
    }

    public void showHttp(String http)
    {
        Log.d("HTTP STATUS : ",http);
    }

    public void showLoading()
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Tunggu Sebentar..");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void changeStatusBar() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    public void dismissLoading()
    {
        progressDialog.dismiss();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
