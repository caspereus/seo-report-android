package studio.tay.reporting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.adapter.SupportAdapter;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.model.Support;
import studio.tay.reporting.presenter.QuestionPresenter;
import studio.tay.reporting.view.QuestionView;

public class SupportActivity extends BaseActivity implements QuestionView {

    @BindView(R.id.recyclerQuestion)
    RecyclerView recyclerView;

    SupportAdapter adapter;
    QuestionPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddQuestionActivity.class));
            }
        });

        adapter = new SupportAdapter(this);

        presenter = new QuestionPresenter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter.loadQuestion();

    }

    @Override
    public boolean onSupportNavigateUp() {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
        return true;
    }

    @Override
    public void onSuccessSendQuestion(String status) {

    }

    @Override
    public void onSuccessLoadQuestions(List<Support> supports) {
        adapter.replace_data(supports);
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
