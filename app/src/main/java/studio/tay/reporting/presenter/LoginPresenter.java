package studio.tay.reporting.presenter;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studio.tay.reporting.base.BasePresenter;
import studio.tay.reporting.response.AuthenticationResponse;
import studio.tay.reporting.view.LoginView;

public class LoginPresenter<login extends LoginView> extends BasePresenter {

    login loginview;

    public LoginPresenter(login loginview) {
        this.loginview = loginview;
    }

    public void login(String email, String password)
    {

        loginview.onShow();
        String token = FirebaseInstanceId.getInstance().getToken();
        apiClass.client_login(email,password,token).enqueue(new Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {
                loginview.getHttp(Integer.toString(response.code()));
                if (response.isSuccessful())
                {
                    loginview.onSuccessLogin(response.body().getStatus(),response.body().getClient());
                    loginview.onHide();
                }
            }

            @Override
            public void onFailure(Call<AuthenticationResponse> call, Throwable t) {
                loginview.onError(t.getMessage());
                loginview.onHide();
            }
        });

    }


}
