package studio.tay.reporting.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.base.BasePresenter;
import studio.tay.reporting.helper.PrefManager;
import studio.tay.reporting.response.ReportNewestResponse;
import studio.tay.reporting.view.MainView;

public class MainPresenter<main extends MainView> extends BasePresenter {

    main mainView;

    public MainPresenter(main mainView) {
        this.mainView = mainView;
    }

    public void load(String client_id)
    {
        mainView.onShow();
        apiClass.load_report(client_id).enqueue(new Callback<ReportNewestResponse>() {
            @Override
            public void onResponse(Call<ReportNewestResponse> call, Response<ReportNewestResponse> response) {
                mainView.getHttp(Integer.toString(response.code()));
                if (response.isSuccessful())
                {
                    BaseActivity.awsDay       = response.body().getAwsDay();
                    BaseActivity.mor          = response.body().getMor();
                    BaseActivity.report       = response.body().getReport();
                    BaseActivity.seo          = response.body().getSeo();
                    BaseActivity.smoAds       = response.body().getSmoAds();
                    BaseActivity.smoFacebook  = response.body().getSmoFacebook();
                    BaseActivity.smoInstagram = response.body().getSmoInstagram();

                    mainView.onSuccessLoad(
                            BaseActivity.smoFacebook,
                            BaseActivity.smoInstagram,
                            BaseActivity.smoAds,
                            BaseActivity.seo,
                            BaseActivity.awsDay,
                            BaseActivity.mor,
                            BaseActivity.report
                    );

                    mainView.onHide();

                }
            }

            @Override
            public void onFailure(Call<ReportNewestResponse> call, Throwable t) {
                mainView.onError(t.getMessage());
                mainView.onHide();
            }
        });
    }


}
