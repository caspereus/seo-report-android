package studio.tay.reporting.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import studio.tay.reporting.model.Bill;

public class BillResponse {
    @SerializedName("data")
    List<Bill> bills;

    public BillResponse(List<Bill> bills) {
        this.bills = bills;
    }

    public List<Bill> getBills() {
        return bills;
    }
}
