package studio.tay.reporting.network;


import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import studio.tay.reporting.model.Contact;
import studio.tay.reporting.response.AuthenticationResponse;
import studio.tay.reporting.response.BillResponse;
import studio.tay.reporting.response.MainResponse;
import studio.tay.reporting.response.NotificationResponse;
import studio.tay.reporting.response.OfferResponse;
import studio.tay.reporting.response.ReportHistoryResponse;
import studio.tay.reporting.response.ReportNewestResponse;
import studio.tay.reporting.response.SupportResponse;

public interface ApiClass {

    @FormUrlEncoded
    @POST("client/login")
    Call<AuthenticationResponse> client_login(
            @Field("email") String email,
            @Field("password") String password,
            @Field("device_token") String device_token
    );

    @GET("report/new/{user_id}")
    Call<ReportNewestResponse> load_report(@Path("user_id") String user_id);

    @GET("report/all/{user_id}")
    Call<ReportHistoryResponse> load_history(@Path("user_id") String user_id);

    @GET("report/detail/{report_id}")
    Call<ReportNewestResponse> load_detail_report(@Path("report_id") String report_id);

    @GET("bill/client/{id}")
    Call<BillResponse> load_bill(@Path("id") String id);

    @GET("offer/list")
    Call<OfferResponse> load_offer();

    @GET("notifications/{client_id}")
    Call<NotificationResponse> load_notif(@Path("client_id") String client_id);

    @Multipart
    @POST("question/store")
    Call<MainResponse> sendQuestion(@PartMap Map<String, RequestBody> map,
                                    @Part("client_id") RequestBody client_id,
                                    @Part("question") RequestBody question
    );

    @FormUrlEncoded
    @POST("question/store_as")
    Call<MainResponse> sendQuestionAS(
            @Field("client_id") String client_id,
            @Field("question") String question
    );

    @GET("question/list")
    Call<SupportResponse> loadQuestion();

    @GET("contact/get")
    Call<Contact> loadContact();



}
