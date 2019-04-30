package studio.tay.reporting.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studio.tay.reporting.base.BasePresenter;
import studio.tay.reporting.response.ReportHistoryResponse;
import studio.tay.reporting.view.HistoryView;

public class HistoryPresenter<history extends HistoryView> extends BasePresenter {

    history historyView;

    public HistoryPresenter(history historyView) {
        this.historyView = historyView;
    }

    public void loadHistory(String client_id)
    {
        historyView.onShow();
        apiClass.load_history(client_id).enqueue(new Callback<ReportHistoryResponse>() {
            @Override
            public void onResponse(Call<ReportHistoryResponse> call, Response<ReportHistoryResponse> response) {
                historyView.getHttp(Integer.toString(response.code()));
                if (response.isSuccessful())
                {
                    historyView.onSuccessLoadHistory(response.body().getReports());
                    historyView.onHide();
                }
            }

            @Override
            public void onFailure(Call<ReportHistoryResponse> call, Throwable t) {
                historyView.onError(t.getMessage());
                historyView.onHide();
            }
        });
    }
}
