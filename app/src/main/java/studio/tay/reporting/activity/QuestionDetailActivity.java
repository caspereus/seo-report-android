package studio.tay.reporting.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.config.ClientConfig;

public class QuestionDetailActivity extends AppCompatActivity {

    @BindView(R.id.textQuestion)
    TextView textQuestion;

    @BindView(R.id.textAnswer)
    TextView textAnswer;

    @BindView(R.id.layoutHidden)
    LinearLayout linearLayout;

    @BindView(R.id.imageAttach)
    ImageView imageAttach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbars);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();

        textQuestion.setText(bundle.getString("question"));
        textAnswer.setText(bundle.getString("answer"));
        if (bundle.getString("image") == null)
        {
            linearLayout.setVisibility(View.GONE);
        }else{
            linearLayout.setVisibility(View.VISIBLE);
            Picasso.get().load(ClientConfig.imageUrl+"images/question/"+bundle.getString("image")).into(imageAttach);
        }

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
