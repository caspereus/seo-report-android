package studio.tay.reporting.activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.Part;
import studio.tay.reporting.R;

public class OfferDetailActivity extends AppCompatActivity {

    @BindView(R.id.offerImage)
    ImageView offerImage;

    @BindView(R.id.offerTitle)
    TextView textTitle;

    @BindView(R.id.offerSummary)
    TextView textSummary;

    @BindView(R.id.offerDate)
    TextView textDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_detail);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbars);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();

        Picasso.get().load(bundle.getString("cover")).into(offerImage);
        textTitle.setText(bundle.getString("title"));
        textSummary.setText(bundle.getString("summary"));
        textDate.setText(bundle.getString("date"));


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
