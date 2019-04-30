package studio.tay.reporting.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import studio.tay.reporting.R;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.helper.PrefManager;
import studio.tay.reporting.model.Client;
import studio.tay.reporting.presenter.LoginPresenter;
import studio.tay.reporting.view.LoginView;

public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.emailField)
    MaterialEditText emailField;
    @BindView(R.id.passwordField)
    MaterialEditText passwordField;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        super.setHideActionBar();

        loginPresenter = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(emailField.getText().toString()) || TextUtils.isEmpty(passwordField.getText().toString()))
                {
                    Toast.makeText(LoginActivity.this, "Fill the fields", Toast.LENGTH_SHORT).show();
                }else{
                    loginPresenter.login(emailField.getText().toString(),passwordField.getText().toString());
                }
            }
        });

    }

    @Override
    public void onSuccessLogin(String status, Client client) {
        if (status.equals("success"))
        {
            PrefManager prefManager = new PrefManager(this);
            prefManager.resetCurrentUser();
            prefManager.setUserId(Integer.parseInt(client.getId()));
            prefManager.setUserName(client.getName());
            prefManager.setUserEmail(client.getEmail());
            prefManager.setUserAddress(client.getAddress());
            prefManager.setUserPhone(client.getPhone());
            prefManager.setUserWeb(client.getWebsite());

            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }else{
            Toast.makeText(this, "Credential not match", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onBackPressed() {

    }
}
