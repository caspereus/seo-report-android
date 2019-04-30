package studio.tay.reporting.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import studio.tay.reporting.model.Report;

public class ReportHistoryResponse {
    String code,status;
    @SerializedName("data")
    List<Report> reports;

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public List<Report> getReports() {
        return reports;
    }
}
