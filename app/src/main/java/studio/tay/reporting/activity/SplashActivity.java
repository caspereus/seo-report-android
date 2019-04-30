package studio.tay.reporting.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import studio.tay.reporting.R;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.helper.PrefManager;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        super.setHideActionBar();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                PrefManager prefManager = new PrefManager(getApplicationContext());
                if (TextUtils.isEmpty(prefManager.getUserEmail())){
                    Intent splash = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(splash);
                }else{
                    Intent splash = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(splash);
                }
            }
        },3000);
    }
}
