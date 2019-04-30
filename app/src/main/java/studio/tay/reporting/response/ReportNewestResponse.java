package studio.tay.reporting.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import studio.tay.reporting.model.AwsDay;
import studio.tay.reporting.model.Mor;
import studio.tay.reporting.model.Report;
import studio.tay.reporting.model.SMOAds;
import studio.tay.reporting.model.SMOFacebook;
import studio.tay.reporting.model.SMOInstagram;
import studio.tay.reporting.model.Seo;

public class ReportNewestResponse {

    String status,code,client_id;
    @SerializedName("smo_fb")
    SMOFacebook smoFacebook;
    @SerializedName("smo_ig")
    SMOInstagram smoInstagram;
    @SerializedName("smo_ad")
    SMOAds smoAds;
    @SerializedName("seo_google")
    Seo seo;
    @SerializedName("seo_aws")
    List<AwsDay> awsDay;
    @SerializedName("mor")
    Mor mor;
    @SerializedName("report")
    Report report;

    public ReportNewestResponse(String status, String code, String client_id, SMOFacebook smoFacebook, SMOInstagram smoInstagram, SMOAds smoAds, Seo seo, List<AwsDay> awsDay, Mor mor, Report report) {
        this.status = status;
        this.code = code;
        this.client_id = client_id;
        this.smoFacebook = smoFacebook;
        this.smoInstagram = smoInstagram;
        this.smoAds = smoAds;
        this.seo = seo;
        this.awsDay = awsDay;
        this.mor = mor;
        this.report = report;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getClient_id() {
        return client_id;
    }

    public SMOFacebook getSmoFacebook() {
        return smoFacebook;
    }

    public SMOInstagram getSmoInstagram() {
        return smoInstagram;
    }

    public SMOAds getSmoAds() {
        return smoAds;
    }

    public Seo getSeo() {
        return seo;
    }

    public List<AwsDay> getAwsDay() {
        return awsDay;
    }

    public Mor getMor() {
        return mor;
    }

    public Report getReport() {
        return report;
    }
}
