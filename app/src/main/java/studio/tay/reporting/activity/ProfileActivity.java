package studio.tay.reporting.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.helper.PrefManager;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.textname)
    TextView textName;
    @BindView(R.id.textmail)
    TextView textMail;
    @BindView(R.id.textwebsite)
    TextView textWebsite;
    @BindView(R.id.textphone)
    TextView textPhone;
    @BindView(R.id.textaddress)
    TextView textAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbars);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        PrefManager prefManager = new PrefManager(this);

        Log.d("Namanya",prefManager.getUserPhone());

        textName.setText("Putay");
        textMail.setText(prefManager.getUserEmail());
        textWebsite.setText(prefManager.getUserWeb());
        textPhone.setText(prefManager.getUserPhone());
        textAddress.setText(prefManager.getUserAddress());

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
