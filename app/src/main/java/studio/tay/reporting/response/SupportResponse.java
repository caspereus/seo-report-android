package studio.tay.reporting.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import studio.tay.reporting.model.Support;

public class SupportResponse {

    String status,code;

    @SerializedName("data")
    List<Support> supports;

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public List<Support> getSupports() {
        return supports;
    }
}
