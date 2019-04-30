package studio.tay.reporting.response;

public class MainResponse {

    String status,code;

    public MainResponse(String status, String code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
}
