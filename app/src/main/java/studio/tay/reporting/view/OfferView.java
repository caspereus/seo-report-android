package studio.tay.reporting.view;

import java.util.List;

import studio.tay.reporting.base.BaseView;
import studio.tay.reporting.model.Offer;

public interface OfferView extends BaseView {

    void onSuccessLoadOffer(List<Offer> offers);

}
