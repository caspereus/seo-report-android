package studio.tay.reporting.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.base.BasePresenter;
import studio.tay.reporting.response.ReportNewestResponse;
import studio.tay.reporting.view.DetailView;

public class DetailPresenter<detail extends DetailView> extends BasePresenter {

    detail detailView;

    public DetailPresenter(detail detailView) {
        this.detailView = detailView;
    }

    public void loadDetail(String report_id)
    {
        detailView.onShow();
        apiClass.load_detail_report(report_id).enqueue(new Callback<ReportNewestResponse>() {
            @Override
            public void onResponse(Call<ReportNewestResponse> call, Response<ReportNewestResponse> response) {
                detailView.getHttp(Integer.toString(response.code()));
                if (response.isSuccessful())
                {
                    if (response.isSuccessful())
                    {
                        BaseActivity.awsDay       = response.body().getAwsDay();
                        BaseActivity.mor          = response.body().getMor();
                        BaseActivity.report       = response.body().getReport();
                        BaseActivity.seo          = response.body().getSeo();
                        BaseActivity.smoAds       = response.body().getSmoAds();
                        BaseActivity.smoFacebook  = response.body().getSmoFacebook();
                        BaseActivity.smoInstagram = response.body().getSmoInstagram();

                        detailView.onSuccessLoadDetail(
                                BaseActivity.smoFacebook,
                                BaseActivity.smoInstagram,
                                BaseActivity.smoAds,
                                BaseActivity.seo,
                                BaseActivity.awsDay,
                                BaseActivity.mor,
                                BaseActivity.report
                        );

                        detailView.onHide();

                    }
                }
            }

            @Override
            public void onFailure(Call<ReportNewestResponse> call, Throwable t) {
                detailView.onError(t.getMessage());
                detailView.onHide();
            }
        });
    }

}
