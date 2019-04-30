package studio.tay.reporting.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import studio.tay.reporting.model.Offer;

public class OfferResponse {
    @SerializedName("data")
    List<Offer> list;

    public OfferResponse(List<Offer> list) {
        this.list = list;
    }

    public List<Offer> getList() {
        return list;
    }
}
