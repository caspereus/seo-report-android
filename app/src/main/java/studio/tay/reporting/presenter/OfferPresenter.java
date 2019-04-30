package studio.tay.reporting.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studio.tay.reporting.base.BasePresenter;
import studio.tay.reporting.response.OfferResponse;
import studio.tay.reporting.view.OfferView;

public class OfferPresenter<offer extends OfferView> extends BasePresenter {

    offer offerView;

    public OfferPresenter(offer offerView) {
        this.offerView = offerView;
    }

    public void load_offer()
    {
        offerView.onShow();
        apiClass.load_offer().enqueue(new Callback<OfferResponse>() {
            @Override
            public void onResponse(Call<OfferResponse> call, Response<OfferResponse> response) {
                offerView.getHttp(Integer.toString(response.code()));
                if (response.isSuccessful())
                {
                    offerView.onSuccessLoadOffer(response.body().getList());
                    offerView.onHide();
                }
            }

            @Override
            public void onFailure(Call<OfferResponse> call, Throwable t) {
                offerView.onError(t.getMessage());
                offerView.onHide();
            }
        });
    }
}
