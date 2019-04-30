package studio.tay.reporting.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studio.tay.reporting.base.BasePresenter;
import studio.tay.reporting.response.BillResponse;
import studio.tay.reporting.view.BillView;

public class BillPresenter<bill extends BillView> extends BasePresenter {

    bill billView;

    public BillPresenter(bill billView) {
        this.billView = billView;
    }

    public void load_bill(String id)
    {
        billView.onShow();
        apiClass.load_bill(id).enqueue(new Callback<BillResponse>() {
            @Override
            public void onResponse(Call<BillResponse> call, Response<BillResponse> response) {
                billView.getHttp(Integer.toString(response.code()));
                if (response.isSuccessful())
                {
                    billView.onSuccessLoadBill(response.body().getBills());
                    billView.onHide();
                }
            }

            @Override
            public void onFailure(Call<BillResponse> call, Throwable t) {
                billView.onError(t.getMessage());
                billView.onHide();
            }
        });
    }

}
