package studio.tay.reporting.response;

import com.google.gson.annotations.SerializedName;

import studio.tay.reporting.model.Client;

public class AuthenticationResponse {

    String status;
    int code;
    @SerializedName("data")
    Client client;

    public AuthenticationResponse(String status, int code, Client client) {
        this.status = status;
        this.code = code;
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public Client getClient() {
        return client;
    }
}
